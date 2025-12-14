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
