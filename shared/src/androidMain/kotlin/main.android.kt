
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import presentation.onboarding.OnboardingFifthPage
import presentation.onboarding.OnboardingFirstPage
import presentation.onboarding.OnboardingFourthPage
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
    OnboardingFirstPage(onEvent = {})
}

@Preview
@Composable
fun OnboardingScreenPreview2() {
    OnboardingSecondPage(onEvent = {})
}

@Preview
@Composable
fun OnboardingScreenPreview3() {
    OnboardingThirdPage(onEvent = {})
}

@Preview
@Composable
fun OnboardingScreenPreview4() {
    OnboardingFourthPage(onEvent = {})
}

@Preview
@Composable
fun OnboardingScreenPreview5() {
    OnboardingFifthPage(onEvent = {})
}