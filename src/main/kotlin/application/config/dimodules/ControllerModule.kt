package application.config.dimodules

import application.web.controllers.UserController
import org.koin.dsl.module.module

object ControllerModule {

    fun modules() = module {
        single { UserController(get()) }
    }
}
