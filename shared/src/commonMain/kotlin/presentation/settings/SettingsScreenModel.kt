package presentation.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator

class SettingsScreenModel(
    private val navigator: Navigator
): ScreenModel {

    var weight by mutableStateOf("")
        private set

    fun onEvent(event: SettingsScreenEvent) {
        when (event) {
            is SettingsScreenEvent.OnClickBack -> {
                navigator.pop()
            }
            is SettingsScreenEvent.OnClickSave -> {
                // TODO: save settings
                navigator.pop()
            }
            is SettingsScreenEvent.OnChangeWeight -> {
                weight = event.weight
            }
        }
    }
}