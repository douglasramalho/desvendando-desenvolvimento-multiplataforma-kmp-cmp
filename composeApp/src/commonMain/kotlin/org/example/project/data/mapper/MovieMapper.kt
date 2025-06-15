package org.example.project.data.mapper

import org.example.project.data.network.IMAGE_SMALL_BASE_URL
import org.example.project.data.network.model.CastMemberResponse
import org.example.project.data.network.model.MovieResponse
import org.example.project.domain.model.Movie
import kotlin.math.roundToInt

fun MovieResponse.toModel(castMembersResponse: List<CastMemberResponse>? = null) = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}",
    genres = this.genres?.map { it.toModel() },
    year = this.getYearFromReleaseDate(),
    duration = this.getDurationInHoursAndMinutes(),
    rating = "${this.voteArerage.roundToInt()}",
    castMembers = castMembersResponse
        ?.filter { it.department == "Acting" }
        ?.take(20)
        ?.map { it.toModel() },
)

private fun MovieResponse.getYearFromReleaseDate(): Int {
    return this.releaseDate.year
}

private fun MovieResponse.getDurationInHoursAndMinutes(): String? {
    return this.runtime?.let { runtimeMinutes ->
        val hours = runtimeMinutes / 60
        val minutes = runtimeMinutes % 60

        buildString {
            if (hours > 0) {
                append("${hours}h ")
            }

            append("${minutes}min")
        }
    }
}