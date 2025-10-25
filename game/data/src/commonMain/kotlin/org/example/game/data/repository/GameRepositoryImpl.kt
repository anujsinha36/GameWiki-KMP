package org.example.game.data.repository

import org.example.coreNetwork.apiservice.ApiService
import org.example.game.data.mapper.toDomainListOfGames
import org.example.game.domain.model.Game
import org.example.game.domain.repository.GameRepository

class GameRepositoryImpl(
    val apiService: ApiService
): GameRepository {
    override suspend fun getGames(): Result<List<Game>> {
        val response = apiService.getGames()
       return if (response.isSuccess){
            Result.success(response.getOrThrow().results.toDomainListOfGames())
        }
        else{
            Result.failure(response.exceptionOrNull()!!)
        }
    }
}