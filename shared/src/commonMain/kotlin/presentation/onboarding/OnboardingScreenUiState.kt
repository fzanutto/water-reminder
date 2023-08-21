package presentation.onboarding

data class OnboardingScreenUiState(
    val weight: String = "",
    val startTimeHour: Int = 8,
    val startTimeMinute: Int = 0,
    val endTimeHour: Int = 20,
    val endTimeMinute: Int = 0,
    val interval: String = "",
    val totalWaterPerDay: String = "",
    val waterPerInterval: String = ""
)
