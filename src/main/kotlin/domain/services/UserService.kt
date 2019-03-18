package domain.services

import domain.entities.User

interface UserService {
    fun create(user: User): User
    fun getUsers(id: String?): List<User>
}