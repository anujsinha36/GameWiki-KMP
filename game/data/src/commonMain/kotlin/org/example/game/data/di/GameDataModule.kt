package org.example.game.data.di

import org.example.game.data.repository.GameRepositoryImpl
import org.example.game.domain.repository.GameRepository
import org.koin.dsl.module

fun getGameDataModule() = module {
    factory<GameRepository> {
        GameRepositoryImpl(apiService = get())
    }
}