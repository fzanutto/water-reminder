package presentation.settings

sealed interface SettingsScreenEvent {
    data object OnClickBack : SettingsScreenEvent
    data object OnClickSave : SettingsScreenEvent
    data class OnChangeWeight(val weight: String) : SettingsScreenEvent
}