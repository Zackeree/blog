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
@Table(name="article")
data class Article(
        @Column(name="title", nullable = false)
        var title: String,
        @Column(name="headline", nullable = false)
        var headline: String,
        @Column(name="content", nullable = false)
        var content: String,
        //@JoinColumn(name="author", nullable = false)
        @ManyToOne var author: User,
        @Column(name="slug", nullable = false)
        var slug: String = title.toSlug(),
        @Column(name="date", nullable = false)
        var date: LocalDateTime = LocalDateTime.now(),
        @Column(name = "id", unique = true, nullable = false)
        @Id @GeneratedValue var id: Long = 0)