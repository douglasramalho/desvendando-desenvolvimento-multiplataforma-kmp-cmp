package org.example.project.di

import org.example.project.ui.movies.MoviesListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MoviesListViewModel(get()) }
}