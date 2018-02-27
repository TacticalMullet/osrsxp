package org.osrsxp.service

/**
 * ## Account
 *
 * @param accountName osrs account name
 * @param skills
 */
class Account(accountName: String, var skills: List<Skill>?) {
    val accountName = accountName

    init {
        if (skills == null)
            skills = AccountService().findAccountInfo(accountName)
    }
}
