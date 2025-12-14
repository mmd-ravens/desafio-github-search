package com.mamede.repositoriomobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mamede.repositoriomobile.ui.MainScreen
import com.mamede.repositoriomobile.ui.theme.RepositorioMobileTheme


/**
 * A Activity principal e ponto de entrada da aplicação.
 *
 * Esta classe é responsável por configurar o ambiente do Jetpack Compose e definir
 * o conteúdo da tela, que é gerenciado pelo tema [RepositorioMobileTheme] e
 * cujo layout inicial é o [MainScreen].
 */
class MainActivity : ComponentActivity() {

    /**
     * Chamado quando a Activity é criada pela primeira vez.
     *
     * Este método inicializa a interface do usuário (UI) usando Jetpack Compose.
     * `enableEdgeToEdge()` permite que o app desenhe em toda a área da tela, incluindo
     * atrás das barras de sistema (status e navegação).
     * O [setContent] define a raiz da UI com o Composable [MainScreen] dentro de um [Surface].
     *
     * @param savedInstanceState Se a Activity está sendo recriada após ter sido
     * destruída, este Bundle contém o estado salvo anteriormente. É nulo se a Activity
     * está sendo criada pela primeira vez.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RepositorioMobileTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}
