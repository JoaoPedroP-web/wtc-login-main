package br.com.fiap.wtchat.functions

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.wtchat.R

@Composable
fun Navbar(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(color = colorResource(id = R.color.azul_wtc))
    ) {
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .height(70.dp),
            verticalAlignment = Alignment
                .CenterVertically
            ) {
            Spacer(modifier.height(5.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Ícone Principal",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable{}
                )
                Text(
                    text = ("Principal"),
                    color = colorResource(id = R.color.branco_wtc)
                )
            }
            Spacer(modifier.width(25.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.conversas),
                    contentDescription = "Ícone de conversas",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable{}
                )
                Text(
                    text = ("Conversas"),
                    color = colorResource(id = R.color.branco_wtc)
                )
            }
            Spacer(modifier.width(25.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.criar),
                    contentDescription = "Ícone de criações",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable{}
                )
                Text(
                    text = ("Criar"),
                    color = colorResource(id = R.color.branco_wtc)
                )
            }
            Spacer(modifier.width(25.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.filtro),
                    contentDescription = "Ícone de tarefas",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable{}
                )
                Text(
                    text = ("Tarefas"),
                    color = colorResource(id = R.color.branco_wtc)
                )
            }
            Spacer(modifier.width(25.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.configuracoes),
                    contentDescription = "Ícone de configurações",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable{}
                )
                Text(
                    text = ("Configurações"),
                    color = colorResource(id = R.color.branco_wtc),
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun NavbarPreview() {
    Navbar()
}