
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import presentation.onboarding.OnboardingScreen

@Composable
fun App() {
        MaterialTheme {
        Navigator(
            OnboardingScreen()
        )
    }
}
