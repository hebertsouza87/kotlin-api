package application.config.dimodules

import application.web.routes.UserRoutes
import org.koin.dsl.module.module

object RoutesModule {

    fun modules() = module {
        single { UserRoutes(get()) }
    }
}
