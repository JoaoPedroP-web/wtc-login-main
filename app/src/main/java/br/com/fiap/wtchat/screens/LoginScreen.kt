package br.com.fiap.wtchat.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.wtchat.R


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    val waveShape = GenericShape { size, _ ->
        moveTo(0f, size.height * 0.7f)
        cubicTo(
            size.width * 0.95f, size.height * 0.00f,
            size.width * 0.0f, size.height * 0.95f,
            size.width, size.height * 0.7f
        )
        lineTo(size.width, 0f)
        lineTo(0f, 0f)
        close()
    }

    var username by remember { mutableStateOf("") }
    
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()
        .background(color = colorResource(id = R.color.branco_wtc))
    ) {

        Column( modifier = Modifier.fillMaxWidth()

        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
                    .height(150.dp)
                    .clip(waveShape),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.laranja_wtc)),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {}
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "WTC Logo",
                    modifier = Modifier
                        .size(300.dp)
                        .offset(y = (-80).dp)
                )
                Text(
                    text = ("WORLD TRADE CENTER®"),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.offset(y = (-120).dp)
                )
                Text(
                    text = ("SÃO PAULO"),
                    color = colorResource(id = R.color.laranja_wtc),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.offset(y = (-118).dp)
                )
                Text(
                    text = ("Usuário"),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .offset(y = (-75).dp),
                    fontSize = 16.sp
                )
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = {
                        Text(
                            "Digite o número funcional",
                            fontSize = 12.sp)
                            },
                    placeholder = {
                        Text(
                            "Digite o número funcional",
                            fontSize = 10.sp
                        )
                                  },
                    singleLine = true,
                    shape = RoundedCornerShape(size = 60.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .offset(y = (-80).dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.azul_wtc),
                        unfocusedBorderColor = colorResource(id = R.color.azul_wtc),
                        cursorColor = colorResource(id = R.color.laranja_wtc)
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                Spacer(modifier.height(20.dp))
                Text(
                    text = ("Senha"),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .offset(y = (-75).dp),
                    fontSize = 16.sp
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            "Digite sua senha",
                            fontSize = 12.sp)
                    },
                    placeholder = {
                        Text(
                            "Digite sua senha",
                            fontSize = 10.sp
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(size = 60.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .offset(y = (-80).dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.azul_wtc),
                        unfocusedBorderColor = colorResource(id = R.color.azul_wtc),
                        cursorColor = colorResource(id = R.color.laranja_wtc)
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Text(
                    text = ("Esqueci minha senha"),
                    color = colorResource(id = R.color.azul_link_wtc),
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.offset(y = (-75).dp, x = 80.dp)
                )

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.laranja_wtc)
                    ),
                    modifier = Modifier
                        .width(140.dp)
                        .offset(y = (-50).dp)
                ) {
                    Text(
                        text = ("Entrar")
                    )
                }
                Box(contentAlignment = Alignment.BottomCenter) {
                    BottomWaveShape()
                }
                }
            }
        }
    }

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}


@Composable
fun BottomWaveShape() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp) // aumentei um pouco a altura pra dar mais área pra curva
    ) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(0f, height * 0.4f) // início da curva no canto esquerdo
            cubicTo(
                width * 0.25f, height * 0.6f,  // ponto de controle esquerdo
                width * 0.75f, height * 0f, // ponto de controle direito — eleva o canto direito
                width, 0f                      // fim no canto superior direito da forma
            )
            lineTo(width, height)   // desce até o fundo
            lineTo(0f, height)      // volta até a base esquerda
            close()
        }

        drawPath(
            path = path,
            color = Color(0xFF002B5B) // azul escuro
        )
    }
}


