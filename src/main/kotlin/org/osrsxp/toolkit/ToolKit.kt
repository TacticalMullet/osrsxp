package org.osrsxp.toolkit

import org.osrsxp.service.AccountService

object ToolKit {
    @JvmStatic
    fun main(args: Array<String>) {
        refreshLoop()
    }

    private fun refreshLoop() {
        while (true) {
            println("refreshing accounts")
            AccountService().refreshStaleAccounts()
            Thread.sleep(10000)
        }
    }
}
