package org.osrsxp.service

/**
 * ## Account
 * Builds a list of [Skill] upon initialization
 *
 * @param accountName osrs account name
 */
class Account(accountName: String) {
    var skills = emptyList<Skill>()
    var accountName = accountName
    init {
        this.skills = AccountService().findAccountInfo(accountName)
    }
}
