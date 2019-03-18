package domain.resources.repositories

import domain.entities.User

interface UserRepository {

    fun findOneById(id: String): User?
    fun insert(user: User): User
}
