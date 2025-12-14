package com.mamede.repositoriomobile.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mamede.repositoriomobile.data.User
import com.mamede.repositoriomobile.data.model.Repository
import com.mamede.repositoriomobile.viewmodel.MainUiState
import com.mamede.repositoriomobile.viewmodel.MainViewModel

/**
 * O Composable principal da aplicação, que atua como um controlador de UI.
 *
 * Esta tela observa o estado ([MainUiState]) exposto pelo [MainViewModel] e renderiza
 * a UI correspondente. Ela lida com os três estados principais:
 * - **Loading**: Exibe um indicador de progresso centralizado.
 * - **Success**: Delega a renderização para a [SuccessScreen], passando os dados do usuário e repositórios.
 * - **Error**: Exibe uma mensagem de erro.
 *
 * @param viewModel A instância de [MainViewModel] que gerencia a lógica de negócios e o estado da tela.
 *                  É injetado por padrão usando `viewModel()`.
 */
@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {

    //observer. Se o VM mudar, a tela redesenha
    val state by viewModel.uiState.collectAsState()

    when (val currentState = state) {
        is MainUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is MainUiState.Success -> {
            SuccessScreen(
                user = currentState.user,
                repositories = currentState.repositories
            )
        }

        is MainUiState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Erro: ${currentState.message}")
            }
        }
    }
}
