package br.com.fiap.wtchat.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import br.com.fiap.wtchat.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.wtchat.functions.CardDeReuniao
import br.com.fiap.wtchat.functions.ChatNotificationCard
import br.com.fiap.wtchat.functions.ItemDeTarefa
import br.com.fiap.wtchat.functions.Navbar

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var search by remember { mutableStateOf("") }
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }
    var checked3 by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.branco_wtc))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, top = 40.dp, end = 15.dp)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = ("Principal"),
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier.height(5.dp))
            OutlinedTextField(
                value = search,
                onValueChange = {search = it},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = {
                    Text(
                        text = ("Envie uma mensagem"),
                        color = colorResource(id = R.color.cinzaescuro_wtc)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = colorResource(id = R.color.cinzabarra_wtc),
                    focusedContainerColor = colorResource(id = R.color.cinzabarra_wtc),
                    focusedBorderColor = colorResource(id = R.color.cinzabarra_wtc),
                    unfocusedBorderColor = colorResource(id = R.color.cinzabarra_wtc),
                    cursorColor = colorResource(id = R.color.cinzaescuro_wtc),
                    focusedTextColor = colorResource(id = R.color.preto_wtc),

                ),
                shape = RoundedCornerShape(size = 70.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.iconmic),
                            contentDescription = "Gravar mensagem",
                            modifier = Modifier.size(size = 25.dp),
                            tint = colorResource(id = R.color.cinzaescuro_wtc)
                        )
                    }
                }
            )
            Spacer(modifier.height(45.dp))
            Text(
                text = ("Conversas"),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier.height(20.dp))
            ChatNotificationCard(
                profilePic = R.drawable.cliente1,
                name = "JM (PO)",
                message = "Valeu! Depois te pago o café 😅",
                time = "08:21",
                unreadCount = 1
            )
            Spacer(modifier = Modifier.height(5.dp))
            ChatNotificationCard(
                profilePic = R.drawable.cliente2,
                name = "Carlos (TL)",
                message = "Opa, tudo certo para a locação?",
                time = "08:25",
                unreadCount = 1
            )
            Spacer(modifier.height(45.dp))
            Text(
                text = ("Tarefas"),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier.height(20.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.cinzabarra_wtc)
                ),
                shape = RoundedCornerShape(size = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                ItemDeTarefa(
                    texto = "Revisar mensagens e pendências do cliente",
                    cor = colorResource(id = R.color.tarefa1_wtc),
                    isChecked = checked1,
                    onCheckedChange = {checked1 = it}
                )
                Spacer(modifier = Modifier.height(5.dp))
                ItemDeTarefa(
                    texto = "Atualizar status das campanhas em andamento",
                    cor = colorResource(id = R.color.tarefa2_wtc),
                    isChecked = checked2,
                    onCheckedChange = {checked2 = it}
                )
                Spacer(modifier = Modifier.height(5.dp))
                ItemDeTarefa(
                    texto = "Testar funcionalidade de login e notificações",
                    cor = colorResource(id = R.color.tarefa3_wtc),
                    isChecked = checked3,
                    onCheckedChange = {checked3 = it}
                )
                Spacer(modifier = Modifier.height(25.dp))
            }
            Spacer(modifier.height(45.dp))
            Text(
                text = ("Reunião"),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            CardDeReuniao(
                titulo = "Andamento de funcionalidade do login",
                hora = "10:00AM",
                participante = "Ricardo Veloso",
                ocupacao = "Tech Lead"
            )
        }
    }
    
}


@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}