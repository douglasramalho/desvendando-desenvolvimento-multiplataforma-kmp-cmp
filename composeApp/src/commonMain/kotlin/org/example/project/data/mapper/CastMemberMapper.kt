package org.example.project.data.mapper

import org.example.project.data.network.IMAGE_SMALL_BASE_URL
import org.example.project.data.network.model.CastMemberResponse
import org.example.project.domain.model.CastMember

fun CastMemberResponse.toModel() = CastMember(
    id = this.id,
    name = this.name,
    mainRole = this.department,
    character = this.character,
    profileUrl = "$IMAGE_SMALL_BASE_URL/${this.profilePath}",
)