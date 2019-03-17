package com.example.blog.repository.user

import javax.persistence.*

/**
 * Entity Class representing a [User] for the web-application
 *
 * This Entity correlates to the User SQL table
 */

@Entity
class User(
        //@Column(name = "username", unique = true)
        var username: String,
        //@Column(name = "firstName")
        var firstName: String,
        //@Column(name = "lastName")
        var lastName: String,
        //@Column(name = "description")
        var description: String? = null,
        //@Column(name = "id", unique = true)
        @Id @GeneratedValue var id: Long? = null)