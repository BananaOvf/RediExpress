package litvinov403.arsenii.rediexpress.presentation.navgraph

import androidx.compose.animation.expandVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import litvinov403.arsenii.rediexpress.R
import litvinov403.arsenii.rediexpress.presentation.onboarding.OnBoardingScreen
import litvinov403.arsenii.rediexpress.presentation.onboarding.OnBoardingViewModel
import litvinov403.arsenii.rediexpress.ui.theme.RobotoBold
import litvinov403.arsenii.rediexpress.ui.theme.RobotoMedium

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.RediExpressNavigation.route,
            startDestination = Route.AuthorizationScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Home Screen", style = TextStyle(
                        color = colorResource(id = R.color.brand_primary),
                        fontSize = 32.sp,
                        fontFamily = RobotoBold
                    ))
                }
            }
        }
    }
}