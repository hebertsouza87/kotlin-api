package application.config

import com.natpryce.konfig.*

private const val DEFAULT_SERVER_PORT = 7000

class EnvironmentConfig(
    configuration: Configuration = EnvironmentVariables()
) {
    val serverPort = configuration.getOrElse(SERVER_PORT, DEFAULT_SERVER_PORT)

    val postgresqlJdbcUrl = configuration[POSTGRESQL_JDBC_URL]
    val postgresqlUsername = configuration[POSTGRESQL_USERNAME]
    val postgresqlPassword = configuration[POSTGRESQL_PASSWORD]
    val postgresqlMaxPoolSize = configuration[POSTGRESQL_MAX_POOL_SIZE]

    companion object {
        val SERVER_PORT by intType

        val POSTGRESQL_JDBC_URL by stringType
        val POSTGRESQL_USERNAME by stringType
        val POSTGRESQL_PASSWORD by stringType
        val POSTGRESQL_MAX_POOL_SIZE by intType
    }
}
