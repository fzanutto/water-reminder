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

    private fun String.safeToInt() = toIntOrNull() ?: 0

    private fun updateWaterValues() {
        val totalWaterInMl = uiState.weight.safeToInt() * 35
        val intervalInMinutes = uiState.interval.safeToInt().coerceAtLeast(1)

        val deltaTime = (uiState.endTimeHour * 60 + uiState.endTimeMinute) -
                (uiState.startTimeHour * 60 + uiState.startTimeMinute).coerceAtLeast(1)

        val waterPerInterval = totalWaterInMl / (deltaTime / intervalInMinutes)

        uiState = uiState.copy(
            totalWaterPerDay = totalWaterInMl.toString(),
            waterPerInterval = waterPerInterval.toString()
        )
    }
}