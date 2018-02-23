package org.osrsxp.toolkit.service

import com.natpryce.konfig.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.osrsxp.service.Account
import org.osrsxp.toolkit.dao.AccountDAO
import org.osrsxp.toolkit.dao.AccountEntity
import org.osrsxp.toolkit.dao.SkillXPDAO

class DBService {
    init {
        Database.connect(
                url = System.getenv("PG_DB_URL"),
                driver = System.getenv("PG_DB_DRIVER"),
                user = System.getenv("PG_DB_USER"))
    }

    fun saveAccountData(account: Account) {
        transaction {
            logger.addLogger(StdOutSqlLogger)
            var accountEntity: AccountEntity
            try {
                accountEntity = AccountEntity.find { AccountDAO.name eq account.accountName }.single()
            } catch (e: NoSuchElementException) {
                accountEntity = AccountEntity.new {
                    name = account.accountName
                }
            }
            account.skills.forEach { skill ->
                SkillXPDAO.insert {
                    it[name] = skill.name
                    it[rank] = skill.rank
                    it[level] = skill.level
                    it[xp] = skill.xp
                    it[accountId] = accountEntity.id
                }
            }
        }
    }
}