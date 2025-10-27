package br.com.fiap.wtchat.screens

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


data class ContactDetails(
    val name: String,
    val unreadCount: Int,
    val photoId: Int
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTopBar(contact: ContactDetails) {
    TopAppBar(
        modifier = Modifier.height(110.dp),

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF003366),
            titleContentColor = Color.White
        ),

        title = {
            Box(
                modifier = Modifier.fillMaxSize().padding(top = 25.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = contact.photoId),
                        contentDescription = contact.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(contact.name, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)

                }
            }
        },
        navigationIcon = {

            Box(
                modifier = Modifier.fillMaxHeight().padding(top = 25.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { /* Voltar */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.White)
                    }
                    Text(
                        text = contact.unreadCount.toString(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .clip(RoundedCornerShape(7.dp))
                            .background(Color.Red)
                            .padding(horizontal = 5.dp, vertical = 0.5.dp)

                    )
                }
            }
        },
        actions = {

            Box(
                modifier = Modifier.fillMaxHeight().padding(top = 25.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.PhotoCameraFront, contentDescription = "Chamada de Vídeo", tint = Color.Red)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Call, contentDescription = "Chamada de Voz", tint = Color.Red)
                    }
                }
            }
        }
    )
}

@Composable
fun ChatInputBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF003366))
        .heightIn(max = 80.dp)
        .padding(vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = { }) {
            Icon(Icons.Default.Add, contentDescription = "Anexar", tint = Color.White)
        }


        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Envie uma mensagem", color = Color.Gray) },


            trailingIcon = {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Default.Mic, 
                        contentDescription = "Microfone",
                        tint = Color.Black
                    )
                }
            },


            modifier = Modifier.weight(1f).heightIn(max = 48.dp).padding(horizontal = 8.dp),
            shape = CircleShape,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            )
        )
    }
}


@Composable
fun ChatScreen() {
    val jm = ContactDetails(name = "JM", unreadCount = 30, photoId = R.drawable.image_5)



    Scaffold(
        topBar = { ChatTopBar(contact = jm) },
        bottomBar = { ChatInputBar() }
    ) { paddingValues ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Image(
                painter = painterResource(id = R.drawable.background_chat),
                contentDescription = "Fundo do Chat",


                contentScale = ContentScale.Crop,

                modifier = Modifier.fillMaxSize()
            )


            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // TODO: Mensagens virão aqui
                Spacer(modifier = Modifier.weight(1f))
                Text("Início do chat com JM ",
                    modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally),
                    color = Color.White
                )
            }
        }
    }
}


@Preview(showBackground = true, device = "id:pixel_6")
@Composable
fun ChatScreenFullPreview() {

    MaterialTheme {
        ChatScreen()
    }
}





































































