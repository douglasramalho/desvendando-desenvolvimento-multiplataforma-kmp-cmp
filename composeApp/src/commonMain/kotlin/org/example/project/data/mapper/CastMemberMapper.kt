package org.example.project.data.mapper

import org.example.project.data.network.IMAGE_BASE_URL
import org.example.project.data.network.model.CastMemberResponse
import org.example.project.domain.model.CastMember
import org.example.project.domain.model.ImageSize

fun CastMemberResponse.toModel() = CastMember(
    id = this.id,
    name = this.name,
    mainRole = this.department,
    character = this.character,
    profileUrl = "$IMAGE_BASE_URL/${ImageSize.X_SMALL.size}/${this.profilePath}",
)