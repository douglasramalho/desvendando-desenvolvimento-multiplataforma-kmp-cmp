package org.example.project.previews

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Star
import org.example.project.domain.model.MovieSection
import org.example.project.domain.model.movie1
import org.example.project.ui.components.MovieInfoItem
import org.example.project.ui.components.MoviePoster
import org.example.project.ui.moviedetail.MovieDetailScreen
import org.example.project.ui.movies.MoviesListScreen
import org.example.project.ui.movies.MoviesListViewModel
import org.example.project.ui.theme.MoviesAppTheme

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

@Preview(showBackground = true)
@Composable
private fun MovieDetailScreenPreview() {
    MoviesAppTheme {
        MovieDetailScreen(
            movie = movie1,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieInfoItemPreview() {
    MoviesAppTheme {
        MovieInfoItem(
            icon = FontAwesomeIcons.Solid.Star,
            text = "8.5"
        )
    }
}