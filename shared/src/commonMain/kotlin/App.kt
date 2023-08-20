
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.kodein.di.compose.withDI
import presentation.di.presentationModule
import presentation.onboarding.OnboardingScreen

@Composable
fun App() {
    withDI(presentationModule) {
        MaterialTheme {
            Navigator(
                OnboardingScreen()
            )
        }
    }
}
