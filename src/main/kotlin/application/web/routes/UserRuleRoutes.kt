package application.web.routes

import application.web.controllers.UserController
import io.javalin.apibuilder.ApiBuilder.*

class UserRoutes(
    private val userController: UserController
) {

    fun register() {
        path("user") {
            get(userController::get)
            post(userController::create)
        }
    }
}
