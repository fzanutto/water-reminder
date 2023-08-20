package di

import cafe.adriel.voyager.navigator.Navigator
import org.kodein.di.DI
import org.kodein.di.bindFactory
import presentation.reminder.ReminderScreenModel
import presentation.settings.SettingsScreenModel

val injector = DI {
    bindFactory {navigator: Navigator ->
        SettingsScreenModel(navigator)
    }

    bindFactory {navigator: Navigator ->
        ReminderScreenModel(navigator)
    }
}