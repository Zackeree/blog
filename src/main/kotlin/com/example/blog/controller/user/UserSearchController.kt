package com.example.blog.controller.user

import com.example.blog.repository.user.IUserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserSearchController(private val repository: IUserRepository) {

    // Return a list of all User objects
    @GetMapping("/user")
    fun findAllUsers() = repository.findAll()

    // Return a single User object by searching for a username
    @GetMapping("/user/{username}")
    fun findUserByUsername(@PathVariable username: String) = repository.findByUsername(username)

    // Return a single User object by searching for a first name
    @GetMapping("/user/{firstName}")
    fun findUserByFirstName(@PathVariable firstName: String) = repository.findByFirstName(firstName)

    // Return a single User object by searching for a last name
    @GetMapping("/user/{lastName}")
    fun findUserByLastName(@PathVariable lastName: String) = repository.findByLastName(lastName)
}