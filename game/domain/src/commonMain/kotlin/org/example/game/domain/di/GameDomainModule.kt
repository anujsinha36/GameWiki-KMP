package org.example.game.domain.di

import org.example.game.domain.usecases.GetGameUseCase
import org.koin.dsl.module

fun getGetDomainModule() = module{
    factory {
        GetGameUseCase(gameRepository = get ())
    }
}