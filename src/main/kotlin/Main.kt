import application.web.API

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Executando")
        API().init()
    }
}