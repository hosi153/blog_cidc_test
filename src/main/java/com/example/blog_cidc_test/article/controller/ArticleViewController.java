package com.example.blog_cidc_test.article.controller;

import com.example.blog_cidc_test.article.entity.Article;
import com.example.blog_cidc_test.article.repository.ArticleRepository;
import com.example.blog_cidc_test.article.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleViewController {

    final ArticleService articleService;
    final ArticleRepository articleRepository;

    public ArticleViewController(ArticleService articleService, ArticleRepository articleRepository) {
        this.articleService = articleService;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/article")
    public String getArticle(Model model){
        List<Article> rs = articleRepository.findAll();
        model.addAttribute("article",rs);
        return "articleList";
    }

    @GetMapping("/new-article")
    public String newArticle(){
        return  "newArticle";
    }
}
