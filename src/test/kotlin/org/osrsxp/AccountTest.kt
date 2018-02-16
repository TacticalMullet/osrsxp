package org.osrsxp

import org.junit.Test
import com.google.gson.GsonBuilder

class AccountTest {
    @Test
    fun testFindAccount() {
        // TODO do actual testing
        val account = AccountService().find("arid meme")
        val gson = GsonBuilder().setPrettyPrinting().create()
        println(gson.toJson(account))
    }
}
