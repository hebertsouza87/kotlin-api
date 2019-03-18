package domain.services.implementations

import domain.entities.User
import domain.resources.repositories.UserRepository
import domain.services.UserService

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getUsers(id: String?): List<User> =
        id?.let {
            userRepository.findById(it).let { users ->
                users
            }
        } ?: userRepository.getAll()


    override fun create(user: User): User = userRepository.insert(user)

}