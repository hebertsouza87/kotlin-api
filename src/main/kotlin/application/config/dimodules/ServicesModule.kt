package application.config.dimodules

import domain.services.UserService
import domain.services.implementations.UserServiceImpl
import org.koin.dsl.module.module

object ServicesModule {

    fun modules() = module {
        single { UserServiceImpl(get()) as UserService }
    }
}
