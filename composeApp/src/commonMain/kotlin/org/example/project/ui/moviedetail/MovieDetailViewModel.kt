package org.example.project.ui.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.repository.MoviesRepository
import org.example.project.domain.model.Movie
import org.example.project.navigation.AppRoutes

class MovieDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val moviesRepository: MoviesRepository,
) : ViewModel() {

    private val movieDetailRoute = savedStateHandle.toRoute<AppRoutes.MovieDetail>()

    private val _movieDetailState = MutableStateFlow<MovieDetailState>(MovieDetailState.Loading)
    val movieDetailState = _movieDetailState.asStateFlow()

    init {
        getMovieDetail()
    }

    private fun getMovieDetail() {
        viewModelScope.launch {
            moviesRepository.getMovieDetail(movieDetailRoute.id).fold(
                onSuccess = { movie ->
                    _movieDetailState.update {
                        MovieDetailState.Success(movie)
                    }
                },
                onFailure = { error ->
                    _movieDetailState.update {
                        MovieDetailState.Error(error.message ?: "Unknown error")
                    }
                }
            )
        }
    }

    sealed interface MovieDetailState {
        data object Loading : MovieDetailState
        data class Success(val movie: Movie) : MovieDetailState
        data class Error(val message: String) : MovieDetailState
    }
}