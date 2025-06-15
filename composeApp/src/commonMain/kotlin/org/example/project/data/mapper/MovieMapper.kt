package org.example.project.data.mapper

import org.example.project.data.network.IMAGE_BASE_URL
import org.example.project.data.network.model.CastMemberResponse
import org.example.project.data.network.model.MovieResponse
import org.example.project.domain.model.ImageSize
import org.example.project.domain.model.Movie
import org.example.project.utils.formatRating
import kotlin.math.roundToInt

fun MovieResponse.toModel(
    castMembersResponse: List<CastMemberResponse>? = null,
    imageSize: ImageSize = ImageSize.SMALL,
) = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_BASE_URL/${imageSize.size}/${this.posterPath}",
    genres = this.genres?.map { it.toModel() },
    year = this.getYearFromReleaseDate(),
    duration = this.getDurationInHoursAndMinutes(),
    rating = this.voteArerage.formatRating(),
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