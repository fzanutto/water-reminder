package presentation.reminder

import cafe.adriel.voyager.core.model.ScreenModel

class ReminderScreenModel: ScreenModel {

    fun onEvent(event: ReminderScreenEvent) {
        when (event) {
            is ReminderScreenEvent.OnClickSettings -> {
                println("clicked settings button")
            }
        }
    }
}