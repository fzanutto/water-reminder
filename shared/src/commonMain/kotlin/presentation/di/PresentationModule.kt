package presentation.di

import cafe.adriel.voyager.navigator.Navigator
import org.kodein.di.DI
import org.kodein.di.bindFactory
import presentation.onboarding.OnboardingScreenModel
import presentation.reminder.ReminderScreenModel
import presentation.settings.SettingsScreenModel

val presentationModule = DI.Module("presentation") {
    bindFactory {navigator: Navigator ->
        SettingsScreenModel(navigator)
    }

    bindFactory {navigator: Navigator ->
        ReminderScreenModel(navigator)
    }

    bindFactory {navigator: Navigator ->
        OnboardingScreenModel(navigator)
    }
}