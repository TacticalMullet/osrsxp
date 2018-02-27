package org.osrsxp.toolkit.dao

import org.jetbrains.exposed.dao.IntIdTable

object SkillXPDAO : IntIdTable("skillxp") {
    val name = varchar("name", 24)
    val rank = long("rank")
    val level = integer("level")
    val xp = long("xp")
    val accountId = (integer("account_id").entityId() references AccountDAO.id)
    val createdDate = datetime("created_dt")
}