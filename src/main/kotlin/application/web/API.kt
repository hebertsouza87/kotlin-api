package application.web

import application.config.dimodules.ControllerModule
import application.config.dimodules.RoutesModule
import application.config.dimodules.ServicesModule
import application.web.routes.UserRoutes
import io.javalin.Javalin
import io.javalin.JavalinEvent
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.inject

class API : KoinComponent {
    private val userRoutes: UserRoutes by inject()

    fun init() {
        startDIModules()

        startServer()
    }

    private fun startDIModules() {
        startKoin(
            listOf(
                RoutesModule.modules(),
                ControllerModule.modules(),
                ServicesModule.modules()
            )
        )
    }

    private fun startServer() {
        Javalin.create().routes {
            userRoutes.register()
        }.also {
            it.event(JavalinEvent.SERVER_STOPPED) { stopKoin() }
        }.start(7000)

    }
}