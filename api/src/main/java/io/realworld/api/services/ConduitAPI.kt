package io.realworld.api.services

import io.realworld.api.models.entities.UserCreds
import io.realworld.api.models.requests.SignUpRequest
import io.realworld.api.models.responses.ArticlesResponse
import io.realworld.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ConduitAPI {

    @POST("users")
    suspend fun signupUser(
        @Body userCreds: SignUpRequest
    ): Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author : String? = null,
        @Query("favourited") favourited : String? =null,
        @Query("tag") tags : String? = null
    ) : Response<ArticlesResponse>


}