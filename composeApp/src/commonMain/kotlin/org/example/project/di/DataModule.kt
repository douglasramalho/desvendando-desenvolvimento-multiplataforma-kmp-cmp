package org.example.project.di

import org.example.project.data.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module {
    factory { MoviesRepository(get()) }
}