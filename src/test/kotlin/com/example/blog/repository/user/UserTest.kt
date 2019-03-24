package com.example.blog.repository.user

import org.aspectj.lang.annotation.Before
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
internal class UserTest @Autowired constructor(
               val entityManager: TestEntityManager,
               val userRepository: IUserRepository) {

  //  @Before
    //fun setUp() {

    //}


    @Test
    fun `Test findByUsername and return User`() {
        println(">> testing findByUsername")
        val zack = User("Zack", "Zackeree", "Henry")
        entityManager.persist(zack)
        entityManager.flush()
        val user = userRepository.findByUsername("Zack")
        assertThat(user).isEqualTo(zack);
    }

    @Test
    fun `Test findByFirstName and return User`() {
        println(">> testing findByFirstName")
        val zack = User("Zack", "Zackeree", "Henry")
        entityManager.persist(zack)
        entityManager.flush()
        val user = userRepository.findByFirstName("Zackeree")
        assertThat(user).isEqualTo(zack);
    }

    @Test
    fun `Test findByLastName and return User`() {
        println(">> testing findByLastName")
        val zack = User("Zack", "Zackeree", "Henry")
        entityManager.persist(zack)
        entityManager.flush()
        val user = userRepository.findByLastName("Henry")
        assertThat(user).isEqualTo(zack);
    }
}