package org.osrsxp

import org.junit.Test
import com.google.gson.GsonBuilder
import org.osrsxp.service.Account
import org.osrsxp.toolkit.ToolKit
import org.osrsxp.toolkit.service.DBService

class AccountTest {
    @Test
    fun testFindAccount() {
        // TODO actual testing
        val account = Account("lynx titan", null)
        val gson = GsonBuilder().create()
        println(gson.toJson(account))
    }

    @Test
    fun testDBService() {
        DBService().saveAccountData(Account("framed", null))
    }

    @Test
    fun testToolkit() {
        ToolKit.refreshAccounts()
    }
}
