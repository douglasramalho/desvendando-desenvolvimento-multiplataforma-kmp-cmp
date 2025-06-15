package org.example.project.domain.model

import org.example.project.data.network.IMAGE_SMALL_BASE_URL
import org.example.project.data.network.model.MovieResponse

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val genres: List<Genre>?,
    val year: Int,
    val duration: String?,
    val rating: String,
    val castMembers: List<CastMember>?
)

// fake objects
val movie1 = Movie(
    id = 1,
    title = "A Minecraft Movie",
    overview = "Movie Overview",
    posterUrl = "https://example.com/poster1.jpg",
    genres = listOf(genre1, genre2),
    year = 2022,
    duration = "2h 36min",
    rating = "8.5",
    castMembers = listOf(
        castMember1,
        castMember2,
    )
)
