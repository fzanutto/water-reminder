
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import di.injector
import org.kodein.di.compose.withDI
import presentation.reminder.ReminderScreen

@Composable
fun App() {
    withDI(injector) {
        MaterialTheme {
            Navigator(
                ReminderScreen()
            )
        }
    }
}
