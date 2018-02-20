package org.osrsxp

import khttp.get
import org.osrsxp.exception.AccountNotFoundException
import org.osrsxp.service.Skill

const val OK: Int = 200

class AccountService {
    fun findAccountInfo(accountName: String): List<Skill> {
        val r = get("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=${encodeName(accountName)}")
        if (r.statusCode != OK)
            throw AccountNotFoundException("services.runescape.com returned 404; account '$accountName' was not found")

        val stats = r.text
                .replace("\n", ",")
                .replace("\\s+".toRegex(), "")
                .split(",")
                .filter { it != "" }
                .map { it.toLong() }
        return buildSkillset(stats)
    }

    private fun encodeName(accountName: String): String {
        return accountName.replace("\\s+".toRegex(), "%20")
    }

    fun buildSkillset(stats: List<Long>): List<Skill> {
        return SkillMap.values().map {
            Skill(it.name, stats[it.rankIndex], stats[it.levelIndex], stats[it.xpIndex])
        }
    }
}
