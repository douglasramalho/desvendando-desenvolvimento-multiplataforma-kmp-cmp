package org.example.project.domain.model

data class MovieSection(
    val sectionType: SectionType,
    val movies: List<Movie>,
) {
    enum class SectionType {
        POPULAR,
        TOP_RATED,
        UPCOMING,
    }
}
