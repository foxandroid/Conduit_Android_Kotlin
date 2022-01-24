package io.realworld.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.realworld.api.models.entities.UserCreds

@JsonClass(generateAdapter = true)
data class SignUpRequest(
    @Json(name = "user")
    val userCreds: UserCreds
)