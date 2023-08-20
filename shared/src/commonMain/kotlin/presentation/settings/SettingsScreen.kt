package presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.components.TopBar

class SettingsScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = rememberScreenModel<Navigator, SettingsScreenModel>(arg = navigator)

        SettingsScreenContent(
            onEvent = screenModel::onEvent,
            weight = screenModel.weight
        )
    }
}

@Composable
fun SettingsScreenContent(
    onEvent: (SettingsScreenEvent) -> Unit,
    weight: String
) {
    Scaffold(
        topBar = {
            TopBar(
                title = "Settings",
                leadingIcon = Icons.Default.ArrowBack,
                onClickLeadingIcon = { onEvent(SettingsScreenEvent.OnClickBack) }
            )
        },
        bottomBar = {
            Button(
                onClick = { onEvent(SettingsScreenEvent.OnClickSave) },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Save")
            }
        }
    ) {
        MainContent(
            paddingValues = it,
            weight = weight,
            onEvent = onEvent
        )
    }
}

@Composable
private fun MainContent(
    paddingValues: PaddingValues,
    weight: String,
    onEvent: (SettingsScreenEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = weight,
            onValueChange = { onEvent(SettingsScreenEvent.OnChangeWeight(it)) },
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}