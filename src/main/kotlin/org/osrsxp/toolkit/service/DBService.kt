package org.osrsxp.toolkit.service

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.batchInsert
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

    fun findAllAccountNames() : List<String> {
        var accountNames = listOf<String>()
        transaction {
            logger.addLogger(StdOutSqlLogger)
            accountNames = AccountEntity.all().map { it.name }
        }
        return accountNames
    }

    fun findOrCreateAccountEntity(accountName: String) : AccountEntity {
        var accountEntity: AccountEntity
        try {
            accountEntity = AccountEntity.find { AccountDAO.name eq accountName }.single()
        } catch (e: NoSuchElementException) {
            accountEntity = AccountEntity.new {
                name = accountName
            }
        }
        return accountEntity
    }

    fun saveAccountData(account: Account) {
        transaction {
            val accountEntity = findOrCreateAccountEntity(account.accountName)
            logger.addLogger(StdOutSqlLogger)
            SkillXPDAO.batchInsert(account.skills) { skill ->
                this[SkillXPDAO.name] = skill.name
                this[SkillXPDAO.rank] = skill.rank
                this[SkillXPDAO.level] = skill.level
                this[SkillXPDAO.xp] = skill.xp
                this[SkillXPDAO.accountId] = accountEntity.id
            }
        }
    }
}