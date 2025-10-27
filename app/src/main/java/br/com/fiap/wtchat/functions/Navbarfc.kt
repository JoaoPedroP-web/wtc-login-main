package br.com.fiap.wtchat.functions


import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun BottomNavBar() {

    val navBarColor = Color(0x6EFFFFFF)

    var selectedItem by remember { mutableStateOf(1) }
    val items = listOf(
        "Principal" to Icons.Default.Home,
        "Conversas" to Icons.Default.Chat,
        "Criar" to Icons.Default.AddCircle,
        "Tarefas" to Icons.Default.FilterList,
        "Ajustes" to Icons.Default.Settings
    )

    NavigationBar(
        containerColor = navBarColor
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.second, contentDescription = item.first) },
                label = { Text(item.first) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}