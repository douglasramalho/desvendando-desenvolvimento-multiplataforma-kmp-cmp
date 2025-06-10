package org.example.project.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.project.domain.model.MovieSection
import org.example.project.domain.model.movie1
import org.example.project.ui.components.MoviePoster
import org.example.project.ui.movies.MoviesListScreen
import org.example.project.ui.movies.MoviesListViewModel

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        movie = movie1
    )
}

@Preview(showBackground = true)
@Composable
private fun MoviesListScreenPreview() {
    MoviesListScreen(
        moviesListState = MoviesListViewModel.MoviesListState.Success(
            movieSections = listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = listOf(
                        movie1,
                    )
                )
            )
        )
    )
}