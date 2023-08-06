package dev.enritech.jccatalog

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun WrapperOfCustomDialog() {
    var showEventDialog by remember { mutableStateOf(value = false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { showEventDialog = true }) {
            Text(text = "Mostrar diálogo")
        }
        CustomDialog(showEventDialog, onDismiss = { showEventDialog = false })
    }
}

@Composable
fun CustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() }, properties = DialogProperties(
                dismissOnBackPress = false,
            )
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(24.dp)
            ) {
                DialogTitle(text = "Set backup account")
                MySpacer(size = 20.dp)
                AccountItem(
                    id = "abc1",
                    email = "washing.coen@gmail.com",
                    drawable = R.drawable.avatar,
                    onClick = { Log.println(Log.INFO, "id", it) })
                MySpacer(size = 8.dp)
                AccountItem(
                    id = "abc2",
                    email = "washimon7@gmail.com",
                    drawable = R.drawable.avatar,
                    onClick = { Log.println(Log.INFO, "id", it) })
                MySpacer(size = 8.dp)
                AddAccountItem(
                    text = "Add account",
                    drawable = R.drawable.add,
                    onClick = { println("Try to add account") })
            }
        }
    }
}

@Composable
fun DialogTitle(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = Modifier.padding(start = 4.dp)
    )
}

@Composable
fun AccountItem(
    id: String,
    email: String,
    @DrawableRes drawable: Int,
    onClick: (accountId: String) -> Unit
) {
    Box(modifier = Modifier.clickable { onClick(id) }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "user avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            MySpacer(size = 16.dp, orientation = Orientation.Horizontal)
            Text(text = email, fontSize = 14.sp, color = Color.Gray)

        }
    }
}

@Composable
fun AddAccountItem(text: String, @DrawableRes drawable: Int, onClick: () -> Unit) {
    Box(modifier = Modifier.clickable { onClick() }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "user avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            MySpacer(size = 16.dp, orientation = Orientation.Horizontal)
            Text(text = text, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun MySpacer(size: Dp, orientation: Orientation = Orientation.Vertical) {
    if (orientation == Orientation.Vertical) {
        Spacer(modifier = Modifier.height(size))
    } else {
        Spacer(modifier = Modifier.width(size))
    }
}
