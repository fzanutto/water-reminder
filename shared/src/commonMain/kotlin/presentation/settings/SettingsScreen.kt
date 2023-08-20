package presentation.settings

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.components.TopBar

class SettingsScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val screenModel = rememberScreenModel {
            SettingsScreenModel(navigator = navigator)
        }

        SettingsScreenContent(
            onEvent = screenModel::onEvent
        )
    }
}

@Composable
fun SettingsScreenContent(
    onEvent: (SettingsScreenEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = "Settings",
                leadingIcon = Icons.Default.ArrowBack,
                onClickLeadingIcon = { onEvent(SettingsScreenEvent.OnClickBack) }
            )
        }
    ) {

    }
}