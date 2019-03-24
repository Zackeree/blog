package com.example.blog.repository.article

import javax.persistence.*
import com.example.blog.repository.user.User
import com.example.blog.toSlug
import java.time.LocalDateTime

/**
 * Entity Class representing an [Article]
 *
 * This Entity correlates to the [Article] SQL Table
 */

@Entity
class Article(
        var title: String,
        var headline: String,
        var content: String,
        @ManyToOne var author: User,
        var slug: String = title.toSlug(),
        var date: LocalDateTime = LocalDateTime.now(),
        @Id @GeneratedValue var id: Long? = null)