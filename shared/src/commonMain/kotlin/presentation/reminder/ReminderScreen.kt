package presentation.reminder

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke


@Composable
fun ReminderScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
          Canvas(modifier = Modifier) {
              drawArc(
                  color = Color.Red,
                  startAngle = 0f,
                  sweepAngle = 180f,
                  size = size,
                  useCenter = false,
                  style = Stroke(
                      width = 4f,
                      cap = StrokeCap.Round
                  )
              )
          }
    }
}