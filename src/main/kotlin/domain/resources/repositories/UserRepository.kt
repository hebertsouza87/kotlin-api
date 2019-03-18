package domain.resources.repositories

import domain.entities.User

interface UserRepository {

    fun findById(id: String): List<User>
    fun insert(user: User): User
    fun getAll(): List<User>
}
