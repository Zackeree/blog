package com.example.blog.controller.web

import com.example.blog.BlogProperties
import com.example.blog.format
import com.example.blog.repository.article.Article
import com.example.blog.repository.article.IArticleRepository
import com.example.blog.repository.user.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HtmlController (private val repository: IArticleRepository,
                      private val properties: BlogProperties) {

    @GetMapping("/")
    fun blog(model: Model): String {
        // org.springframework.ui.set allows us to declare model in this fashion
        // as opposed to model.addAttribute("title", "Blog")
        model["title"] = "Blog"
        model["articles"] = repository.findAllByOrderByDateDesc().map { it.render() }
        return "blog"
    }

    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug: String, model: Model): String {
        val article = repository
                .findBySlug(slug)
                ?.render()
                ?: throw IllegalArgumentException("Wrong article slug provided")
        model["title"] = article.title
        model["article"] = article
        return "article"
    }

    fun Article.render() = RenderedArticle(
            slug,
            title,
            headline,
            content,
            author,
            date.format()
    )

    data class RenderedArticle(
            val slug: String,
            val title: String,
            val headline: String,
            val content: String,
            val author: User,
            val date: String)
}