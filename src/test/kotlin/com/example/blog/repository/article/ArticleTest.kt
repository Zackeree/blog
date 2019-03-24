package com.example.blog.repository.article

import com.example.blog.repository.user.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
internal class ArticleTest @Autowired constructor(
               val entityManager: TestEntityManager,
               val articleRepository: IArticleRepository) {

    // Initial Fields
    private lateinit var article: Article
    private lateinit var zack: User

    // Initialize Fields before each @Test tag
    @BeforeEach
    fun setup () {
        zack = User("Zack", "Zackeree", "Henry")
        article = Article("How to use Kotlin", "For Dummies", "Learn by doing!", zack)
        entityManager.persist(zack)
        entityManager.persist(article)
        entityManager.flush()
    }

    @Test
    fun `When findByIdOrNull then return Article`() {
        println(">> testing findByIdOrNull")
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `Test findByTitle and return Article`() {
        println(">> testing findByTitle")
        val found = articleRepository.findByTitle("How to use Kotlin")
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `Test findByHeadline and return Article`() {
        println(">> testing findByHeadline")
        val found = articleRepository.findByHeadline("For Dummies")
        val notFound = articleRepository.findByHeadline("Dummies")
        assertThat(found).isEqualTo(article)
        assertThat(notFound).isNotEqualTo(article)
    }

    @Test
    fun `Test findByContent and return Article`() {
        println(">> testing findByContent")
        val found = articleRepository.findByContent("Learn by doing!")
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `Test findByAuthor and return Article`() {
        println(">> testing findByAuthor")
        val found = articleRepository.findByAuthor(zack)
        assertThat(found).isEqualTo(article)
    }
}