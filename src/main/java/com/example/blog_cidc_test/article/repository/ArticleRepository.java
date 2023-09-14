package com.example.blog_cidc_test.article.repository;

import com.example.blog_cidc_test.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
