package presentation.reminder

sealed interface ReminderScreenEvent {
    data object OnClickSettings : ReminderScreenEvent
}