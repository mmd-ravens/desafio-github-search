package com.mamede.repositoriomobile.data.remote

import com.mamede.repositoriomobile.data.User
import com.mamede.repositoriomobile.data.model.Repository
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    //busca as informações
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): User

    //busca os repositórios
    @GET("users/{username}/repos")
    suspend fun getRepositories(@Path("username") username: String): List<Repository>
}
