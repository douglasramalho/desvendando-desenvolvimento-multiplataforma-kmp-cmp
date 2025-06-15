package org.example.project.data.mapper

import org.example.project.data.network.model.GenreResponse
import org.example.project.domain.model.Genre

fun GenreResponse.toModel() = Genre(
    id = this.id,
    name = this.name
)