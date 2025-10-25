package org.example.game.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.example.game.domain.model.Game
import org.example.game.domain.repository.GameRepository

class GetGameUseCase(
    private val gameRepository: GameRepository
) {
    operator fun invoke()= flow<Result<List<Game>>>{
        emit(gameRepository.getGames())
    }.catch{error->
        emit(Result.failure(error))
    }.flowOn(Dispatchers.IO)
}