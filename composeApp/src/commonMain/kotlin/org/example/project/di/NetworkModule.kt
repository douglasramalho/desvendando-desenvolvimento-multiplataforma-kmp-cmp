package org.example.project.di

import org.example.project.data.network.KtorClient
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }
}