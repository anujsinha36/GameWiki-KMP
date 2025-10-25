package org.example.coreNetwork.apiservice

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path
import org.example.coreNetwork.model.game.GameResponse

class ApiService(
    val httpClient: HttpClient
) {
    suspend fun getGames(): Result<GameResponse>{
       return try {
            val response = httpClient.get {
                url{
                    path("api/games")
                    parameter("key", "93516b9f0a8547848471f1b24f76130b")
                }
            }.body<GameResponse>()
            Result.success(response)
        }
        catch (e: Exception){
            Result.failure(e)
        }
    }
}