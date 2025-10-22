package br.com.fiap.wtchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.wtchat.screens.MainScreen
import br.com.fiap.wtchat.ui.theme.WTChatTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WTChatTheme {
                MainScreen()
            }
        }
    }
}