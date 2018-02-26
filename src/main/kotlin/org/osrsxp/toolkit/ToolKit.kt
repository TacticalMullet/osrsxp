package org.osrsxp.toolkit

import org.osrsxp.service.Account
import org.osrsxp.toolkit.service.DBService

object ToolKit {
    @JvmStatic fun main(args: Array<String>) {
        refreshAccounts()
    }

    fun refreshAccounts() {
        val accountNames = DBService().findAllAccountNames()
        accountNames.forEach {
            name -> DBService().saveAccountData(Account(name))
        }
    }
}
