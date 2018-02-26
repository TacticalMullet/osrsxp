package org.osrsxp.service

/**
 * ## Account
 * Builds a list of [Skill] upon initialization
 *
 * @param accountName osrs account name
 */
class Account(accountName: String) {
    constructor(accountName: String, skills: List<Skill>) : this(accountName)
    var skills = emptyList<Skill>()
    var accountName = accountName
    init {
        if (skills.isEmpty())
            this.skills = AccountService().findAccountInfo(accountName)
    }
}
