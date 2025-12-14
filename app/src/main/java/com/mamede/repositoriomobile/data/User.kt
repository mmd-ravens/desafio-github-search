package com.mamede.repositoriomobile.data

import  com.google.gson.annotations.SerializedName


/**
 * Representa um usuário do GitHub.
 *
 * Esta data class é utilizada pelo Gson para desserializar a resposta JSON da API do GitHub
 * em um objeto Kotlin. Cada propriedade corresponde a um campo específico no JSON do perfil do usuário.
 * A anotação [SerializedName] é usada para mapear o nome do campo JSON para a propriedade da classe.
 *
 * @property login O nome de usuário (login) único do usuário no GitHub.
 * @property avatarUrl A URL para a imagem de avatar do usuário.
 * @property htmlUrl A URL para a página de perfil do usuário no GitHub.
 * @property name O nome de exibição do usuário. Este campo é opcional e pode ser nulo.
 * @property bio A biografia do usuário. Este campo é opcional e pode ser nulo.
 */
data class User (
    //SerializedName liga o nome que vem da API á variável do kotlin

    /**
     * O nome de usuário único usado para login. Mapeado do campo JSON "login".
     */
    @SerializedName("login") val login: String,

    /**
     * A URL da imagem de perfil (avatar) do usuário. Mapeado do campo JSON "avatar_url".
     */
    @SerializedName("avatar_url") val avatarUrl: String,

    /**
     * O link web para o perfil público do usuário no GitHub. Mapeado do campo JSON "html_url".
     */
    @SerializedName("html_url") val htmlUrl: String,

    /**
     * O nome real/completo do usuário. Pode ser nulo se não for fornecido pelo usuário. Mapeado do campo JSON "name".
     */
    @SerializedName("name") val name: String?,

    /**
     * A biografia pessoal do usuário. Pode ser nula se não for preenchida. Mapeado do campo JSON "bio".
     */
    @SerializedName("bio") val bio: String?
) {
}