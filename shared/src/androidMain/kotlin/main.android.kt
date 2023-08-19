import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = App()

@Preview
@Composable
fun TestPreview() {
    Text("Hello World!", color = Color.White)
}