package org.example.project.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Star
import org.example.project.domain.model.MovieSection
import org.example.project.domain.model.movie1
import org.example.project.ui.components.CastMemberItem
import org.example.project.ui.components.MovieGenreChip
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
        movie = movie1,
        onMoviePosterClick = {},
    )
}

@Preview(showBackground = true)
@Composable
private fun MoviesListScreenPreview() {
    MoviesAppTheme {
        MoviesListScreen(
            moviesListState = MoviesListViewModel.MoviesListState.Success(
                movieSections = listOf(
                    MovieSection(
                        sectionType = MovieSection.SectionType.POPULAR,
                        movies = listOf(
                            movie1,
                        ),
                    )
                )
            ),
            onMovieClick = {},
        )
    }
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

@Preview(showBackground = true)
@Composable
private fun MovieGenreChipPreview() {
    MoviesAppTheme {
        MovieGenreChip(
            genre = "Action"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CastMemberItemPreview() {
    MoviesAppTheme {
        CastMemberItem(
            profilePictureUrl = "url",
            name = "Will Smith",
            character = "John Smith",
        )
    }
}