package org.osrsxp

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
