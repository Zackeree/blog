package com.example.blog.controller.article

import com.example.blog.repository.article.IArticleRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/article")
class ArticleSearchController(private val repository: IArticleRepository) {

    // Return a list of all Article objects
    @GetMapping("/article")
    fun findAllArticles() = repository.findAllByOrderByDateDesc()


    // Return a single Article by searching for a title
    @GetMapping("/article/search/{title}")
    fun findArticleByTitle(@PathVariable title: String) = repository.findByTitle(title)
            ?: throw IllegalArgumentException("Unable to find any articles with that title")


    // Return a single Article by searching for a headline
    @GetMapping("/article/search/{headline}")
    fun findArticleByHeadline(@PathVariable headline: String) = repository.findByHeadline(headline)
            ?: throw IllegalArgumentException("Unable to find any articles with that headline")


    // Return a single Article by searching for content in the Article
    @GetMapping("/article/search/{content}")
    fun findArticleByContent(@PathVariable content: String) = repository.findByContent(content)
            ?: throw IllegalArgumentException("Unable to find any articles containing that text")


    // Return all Articles that contain the input string
    @Throws(IllegalArgumentException::class)
    @GetMapping("/article/search/{content}")
    fun findAllArticlesByContent(@PathVariable content: String) = repository.findAllByContent(content)
            ?: throw IllegalArgumentException("Unable to find any articles containing that text")


    // Return a single Article by searching for a slug
    @GetMapping("/article/search/{slug}")
    fun findArticleBySlug(@PathVariable slug: String) = repository.findBySlug(slug)
            ?: throw IllegalArgumentException("Unable to find any articles with that slug")
}