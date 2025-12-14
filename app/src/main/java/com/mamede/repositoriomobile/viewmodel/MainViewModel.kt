package com.mamede.repositoriomobile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mamede.repositoriomobile.data.User
import com.mamede.repositoriomobile.data.model.Repository
import com.mamede.repositoriomobile.data.remote.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch



/**
 * Representa os possíveis estados da tela principal.
 *
 * Esta sealed interface é usada para modelar o estado da UI de forma explícita,
 * garantindo que a tela sempre trate todos os casos possíveis: carregamento,
 * sucesso ou erro.
 */
sealed interface MainUiState {

    /**
     * Indica que os dados estão sendo carregados. A UI deve exibir um indicador de progresso.
     */
    object Loading : MainUiState

    /**
     * Indica que os dados foram carregados com sucesso.
     * @property user Os dados do perfil do usuário.
     * @property repositories A lista de repositórios do usuário.
     */
    data class Success(val user: User, val repositories: List<Repository>) : MainUiState

    /**
     * Indica que ocorreu um erro durante o carregamento dos dados.
     * @property message A mensagem de erro a ser exibida na UI.
     */
    data class Error(val message: String) : MainUiState
}

/**
 * ViewModel responsável por gerenciar a lógica de negócio e o estado da tela principal.
 *
 * Esta classe busca os dados de um usuário do GitHub (perfil e repositórios)
 * e expõe o estado atual da operação através de um [StateFlow] para que a UI possa
 * reagir a mudanças como carregamento, sucesso ou erro.
 *
 * @see MainUiState para os diferentes estados que a UI pode assumir.
 */
class MainViewModel : ViewModel() {

    /**
     * O [StateFlow] interno e mutável que armazena o estado atual da UI.
     * Inicia no estado [MainUiState.Loading].
     */
    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Loading)

    /**
     * O [StateFlow] público e imutável que expõe o estado da UI para ser observado
     * pelas telas (Composables).
     */
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    /**
     * O nome de usuário do GitHub cujos dados serão buscados.
     */
    private val userGitHub = "mmd-ravens"

    /**
     * Bloco de inicialização do ViewModel. Inicia a busca dos dados
     * assim que o ViewModel é criado.
     */
    init {
        fetchGitHubData(userGitHub)
    }

    /**
     * Inicia uma corrotina no [viewModelScope] para buscar os dados do usuário e seus
     * repositórios de forma assíncrona na API do GitHub.
     *
     * Atualiza o [_uiState] para [MainUiState.Loading] no início, [MainUiState.Success]
     * se a chamada for bem-sucedida, ou [MainUiState.Error] em caso de falha.
     *
     * @param userName O nome de usuário do GitHub a ser pesquisado.
     */
    private fun fetchGitHubData(userName: String) {
        viewModelScope.launch { //fazer o pedido na api sem travar o app (background thread)
            _uiState.value = MainUiState.Loading

            try { //lidar com internet sempre usar para segurança
                //busca os dados
                val user = RetrofitClient.service.getUser(userName)
                val repositories = RetrofitClient.service.getRepositories(userName)

                //dando certo, att o estado para sucess
                _uiState.value = MainUiState.Success(user, repositories)
            } catch (e: Exception) {
                //dando errado, sem net, user não existe, avisar a tela
                _uiState.value = MainUiState.Error("Erro desconhecido")
            }

        }
    }
}