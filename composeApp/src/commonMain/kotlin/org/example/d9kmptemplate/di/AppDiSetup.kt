package org.example.d9kmptemplate.di

import org.example.coreNetwork.di.getCoreNetworkModule
import org.example.game.data.di.getGameDataModule
import org.example.game.domain.di.getGameDomainModule
import org.example.game.ui.di.getGameUiModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(KoinApplication: ((KoinApplication) -> Unit)? = null){
    startKoin {
        modules(
            getGameDomainModule(),
            getGameDataModule(),
            getCoreNetworkModule(),
            getGameUiModule()
        )
    }

}