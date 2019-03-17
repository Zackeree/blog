package com.example.blog.repository.user

import com.example.blog.repository.user.IUserRepository
import org.aspectj.lang.annotation.Before
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class UserTest @Autowired constructor(
               val entityManager: TestEntityManager,
               val userRepository: IUserRepository) {

    @Test
    fun `Test findByUsername and return User`() {
        println(">> testing findByUsername")
        val zack = User("Zack", "Zackeree", "Henry")
        entityManager.persist(zack)
        entityManager.flush()
        val user = userRepository.findByUsername("Zack")
        assertThat(user).isEqualTo(zack);
    }
}