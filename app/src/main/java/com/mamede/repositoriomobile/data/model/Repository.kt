package com.mamede.repositoriomobile.data.model

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("language") val language: String?,
    @SerializedName("stargazers_count") val stargazersCount: Int
)
