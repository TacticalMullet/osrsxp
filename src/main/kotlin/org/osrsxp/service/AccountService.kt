package org.osrsxp.service

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.osrsxp.exception.AccountNotFoundException
import org.osrsxp.toolkit.service.DBService

const val OK: Int = 200
const val BASE_URL: String = "http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player="

class AccountService {
    fun findAccountInfo(accountName: String): List<Skill> {
        FuelManager.instance.basePath = BASE_URL

        val (_, _, result) = Fuel.get("${encodeName(accountName)}").responseString()

        when (result) {
            is Result.Failure -> {
                throw AccountNotFoundException("services.runescape.com returned 404; account '$accountName' was not found")
            }
            is Result.Success -> {
                return buildSkillset(result.get())
            }
        }
    }

    fun refreshStaleAccounts() {
        FuelManager.instance.basePath = BASE_URL
        DBService().findAllStaleAccountNames().map { accountName ->
            "${encodeName(accountName)}".httpGet().responseString { request, response, result ->
                DBService().saveAccountData(
                        Account(accountName, buildSkillset(result.get()))
                )
            }
        }
    }

    fun refreshAllAccounts() {
        FuelManager.instance.basePath = BASE_URL
        DBService().findAllAccountNames().map { accountName ->
            "${encodeName(accountName)}".httpGet().responseString { request, response, result ->
                DBService().saveAccountData(
                    Account(accountName, buildSkillset(result.get()))
                )
            }
        }
    }

    private fun encodeName(accountName: String): String {
        return accountName.replace("\\s+".toRegex(), "%20")
    }

    fun buildSkillset(statsRaw: String): List<Skill> {
        val stats = statsRaw
                .replace("\n", ",")
                .replace("\\s+".toRegex(), "")
                .split(",")
                .filter { it != "" }
                .map { it.toLong() }

        return SkillMap.values().map {
            Skill(it.name, stats[it.rankIndex], stats[it.levelIndex].toInt(), stats[it.xpIndex])
        }
    }
}
