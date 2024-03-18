package presentation.di

import cafe.adriel.voyager.navigator.Navigator
import org.koin.dsl.module
import presentation.onboarding.OnboardingScreenModel
import presentation.reminder.ReminderScreenModel
import presentation.settings.SettingsScreenModel

val presentationModule = module {
    factory { (navigator: Navigator) ->
        SettingsScreenModel(navigator)
    }

    factory {(navigator: Navigator) ->
        ReminderScreenModel(navigator)
    }

    factory {(navigator: Navigator) ->
        OnboardingScreenModel(navigator)
    }
}