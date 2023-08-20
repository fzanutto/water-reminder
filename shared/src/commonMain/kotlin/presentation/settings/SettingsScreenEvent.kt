package presentation.settings

sealed interface SettingsScreenEvent {
    data object OnClickBack : SettingsScreenEvent
}