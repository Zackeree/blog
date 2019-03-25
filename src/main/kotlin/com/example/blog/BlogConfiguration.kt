package com.example.blog

import com.example.blog.repository.article.Article
import com.example.blog.repository.article.IArticleRepository
import com.example.blog.repository.user.IUserRepository
import com.example.blog.repository.user.User
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    // Initialize our application's database by storing an initial user and two articles
    @Bean
    fun initializeDB(userRepository: IUserRepository, articleRepository: IArticleRepository) = ApplicationRunner {
        val user = userRepository.save(User(
                username = "Admin",
                firstName = "Admin",
                lastName = "McAdmin"))

        val article1 = articleRepository.save(Article(
                title = "Welcome to the blog",
                headline = "We hope you stay",
                content = "Not much here huh?",
                author = user
        ))

        val article2 = articleRepository.save(Article(
                title = "First Post",
                headline = "Zombie Outbreak Plagues Miama, FL",
                content = "Sure is lonely...",
                author = user
        ))
    }
}