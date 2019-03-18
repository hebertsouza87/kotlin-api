package domain.resources.datasources

interface DataSource {

    fun startConnection()
    fun stopConnection()
}
