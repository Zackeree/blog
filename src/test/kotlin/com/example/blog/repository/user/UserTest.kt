package com.example.blog.repository.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
internal class UserTest @Autowired constructor(
               val entityManager: TestEntityManager,
               val userRepository: IUserRepository) {

    // Initial Fields
    private lateinit var zack: User

    // Run this before each @Test
    @BeforeEach
    fun setup () {
        zack = User("Zack", "Zackeree", "Henry")
        entityManager.persist(zack)
        entityManager.flush()
    }

    @Test
    fun `Test findByUsername and return User`() {
        println(">> testing findByUsername")
        val user = userRepository.findByUsername("Zack")
        assertThat(user).isEqualTo(zack)
    }

    @Test
    fun `Test findByFirstName and return User`() {
        println(">> testing findByFirstName")
        val user = userRepository.findByFirstName("Zackeree")
        assertThat(user).isEqualTo(zack)
    }

    @Test
    fun `Test findByLastName and return User`() {
        println(">> testing findByLastName")
        val user = userRepository.findByLastName("Henry")
        assertThat(user).isEqualTo(zack)
    }
}