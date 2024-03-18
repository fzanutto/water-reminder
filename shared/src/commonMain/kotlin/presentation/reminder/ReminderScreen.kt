package presentation.reminder

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.core.parameter.parametersOf
import presentation.components.TopBar
import waterreminder.shared.generated.resources.Res
import waterreminder.shared.generated.resources.water_drop


class ReminderScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<ReminderScreenModel> {
            parametersOf(navigator)
        }

        ReminderScreenContent(
            screenModel::onEvent
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderScreenContent(
    onEvent: (ReminderScreenEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = "",
                trailingIcon = Icons.Default.Settings,
                onClickTrailingIcon = {
                    onEvent(ReminderScreenEvent.OnClickSettings)
                }
            )
        }
    ) {
        MainContent(it)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun MainContent(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "350ml",
            fontSize = 40.sp
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {
                drawArc(
                    color = Color.Blue,
                    startAngle = -90f,
                    sweepAngle = 300f,
                    size = size,
                    useCenter = false,
                    style = Stroke(
                        width = 32f,
                        cap = StrokeCap.Round
                    )
                )
            }

            if (LocalInspectionMode.current) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = null,
                    modifier = Modifier.size(276.dp)
                )
            } else {
                Icon(
                    painter = painterResource(Res.drawable.water_drop),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(54.dp)
                        .width(IntrinsicSize.Min)
                )
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = "13:45",
            fontSize = 40.sp
        )
    }
}