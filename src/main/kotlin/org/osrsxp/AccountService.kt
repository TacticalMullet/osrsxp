package org.osrsxp

import khttp.get

class AccountService() {
    fun find(accountName: String) {
        stats = get("http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=${encodeName(accountName)}").text
        // TODO parse text vomit into Account object
    }

    fun encodeName(accountName: String) : String {
        return accountName.replace("\\s+".toRegex(), "%20")
    }
}
