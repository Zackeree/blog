package com.example.blog.repository.user

import org.springframework.data.repository.CrudRepository

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


    /**
     * Spring Repository method that will grab a [User] by the firstName field
     * @param firstName the user's first name
     *
     * @return a [User]
     */
    fun findByFirstName(firstName: String): User


    /**
     * Spring Repository method that will grab a [User] by the lastName field
     * @param lastName the user's last name
     *
     * @return a [User]
     */
    fun findByLastName(lastName: String): User
}