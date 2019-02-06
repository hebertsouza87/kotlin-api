package domain.services.implementations

import domain.entities.User
import domain.services.UserService

class UserServiceImpl : UserService {
    private val userList: ArrayList<User> = ArrayList()

    override fun getUser(): ArrayList<User> {
        return userList
    }

    override fun create(user: User): User {
        userList.add(user)
        return user
    }
}