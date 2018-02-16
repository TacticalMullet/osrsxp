package org.osrsxp

import khttp.get

class AccountService {
    fun find(accountName: String): Account {
        val statsRaw = get("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=${encodeName(accountName)}")
                .text
                .replace("\n", ",")
                .replace("\\s+".toRegex(), "")
                .split(",")
                .filter { it != "" }
                .map { it.toInt() }
        return Account(accountName, buildSkillset(statsRaw))
    }

    private fun encodeName(accountName: String): String {
        return accountName.replace("\\s+".toRegex(), "%20")
    }

    fun buildSkillset(stats: List<Int>): List<Skill> {
        return SkillMap.values().map {
            Skill(it.name, stats[it.rankIndex], stats[it.levelIndex], stats[it.xpIndex])
        }
    }
}
