package org.osrsxp

import org.junit.Test
import com.google.gson.GsonBuilder
import org.osrsxp.service.Account
import org.osrsxp.toolkit.ToolKit

class AccountTest {
    @Test
    fun testFindAccount() {
        // TODO actual testing
        val account = Account("lynx titan")
        val gson = GsonBuilder().create()
        println(gson.toJson(account))
    }

    @Test
    fun testToolkit() {
        ToolKit().findUserInfo(Account("framed"))
    }
}
