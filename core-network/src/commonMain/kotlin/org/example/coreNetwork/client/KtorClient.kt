package org.example.coreNetwork.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    fun getClient(): HttpClient = HttpClient {
        install(ContentNegotiation){
            json(json = Json {
                ignoreUnknownKeys = true
            })
        }
        install(DefaultRequest){
            url{
                host = "api.rawg.io"
                protocol = URLProtocol.HTTP
                contentType(ContentType.Application.Json)  //Send data as JSON
                accept(ContentType.Application.Json)        //Request and accept response in JSON
            }
        }
    }
}


// https://api.rawg.io/api/games?key=93516b9f0a8547848471f1b24f76130b