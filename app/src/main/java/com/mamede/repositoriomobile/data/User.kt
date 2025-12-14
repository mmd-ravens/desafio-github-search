package com.mamede.repositoriomobile.data

import  com.google.gson.annotations.SerializedName


data class User (
    //SerializedName liga o nome que vem da API á variável do kotlin
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("name") val name: String?,
    @SerializedName("bio") val bio: String?
) {
}