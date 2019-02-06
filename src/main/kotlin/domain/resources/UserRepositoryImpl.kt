package domain.resources

import domain.entities.User
import domain.repositories.UserRepository
import domain.resources.schemas.UserTable
import domain.resources.schemas.toUser
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepositoryImpl : UserRepository {
    override fun insert(user: User) = transaction {
        user.apply {
            UserTable.insert {
                it[name] = user.name
            }
        }
    }

    override fun findOneById(id: String) = transaction {
        UserTable.select {
            UserTable.id eq id
        }.map {
            it.toUser()
        }.firstOrNull()
    }
}
