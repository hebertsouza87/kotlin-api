package resources.datasources.implementations

import application.config.EnvironmentConfig
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import domain.resources.schemas.UserTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import resources.datasources.DataSource

class PostgresqlDataSourceImpl(
    private val environmentConfig: EnvironmentConfig
) : DataSource {

    lateinit var dataSource: HikariDataSource

    override fun startConnection() {
        dataSource = HikariDataSource(HikariConfig().apply {
            jdbcUrl = environmentConfig.postgresqlJdbcUrl
            username = environmentConfig.postgresqlUsername
            password = environmentConfig.postgresqlPassword
            maximumPoolSize = environmentConfig.postgresqlMaxPoolSize
        }).also {
            Database.connect(it)

            transaction {
                SchemaUtils.create(UserTable)
            }
        }
    }

    override fun stopConnection() = dataSource.close()
}
