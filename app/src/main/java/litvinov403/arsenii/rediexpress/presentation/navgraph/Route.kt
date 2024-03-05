package litvinov403.arsenii.rediexpress.presentation.navgraph

sealed class Route(
    val route: String
) {

    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object AuthorizationScreen : Route(route = "authorizationScreen")
    object RegisterScreen : Route(route = "registerScreen")
    object PasswordResetScreen : Route(route = "passwordResetScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object RediExpressNavigation : Route(route = "rediExpressNavigation")

}