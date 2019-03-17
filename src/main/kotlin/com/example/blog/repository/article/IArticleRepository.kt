package com.example.blog.repository.article

import org.springframework.data.repository.CrudRepository

/**
 * Spring Repository for the [Article] Entity.
 */

interface IArticleRepository : CrudRepository<Article, Long> {

    /**
     * Spring Repository method that will grab an [Article] by the slug field
     * @param slug the username
     *
     * @return an [Article]
     */

    fun findBySlug(slug: String): Article?

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