package presentation.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import presentation.reminder.ReminderScreen

class OnboardingScreenModel(
    private val navigator: Navigator
): ScreenModel {

    var uiState by mutableStateOf(OnboardingScreenUiState())
        private set

    fun onEvent(event: OnboardingScreenEvent) {
        when (event) {
            OnboardingScreenEvent.OnFinishOnboarding -> {
                navigator.push(ReminderScreen())
            }

            OnboardingScreenEvent.OnClickFinish -> TODO()
            is OnboardingScreenEvent.OnStartTimeChanged -> {
                updateWaterValues()
            }
            is OnboardingScreenEvent.OnEndTimeChanged -> {
                updateWaterValues()
            }
            is OnboardingScreenEvent.OnIntervalChanged -> {
                uiState = uiState.copy(
                    interval = event.interval
                )
                updateWaterValues()
            }

            is OnboardingScreenEvent.OnWeightChanged -> {
                uiState = uiState.copy(
                    weight = event.weight
                )
                updateWaterValues()
            }
        }
    }

    private fun updateWaterValues() {
        val totalWaterInMl = uiState.weight.toInt() * 35

        uiState = uiState.copy(totalWaterPerDay = totalWaterInMl.toString())
    }
}