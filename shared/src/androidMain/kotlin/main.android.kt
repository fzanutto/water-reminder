
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import presentation.onboarding.OnboardingFifthPage
import presentation.onboarding.OnboardingFirstPage
import presentation.onboarding.OnboardingFourthPage
import presentation.onboarding.OnboardingScreenUiState
import presentation.onboarding.OnboardingSecondPage
import presentation.onboarding.OnboardingThirdPage
import presentation.reminder.ReminderScreenContent
import presentation.settings.SettingsScreenContent

@Composable fun MainView() = App()

@Preview
@Composable
private fun ReminderScreenPreview() {
    ReminderScreenContent(onEvent = {})
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    SettingsScreenContent(
        onEvent = {},
        weight = "63"
    )
}

@Preview
@Composable
fun OnboardingScreenPreview1() {
    OnboardingFirstPage()
}

@Preview
@Composable
fun OnboardingScreenPreview2() {
    OnboardingSecondPage(onWeightChanged = {}, weight = "63")
}

@Preview
@Composable
fun OnboardingScreenPreview3() {
    OnboardingThirdPage(onEvent = {})
}

@Preview
@Composable
fun OnboardingScreenPreview4() {
    val uiState = OnboardingScreenUiState()
    OnboardingFourthPage(onEvent = {}, uiState = uiState)
}

@Preview
@Composable
fun OnboardingScreenPreview5() {
    val uiState = OnboardingScreenUiState(
        weight = "63",
    )
    OnboardingFifthPage(uiState = uiState)
}