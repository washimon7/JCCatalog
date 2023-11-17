package dev.enritech.jccatalog.model

sealed class Routes(val route: String) {
    object Screen1 : Routes("screen1")
    object Screen2 : Routes("screen2")
    object Screen3 : Routes("screen3")
    object Screen4 : Routes("screen4/{user}") {
        fun createRoute(user: String) = "screen4/$user"
    }
    object Screen5 : Routes("screen5/{winnersCount}") {
        fun createRoute(winnersCount: Int) = "screen5/$winnersCount"
    }
    object Screen6 : Routes("screen6?qualifiedUser={qualifiedUser}") {
        fun createRoute() = "screen6"
        fun createRoute(qualifiedUser: Boolean) = "screen6?qualifiedUser=$qualifiedUser"
    }
}