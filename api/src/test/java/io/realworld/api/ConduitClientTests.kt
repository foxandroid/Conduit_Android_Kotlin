package io.realworld.api

import io.realworld.api.models.entities.UserCreds
import io.realworld.api.models.requests.SignUpRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.random.Random

class ConduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun getArticles() {
        runBlocking {

            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun getArticlesByAuthor() {
        runBlocking {

            val articles = conduitClient.api.getArticles(author = "Gerome")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun getArticlesByTags() {
        runBlocking {

            val articles = conduitClient.api.getArticles(tags = "codebaseShow")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `Post users - create user`(){

        val userCreds = UserCreds(
            "testemail${Random.nextInt(456,3748)}@test.com",
            password = "pass${Random.nextInt(999999,9999999)}",
            username = "rand_user_${Random.nextInt(999,9999)}"
        )

        runBlocking {

            val resp = conduitClient.api.signupUser(SignUpRequest(userCreds))
            assertEquals(userCreds.username,resp.body()?.user?.username)
        }
    }

}