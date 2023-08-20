package presentation.onboarding

sealed interface OnboardingScreenEvent {
    data object OnFinishOnboarding : OnboardingScreenEvent
}