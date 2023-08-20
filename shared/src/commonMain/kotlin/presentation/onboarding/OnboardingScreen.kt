package presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
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
            onEvent = screenModel::onEvent
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreenContent(
    onEvent: (OnboardingScreenEvent) -> Unit
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
            if (LocalInspectionMode.current) {
                OnboardingThirdPage()
                return@HorizontalPager
            }

            when (currentPage) {
                0 -> OnboardingFirstPage()
                1 -> OnboardingSecondPage()
                2 -> OnboardingThirdPage()
                3 -> OnboardingFourthPage()
                4 -> OnboardingFifthPage()
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
    Column {
        Text("Welcome to Water Reminder!")
        Text("Let's get started")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingSecondPage() {
    Column {
        Text("How much do you weigh?")
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Weight") }
        )
        Text("You should drink ~2.5L of water per day")
    }
}

@Composable
fun OnboardingThirdPage() {
    Column {
        Text("At what time do you want the first and the last reminder?")

    }
}

@Composable
fun OnboardingFourthPage() {
    Column {
         Text("How often do you want to be reminded?")
    }
}

@Composable
fun OnboardingFifthPage() {
    Column {
        Text("Is every thing correct?")
        Text("You weigh 80kg")
        Text("We should remind you every 2 hours")
        Text("From 8am to 8pm")

        Text("If so, you should drink ~2.5L of water per day")
        Text("At each reminder you should drink 250ml of water")
    }
}