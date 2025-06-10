package org.example.project.domain.model

import org.example.project.data.network.IMAGE_SMALL_BASE_URL
import org.example.project.data.network.model.MovieResponse

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
)

fun MovieResponse.toModel() = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}"
)

// fake objects
val movie1 = Movie(
    id = 1,
    title = "A Minecraft Movie",
    overview = "Movie Overview",
    posterUrl = "https://example.com/poster1.jpg",
)
