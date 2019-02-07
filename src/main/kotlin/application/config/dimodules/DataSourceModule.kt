package application.config.dimodules

import org.koin.dsl.module.module
import resources.datasources.DataSource
import resources.datasources.implementations.PostgresqlDataSourceImpl

object DataSourceModule {

    fun modules() = module {
        single { PostgresqlDataSourceImpl(get()) as DataSource }
    }
}
