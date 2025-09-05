package org.example.project.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class VideosListResponse(
    val id: Int,
    val results: List<VideoResponse>,
)

@Serializable
data class VideoResponse(
    val id: String,
    val name: String,
    val key: String,
    val site: String,
    val type: String,
    val official: Boolean,
)