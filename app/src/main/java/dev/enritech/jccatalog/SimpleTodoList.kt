package dev.enritech.jccatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import dev.enritech.jccatalog.ui.TodoInfo

@Composable
fun SimpleTodoList() {
    val todoTitleList = listOf("Go shopping", "Buy a car", "Buy a house")

    Column() {
        getTodoInfoList(titles = todoTitleList).forEach() {
            TodoItem(todoInfo = it)
        }
    }
}

@Composable
fun getTodoInfoList(titles: List<String>): List<TodoInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        TodoInfo(
            title = it,
            done = status,
            onCheckedChange = { newStatus -> status = newStatus })
    }
}

@Composable
fun TodoItem(todoInfo: TodoInfo) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = todoInfo.done,
            onCheckedChange = { todoInfo.onCheckedChange(!todoInfo.done) }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = todoInfo.title)
    }
}

@Composable
fun MyTriStatusCheckbox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.Off -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.Off
        }
    })
}