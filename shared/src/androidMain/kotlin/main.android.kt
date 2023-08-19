import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import presentation.reminder.ReminderScreenContent

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = App()

@Preview
@Composable
fun ReminderScreenPreview() {
    ReminderScreenContent(onEvent = {})
}