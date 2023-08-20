package presentation.onboarding

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import presentation.reminder.ReminderScreen

class OnboardingScreenModel(
    private val navigator: Navigator
): ScreenModel {
    fun onEvent(event: OnboardingScreenEvent) {
        when (event) {
            is OnboardingScreenEvent.OnFinishOnboarding -> {
                navigator.push(ReminderScreen())
            }
        }
    }
}