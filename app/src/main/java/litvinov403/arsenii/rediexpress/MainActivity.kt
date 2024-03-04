package litvinov403.arsenii.rediexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import litvinov403.arsenii.rediexpress.ui.theme.RediExpressTheme

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import litvinov403.arsenii.rediexpress.models.SplashViewModel
import litvinov403.arsenii.rediexpress.presentation.onboarding.OnBoardingScreen

class MainActivity : ComponentActivity() {

    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        splashScreen.setKeepOnScreenCondition{viewModel.isLoading.value}

        setContent {
            RediExpressTheme {
                OnBoardingScreen()
            }
        }
    }
}