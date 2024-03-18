package presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.core.parameter.parametersOf
import presentation.components.TopBar

class SettingsScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<SettingsScreenModel> {
            parametersOf(navigator)
        }

        SettingsScreenContent(
            onEvent = screenModel::onEvent,
            weight = screenModel.weight
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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

@OptIn(ExperimentalMaterial3Api::class)
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