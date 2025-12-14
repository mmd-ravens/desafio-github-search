package com.mamede.repositoriomobile.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Objeto singleton que gerencia a configuração e a criação do cliente Retrofit.
 *
 * Este objeto é responsável por centralizar a instância do Retrofit, garantindo que toda a aplicação
 * utilize a mesma configuração para se comunicar com a API do GitHub.
 * A inicialização do serviço é feita de forma tardia (lazy), ou seja, a instância do Retrofit
 * só é criada na primeira vez que o [service] é acessado.
 */
object RetrofitClient {

    /**
     * URL base da API do GitHub. Todas as requisições partirão deste endereço.
     */
    //url base da api do github (termine com /)
    private const val BASE_URL = "https://api.github.com/"

    /**
     * Instância do serviço Retrofit para a interface [GitHubService].
     *
     * Utiliza `lazy` para garantir que a instância do Retrofit seja criada apenas uma vez,
     * no primeiro uso, o que melhora a performance.
     *
     * A configuração inclui:
     * - A URL base definida em [BASE_URL].
     * - O conversor [GsonConverterFactory] para serializar e desserializar objetos JSON
     *   automaticamente.
     */
    //criar com lazy
    val service: GitHubService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubService::class.java)
    }
}