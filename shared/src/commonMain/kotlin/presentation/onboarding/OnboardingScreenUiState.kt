package presentation.onboarding

data class OnboardingScreenUiState(
    val weight: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val interval: String = "",
    val totalWaterPerDay: String = "",
    val waterPerInterval: String = ""
)
