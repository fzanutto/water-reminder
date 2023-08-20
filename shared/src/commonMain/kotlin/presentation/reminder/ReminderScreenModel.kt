package presentation.reminder

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import presentation.settings.SettingsScreen

class ReminderScreenModel(
    private val navigator: Navigator
): ScreenModel {

    fun onEvent(event: ReminderScreenEvent) {
        when (event) {
            is ReminderScreenEvent.OnClickSettings -> {
                println("clicked settings button")
                navigator.push(SettingsScreen())
            }
        }
    }
}