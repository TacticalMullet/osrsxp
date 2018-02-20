package org.osrsxp.models

import org.osrsxp.service.AccountService

/**
 * ## Account
 * Builds a list of [Skill] upon initialization
 *
 * @param accountName osrs account name
 */
class Account(accountName: String) {
    var skills = emptyList<Skill>()
    init {
        this.skills = AccountService().findAccountInfo(accountName)
    }
}
