package com.example.blog.repository.user

import javax.persistence.*

/**
 * Entity Class representing a [User] for the web-application
 *
 * This Entity correlates to the User SQL table
 */

@Entity
@Table(name = "user")
data class User(
        @Column(name = "username", unique = true)
        var username: String,
        @Column(name = "first_name")
        var firstName: String,
        @Column(name = "last_name")
        var lastName: String,
        @Column(name = "description")
        var description: String? = null,
        @Column(name = "id", unique = true, nullable = false)
        @Id @GeneratedValue var id: Long = 0)
