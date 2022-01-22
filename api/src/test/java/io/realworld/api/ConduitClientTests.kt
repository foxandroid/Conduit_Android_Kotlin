package io.realworld.api

import org.junit.Assert.assertNotNull
import org.junit.Test

class ConduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun getArticles(){
       val articles = conduitClient.api.getArticles().execute()
        assertNotNull(articles.body()?.articles)

    }

}