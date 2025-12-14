package com.mamede.repositoriomobile.data.model

import com.google.gson.annotations.SerializedName

/**
 * Representa um único repositório do GitHub.
 *
 * Esta data class é utilizada pelo Gson para desserializar a resposta JSON da API do GitHub
 * em um objeto Kotlin. Cada propriedade corresponde a um campo no JSON do repositório.
 *
 * @property name O nome do repositório. Mapeado do campo JSON "name".
 * @property description A descrição do repositório. Pode ser nulo se não houver descrição. Mapeado de "description".
 * @property htmlUrl A URL completa para acessar o repositório em um navegador. Mapeado de "html_url".
 * @property language A linguagem de programação principal do repositório. Pode ser nulo. Mapeado de "language".
 * @property stargazersCount O número de estrelas (favoritos) que o repositório recebeu. Mapeado de "stargazers_count".
 */
data class Repository(

    /**
     * O nome do repositório.
     */
    @SerializedName("name") val name: String,

    /**
     * A descrição textual do repositório. É opcional e pode ser nula.
     */
    @SerializedName("description") val description: String?,

    /**
     * O link web para a página principal do repositório.
     */
    @SerializedName("html_url") val htmlUrl: String,

    /**
     * A linguagem de programação predominante usada no repositório. É opcional e pode ser nula.
     */
    @SerializedName("language") val language: String?,

    /**
     * A linguagem de programação predominante usada no repositório. É opcional e pode ser nula.
     */
    @SerializedName("stargazers_count") val stargazersCount: Int
)
