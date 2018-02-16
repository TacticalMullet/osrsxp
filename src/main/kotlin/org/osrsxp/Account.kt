package org.osrsxp

import org.osrsxp.Skill

class Account(val accountName: String) {
    constructor(accountName: String, skills: Array<Skill>) : this(accountName) {}
}
