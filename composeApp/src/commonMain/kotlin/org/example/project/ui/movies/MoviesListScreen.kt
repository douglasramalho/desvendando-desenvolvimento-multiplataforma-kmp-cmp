package org.example.project.ui.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.data.repository.MoviesRepository
import org.example.project.domain.model.MovieSection
import org.example.project.ui.components.MoviesSection

@Composable
fun MoviesListRoute(
    viewModel: MoviesListViewModel = viewModel {
        MoviesListViewModel(
            moviesRepository = MoviesRepository()
        )
    }
) {
    val moviesListState by viewModel.moviesListState.collectAsStateWithLifecycle()

    MoviesListScreen(
        moviesListState = moviesListState,
    )
}

@Composable
fun MoviesListScreen(
    moviesListState: MoviesListViewModel.MoviesListState,
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (moviesListState) {
                MoviesListViewModel.MoviesListState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }

                is MoviesListViewModel.MoviesListState.Success -> {
                    LazyColumn(
                        modifier = Modifier,
                        contentPadding = PaddingValues(vertical = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        items(moviesListState.movieSections) { movieSection ->
                            val title = when (movieSection.sectionType) {
                                MovieSection.SectionType.POPULAR -> "Popular Movies"
                                MovieSection.SectionType.TOP_RATED -> "Top Rated Movies"
                                MovieSection.SectionType.UPCOMING -> "Upcoming Movies"
                            }

                            MoviesSection(
                                title = title,
                                movies = movieSection.movies
                            )
                        }
                    }
                }

                is MoviesListViewModel.MoviesListState.Error -> {
                    Text(
                        text = moviesListState.message,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}