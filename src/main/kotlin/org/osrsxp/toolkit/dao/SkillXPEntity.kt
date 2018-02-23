package org.osrsxp.toolkit.dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass


class SkillXPEntity(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<SkillXPEntity>(SkillXPDAO)

    var name by SkillXPDAO.name
    var rank by SkillXPDAO.rank
    var level by SkillXPDAO.level
    var xp by SkillXPDAO.xp
    var accountId by SkillXPDAO.accountId
    var createdDate by SkillXPDAO.createdDate
}