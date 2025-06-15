package org.example.project.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.example.project.data.mapper.toModel
import org.example.project.data.network.KtorClient
import org.example.project.domain.model.Movie
import org.example.project.domain.model.MovieSection

class MoviesRepository(
    private val ktorClient: KtorClient,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun getMovieSections(): List<MovieSection> {
        return withContext(ioDispatcher) {
            val popularMoviesDeferred = async { ktorClient.getMovies("popular") }
            val topRatedMoviesDeferred = async { ktorClient.getMovies("top_rated") }
            val upcomingMoviesDeferred = async { ktorClient.getMovies("upcoming") }

            val popularMovies = popularMoviesDeferred.await()
            val topRatedMovies = topRatedMoviesDeferred.await()
            val upcomingMovies = upcomingMoviesDeferred.await()

            listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = popularMovies.results.map {
                        it.toModel()
                    }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.TOP_RATED,
                    movies = topRatedMovies.results.map {
                        it.toModel()
                    }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.UPCOMING,
                    movies = upcomingMovies.results.map {
                        it.toModel()
                    }
                )
            )
        }
    }

    suspend fun getMovieDetail(movieId: Int): Result<Movie> {
        return withContext(ioDispatcher) {
            runCatching {
                val movieDetailDeferred = async { ktorClient.getMovieDetail(movieId) }
                val creditsDeferred = async { ktorClient.getCredits(movieId) }

                val movieDetailResponse = movieDetailDeferred.await()
                val creditsResponse = creditsDeferred.await()

                movieDetailResponse.toModel(creditsResponse.cast)
            }
        }
    }
}