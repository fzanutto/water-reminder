package presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class OnboardingScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = rememberScreenModel<Navigator, OnboardingScreenModel>(arg = navigator)

        OnboardingScreenContent(
            onEvent = screenModel::onEvent,
            uiState = screenModel.uiState
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreenContent(
    onEvent: (OnboardingScreenEvent) -> Unit,
    uiState: OnboardingScreenUiState
) {
    val pagerState = rememberPagerState(pageCount = { 5 })
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            OnboardingBottomBar(pagerState, coroutineScope, onEvent)
        }
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(32.dp)
        ) { currentPage ->
            when (currentPage) {
                0 -> OnboardingFirstPage()
                1 -> OnboardingSecondPage(onWeightChanged = onEvent, weight = uiState.weight)
                2 -> OnboardingThirdPage(onEvent = onEvent)
                3 -> OnboardingFourthPage(onEvent = onEvent, uiState = uiState)
                4 -> OnboardingFifthPage(uiState = uiState)
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun OnboardingBottomBar(
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    onEvent: (OnboardingScreenEvent) -> Unit
) {
    Row {
        if (pagerState.currentPage > 0) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text("Back")
            }
        } else {
            Spacer(modifier = Modifier.padding(16.dp).weight(1f))
        }

        Button(
            onClick = {
                coroutineScope.launch {
                    if (pagerState.currentPage < 4) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        onEvent(OnboardingScreenEvent.OnFinishOnboarding)
                    }
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        ) {
            if (pagerState.currentPage < 4) {
                Text("Next")
            } else {
                Text("Finish")
            }
        }
    }
}

@Composable
fun OnboardingFirstPage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Welcome to Water Reminder!",
            fontSize = 24.sp
        )
        Text(
            text = "Let's get started",
            fontSize = 16.sp
        )
    }
}

@Composable
fun OnboardingSecondPage(
    onWeightChanged: (OnboardingScreenEvent.OnWeightChanged) -> Unit,
    weight: String
) {
    Column {
        Text("How much do you weigh?")
        OutlinedTextField(
            value = weight,
            onValueChange = { onWeightChanged(OnboardingScreenEvent.OnWeightChanged(it)) },
            label = { Text("Weight") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingThirdPage(
    onEvent: (OnboardingScreenEvent) -> Unit
) {
    Column {
        Text("At what time do you want the first and the last reminder?")

        val firstTimePickerState = rememberTimePickerState(initialHour = 8)
        val lastTimePickerState = rememberTimePickerState(initialHour = 20)

        // TODO: when TimePickerDialog comes to commonMain use it and call onEvent to update the state
        Text("First reminder")
        TimeInput(
            state = firstTimePickerState
        )

        Text("Last reminder")
        TimeInput(
            state = lastTimePickerState
        )
    }
}

@Composable
fun OnboardingFourthPage(
    onEvent: (OnboardingScreenEvent) -> Unit,
    uiState: OnboardingScreenUiState
) {
    Column {
         Text("How often do you want to be reminded?")
        OutlinedTextField(
            value = uiState.interval,
            onValueChange = { onEvent(OnboardingScreenEvent.OnIntervalChanged(it)) },
            label = { Text("Minutes") }
        )
    }
}

@Composable
fun OnboardingFifthPage(
    uiState: OnboardingScreenUiState
) {
    Column {
        Text("Is every thing correct?")
        Text("You weigh ${uiState.weight}kg")
        Text("We should remind you every ${uiState.interval} minutes")
        Text("From 8am to 8pm")

        Text("If so, you should drink ~${uiState.totalWaterPerDay} ml of water per day")
        Text("At each reminder you should drink ${uiState.waterPerInterval} ml of water")
    }
}