package domain.services.implementations

import domain.entities.User
import domain.repositories.UserRepository
import domain.services.UserService

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    private val userList: ArrayList<User> = ArrayList()

    override fun getUser(): ArrayList<User> {
        return userList
    }

    override fun create(user: User): User {
        userRepository.insert(user)
        userList.add(user)
        return user
    }
}