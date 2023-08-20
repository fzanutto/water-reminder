package presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(
    title: String,
    centerTitle: Boolean = false,
    leadingIcon: ImageVector? = null,
    onClickLeadingIcon: (() -> Unit)? = null,
    trailingIcon: ImageVector? = null,
    onClickTrailingIcon: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (leadingIcon != null) {
            IconButton(
                onClick = {
                    onClickLeadingIcon?.invoke()
                }
            ) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        Text(
            text = title,
            fontSize = 24.sp,
            textAlign = if (centerTitle) TextAlign.Center else TextAlign.Start,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.size(16.dp))

        if (trailingIcon != null) {
            IconButton(
                onClick = {
                    onClickTrailingIcon?.invoke()
                }
            ) {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}