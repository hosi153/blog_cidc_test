package com.example.blog_cidc_test.article.service;

import com.example.blog_cidc_test.article.entity.Article;
import com.example.blog_cidc_test.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article createArticle (Article article){
        return articleRepository.save(article);
    }

    public Article updateArticle(Article article){
        Article findArticle = findVerifiedArticle(article.getId());
        Optional.ofNullable(article.getArticleContent()).ifPresent(content -> findArticle.setArticleContent(content));
        Optional.ofNullable(article.getArticleTitle()).ifPresent(title -> findArticle.setArticleTitle(title));
        return articleRepository.save(findArticle);
    }

    public Article findArticle (long id){
        return findVerifiedArticle(id);
    }

    public Page<Article> findArticles(int page,int size){
        return articleRepository.findAll(PageRequest.of(page,size,Sort.by("id").descending()));
    }

    public void deleteArticle ( long id){
        articleRepository.delete(findVerifiedArticle(id));
    }


    public Article findVerifiedArticle(long id){
        Optional<Article> optionalArticle = articleRepository.findById(id);
        Article findArticle = optionalArticle.orElseThrow();
        return findArticle;
    }

}
