package com.osrsxp

import org.junit.Test
import com.google.gson.GsonBuilder
import com.osrsxp.account.Account

class AccountTest {
    @Test
    fun testFindAccount() {
        // TODO actual testing
        val account = Account("lynx titan")
        val gson = GsonBuilder().setPrettyPrinting().create()
        println(gson.toJson(account))
    }
}
