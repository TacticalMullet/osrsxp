package org.osrsxp.toolkit.dao

import org.jetbrains.exposed.dao.IntIdTable

object AccountDAO : IntIdTable("account") {
    val name = varchar("name", 24)
    val createdDate = datetime("created_dt")
}