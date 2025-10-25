package org.example.coreNetwork.di

import org.example.coreNetwork.apiservice.ApiService
import org.example.coreNetwork.client.KtorClient
import org.koin.dsl.module

fun getCoreNetworkModule() = module {
    single { ApiService(httpClient = KtorClient.getClient()) }
}