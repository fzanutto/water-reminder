package presentation.settings

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator

class SettingsScreenModel(
    private val navigator: Navigator
): ScreenModel {
    fun onEvent(event: SettingsScreenEvent) {
        when (event) {
            is SettingsScreenEvent.OnClickBack -> {
                navigator.pop()
            }
        }
    }
}