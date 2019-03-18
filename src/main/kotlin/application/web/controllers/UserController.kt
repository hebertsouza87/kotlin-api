package application.web.controllers

import application.web.entities.UserJson
import domain.services.UserService
import io.javalin.Context

class UserController(
    private val userService: UserService
) {

    fun get(ctx: Context) {
        ctx.json(userService.getUsers(ctx.queryParam("user")))
    }

    fun create(ctx: Context) {
        ctx.body<UserJson>().run {
            ctx.json(userService.create(this.toModel()))
        }
    }
}
