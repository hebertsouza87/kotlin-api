package domain.resources.schemas

import de.huxhorn.sulky.ulid.ULID
import domain.entities.User
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow

object UserTable : IdTable<String>(name = "user") {
    private const val ID_LENGTH = 40
    private const val NAME_LENGTH = 40

    override val id: Column<EntityID<String>> = varchar("id", ID_LENGTH)
        .clientDefault { ULID().nextULID() }
        .primaryKey()
        .entityId()

    val name = varchar("name", NAME_LENGTH)
}

fun ResultRow.toUser() = User(
    get(UserTable.name)
)
