package com.example.blog.repository.user

import javax.persistence.*

/*
    Generate User Entity, which corresponds to the user table

    Fields:

    username:       (Unique)
    firstName
    lastName
    description     (Optional)
    id              (Unique, Not Null)
 */

@Entity
@Table(name = "user")
class User(
        @Column(name = "username", unique = true)
        var username: String,
        @Column(name = "firstName")
        var firstName: String,
        @Column(name = "lastName")
        var lastName: String,
        @Column(name = "description")
        var description: String? = null
) {
    /*
        Auto generate id column starting at 0
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long = 0

    constructor(id: Long, username: String, email: String, password: String) : this(username, email, password) {
        this.id = id
    }
}