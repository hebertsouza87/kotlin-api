package application.web

import application.config.EnvironmentConfig
import application.config.dimodules.*
import application.web.routes.UserRoutes
import io.javalin.Javalin
import io.javalin.JavalinEvent
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.inject
import resources.datasources.DataSource

class API : KoinComponent {
    private val userRoutes: UserRoutes by inject()
    private val environmentConfig: EnvironmentConfig by inject()
    private val dataSource by inject<DataSource>()

    fun init() {
        startDIModules()
        startDBConnection()

        startServer()
    }

    private fun startDIModules() {
        startKoin(
            listOf(
                ConfigModule.modules(),
                DataSourceModule.modules(),
                RoutesModule.modules(),
                ControllerModule.modules(),
                ServicesModule.modules(),
                RepositoryModule.modules()
            )
        )
    }

    private fun startServer() {
        Javalin.create().routes {
            userRoutes.register()
        }.also {
            it.event(JavalinEvent.SERVER_STOPPED) {
                stopKoin()
                stopDBConnection()
            }
        }.start(environmentConfig.serverPort)

    }

    private fun startDBConnection() = dataSource.startConnection()

    private fun stopDBConnection() = dataSource.stopConnection()
}