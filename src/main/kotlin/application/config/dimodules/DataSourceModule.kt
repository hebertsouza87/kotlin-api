package application.config.dimodules

import domain.resources.datasources.DataSource
import domain.resources.datasources.implementations.PostgresqlDataSourceImpl
import org.koin.dsl.module.module

object DataSourceModule {

    fun modules() = module {
        single { PostgresqlDataSourceImpl(get()) as DataSource }
    }
}
