package application.config.dimodules

import application.config.EnvironmentConfig
import org.koin.dsl.module.module

object ConfigModule {

    fun modules() = module {
        single { EnvironmentConfig() }
    }
}
