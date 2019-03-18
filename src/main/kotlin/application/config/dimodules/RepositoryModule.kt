package application.config.dimodules

import domain.resources.UserRepositoryImpl
import domain.resources.repositories.UserRepository
import org.koin.dsl.module.module

object RepositoryModule {

    fun modules() = module {
        single { UserRepositoryImpl() as UserRepository }
    }
}
