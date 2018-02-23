package org.osrsxp.toolkit

import org.osrsxp.service.Account
import org.osrsxp.toolkit.service.DBService

class ToolKit {
    fun findUserInfo(account: Account) {
        DBService().saveAccountData(account)
    }
}
