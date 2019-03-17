package com.example.blog.repository.user

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Spring Repository for the [User] Entity.
 */
//@Repository
interface IUserRepository : CrudRepository<User, Long> {

    /**
     * Spring Repository method that will grab a [User] by the username field
     * @param username the username
     *
     * @return a [User]
     */
    fun findByUsername(username: String): User
}