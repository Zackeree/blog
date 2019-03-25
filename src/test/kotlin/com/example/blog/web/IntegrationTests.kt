package com.example.blog.web

import com.example.blog.toSlug
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    // Assert that our articles are actually on the page
    @Test
    fun `Test article page title, content and status code`() {
        println(">> Assert article page title, content and status code")
        val title = "Welcome to the blog"
        val entity = restTemplate.getForEntity<String>("/article/${title.toSlug()}")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains(title, "Not much here huh?")

        val title2 = "First Post"
        val entity2 = restTemplate.getForEntity<String>("/article/${title2.toSlug()}")
        assertThat(entity2.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity2.body).contains(title2, "Sure is lonely...")
    }
}