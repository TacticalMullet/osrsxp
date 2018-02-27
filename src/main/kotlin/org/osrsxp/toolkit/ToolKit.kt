package org.osrsxp.toolkit

import org.osrsxp.service.AccountService

const val SLEEP_TIME:Long = 30000

object ToolKit {
    @JvmStatic
    fun main(args: Array<String>) {
        refreshLoop()
    }

    private fun refreshLoop() {
        while (true) {
            println("Refreshing Accounts")
            AccountService().refreshStaleAccounts()
            Thread.sleep(SLEEP_TIME)
        }
    }
}
