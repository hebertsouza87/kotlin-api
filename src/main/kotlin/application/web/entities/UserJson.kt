package application.web.entities

import domain.entities.User


data class UserJson(
    val name: String
) {

    fun toModel(): User = User(
        name = name
    )
}
