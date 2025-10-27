package br.com.fiap.wtchat.screens
import br.com.fiap.wtchat.functions.BottomNavBar
import android.R.attr.padding
import br.com.fiap.wtchat.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape



data class Conversation(
    val senderName: String,
    val senderRole: String,
    val lastMessage: String,
    val timestamp: String,
    val unreadCount: Int,
    val profilePicId: Int
)

@Preview(showBackground = true, device = "id:pixel_6")
@Composable
fun MessageScreen() {
    Scaffold(
        topBar = { TopSection() },
        bottomBar = { BottomNavBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White)
        ) {
            MessageHeader()
            ContactList()
        }
    }
}


@Composable
fun TopSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF003366))
            .padding(25.dp),
    )


    {
        Spacer(modifier = Modifier.height(10.dp) )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Pesquisar", color = Color.Gray , fontSize = 16.sp) },
            trailingIcon = { Icon(Icons.Default.Mic, contentDescription = "Microfone") },
            modifier = Modifier.fillMaxWidth()
                .heightIn(max = 80.dp)
                .padding(vertical = 20.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0x6EFFFFFF),
                focusedContainerColor = Color(0x6EFFFFFF),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = MaterialTheme.shapes.extraLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Conversas",
            fontSize = 40.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )
    }
}

@Composable
fun MessageHeader() {
    val actions = listOf(
        "Criar grupo" to Icons.Default.Group,
        "Criar tarefa" to Icons.Default.CalendarToday,
        "Disparo" to Icons.Default.Send,
        "Criar ligação" to Icons.Default.Call,
        "promoção" to Icons.Default.Campaign
    )
    LazyRow(
        modifier = Modifier.padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 14.dp)
    ) {
        items(actions) { (text, icon) ->
            Button(
                onClick = { },
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEA5020))
            ) {
                Icon(icon, contentDescription = text, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text, fontSize = 12.sp)
            }
        }
        item {
            Button(
                onClick = { },
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.size(56.dp, 36.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE57373))
            ) {}
        }
    }
}

@Composable
fun ContactList() {
    val conversations = remember {
        listOf(
            Conversation(
                senderName = "JM",
                senderRole = "PO",
                lastMessage = "Valeu! Depois te pago o café 😊",
                timestamp = "08:21",
                unreadCount = 1,
                profilePicId = R.drawable.image_5
            ),
            Conversation(
                senderName = "Carlos",
                senderRole = "TL",
                lastMessage = "Valeu! Depois te pago o café 😊",
                timestamp = "08:25",
                unreadCount = 1,
                profilePicId = R.drawable.image14
            ),
            Conversation(
                senderName = "Ana",
                senderRole = "RH",
                lastMessage = "Valeu! Depois te pago o café 😊",
                timestamp = "04:07",
                unreadCount = 1,
                profilePicId = R.drawable.image15
            ),
            Conversation(
                senderName = "João Victor",
                senderRole = "UX/UI",
                lastMessage = "Valeu! Depois te pago o café 😊",
                timestamp = "15:21",
                unreadCount = 1,
                profilePicId = R.drawable.image16
            ),
            Conversation(
                senderName = "Karolaine",
                senderRole = "MK",
                lastMessage = "Valeu! Depois te pago o café 😊",
                timestamp = "06:51",
                unreadCount = 1,
                profilePicId = R.drawable.image17
            ),
            Conversation(

                senderName = "Julia",
                senderRole = "UX/UI",
                lastMessage = "Valeu! Depois te pago o café 😊",
                timestamp = "06:51",
                unreadCount = 1,
                profilePicId = R.drawable.image18
            )
        )
    }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(conversations) { convo ->
            ConversationItem(convo = convo)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationItem(convo: Conversation) {
    Surface(
        onClick = { },
        color = Color(0xFFE2E2E2),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = convo.profilePicId),
                contentDescription = "Foto de ${convo.senderName}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)

            )


            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text("${convo.senderName} (${convo.senderRole})", fontWeight = FontWeight.Bold)
                Text(convo.lastMessage, fontSize = 15.sp, color = Color.Gray)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(convo.timestamp, fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))
                if (convo.unreadCount > 0) {
                    Badge(containerColor = Color(0xFFD32F2F)) {
                        Text(
                            text = convo.unreadCount.toString(),
                            color = Color.White,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                    }
                }
            }
        }
    }
}





@Preview
@Composable
private fun ConversasScreenPreview() {
    ConversasScreen()
}

@Composable
fun ConversasScreen() {
    TODO("Not yet implemented")
}