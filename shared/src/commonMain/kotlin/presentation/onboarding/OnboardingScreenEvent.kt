package presentation.onboarding

sealed interface OnboardingScreenEvent {
    data object OnFinishOnboarding : OnboardingScreenEvent
    data class OnWeightChanged(val weight: String) : OnboardingScreenEvent
    data class OnStartTimeChanged(val time: String) : OnboardingScreenEvent
    data class OnEndTimeChanged(val time: String) : OnboardingScreenEvent
    data class OnIntervalChanged(val interval: String) : OnboardingScreenEvent
    data object OnClickFinish : OnboardingScreenEvent
}