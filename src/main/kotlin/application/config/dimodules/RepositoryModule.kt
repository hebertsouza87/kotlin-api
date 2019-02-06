package application.config.dimodules

import domain.repositories.UserRepository
import domain.resources.UserRepositoryImpl
import org.koin.dsl.module.module

object RepositoryModule {

    fun modules() = module {
        single { UserRepositoryImpl() as UserRepository }
    }
}
