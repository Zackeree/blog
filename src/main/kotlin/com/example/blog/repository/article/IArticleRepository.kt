package com.example.blog.repository.article

import com.example.blog.repository.user.User
import org.springframework.data.repository.CrudRepository

/**
 * Spring Repository for the [Article] Entity.
 */

interface IArticleRepository : CrudRepository<Article, Long> {

    /**
     * Spring Repository method that will grab an [Article] by the title field
     * @param title the title of the article
     *
     * @return an [Article]
     */
    fun findByTitle(title: String): Article?


    /**
     * Spring Repository method that will grab an [Article] by the content field
     * @param content the text in the article
     *
     * @return an [Article]
     */
    fun findByContent(content: String): Article?


    /**
     * Spring Repository method that will grab an [Article] by the author field
     * @param author the author of the article
     *
     * @return an [Article]
     */
    fun findByAuthor(author: User): Article?


    /**
     * Spring Repository method that will grab an [Article] by the headline field
     * @param headline the headline of the article
     *
     * @return an [Article]
     */
    fun findByHeadline(headline: String): Article?


    /**
     * Spring Repository method that will grab an [Article] by the slug field
     * @param slug the title in production
     *
     * @return an [Article]
     */
    fun findBySlug(slug: String): Article?


    /**
     * Spring Repository method that will grab all [Article] objects by the title field
     * @param title the title of the article
     *
     * @return all [Article] objects
     */
    fun findAllByTitle(title: String): Iterable<Article>


    /**
     * Spring Repository method that will grab all [Article] objects by the headline field
     * @param headline the headline of the article
     *
     * @return all [Article] objects
     */
    fun findAllByHeadline(headline: String): Iterable<Article>


    /**
     * Spring Repository method that will grab all [Article] objects by the content field
     * @param content the text in the article
     *
     * @return all [Article] objects
     */
    fun findAllByContent(content: String): Iterable<Article>


    /**
     * Spring Repository method that will grab all [Article] objects by the author field
     * @param author the author of the article
     *
     * @return all [Article] objects
     */
    fun findAllByAuthor(author: User): Iterable<Article>


    /**
     * Spring Repository method that will grab all [Article] objects by the date added
     * in descending order
     *
     * @return all [Article] objects
     */
    fun findAllByOrderByDateDesc(): Iterable<Article>


    /**
     * Spring Repository method that will grab all [Article] objects by the date added
     * in ascending order
     *
     * @return all [Article] objects
     */
    fun findAllByOrderByDateAsc(): Iterable<Article>
}