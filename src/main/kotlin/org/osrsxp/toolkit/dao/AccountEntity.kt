package org.osrsxp.toolkit.dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass

class AccountEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountEntity>(AccountDAO)

    var name        by AccountDAO.name
    var createdDate by AccountDAO.createdDate
}


