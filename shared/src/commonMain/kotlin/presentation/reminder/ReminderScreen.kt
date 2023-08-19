package presentation.reminder

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


class ReminderScreen: Screen {
    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { ReminderScreenModel() }
        ReminderScreenContent(
            screenModel::onEvent
        )
    }
}

@Composable
fun ReminderScreenContent(
    onEvent: (ReminderScreenEvent) -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = {
                        onEvent(ReminderScreenEvent.OnClickSettings)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
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
                    painter = painterResource("water_drop.xml"),
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