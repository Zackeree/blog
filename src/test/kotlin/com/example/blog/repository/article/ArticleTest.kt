package com.example.blog.repository.article

import com.example.blog.repository.article.IArticleRepository
import com.example.blog.repository.article.Article
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager


@DataJpaTest
internal class ArticleTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val articleRepository: IArticleRepository) {


}