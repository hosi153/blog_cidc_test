package com.example.blog_cidc_test.article.controller;


import com.example.blog_cidc_test.article.dto.ArticlePatchDto;
import com.example.blog_cidc_test.article.dto.ArticlePostDto;
import com.example.blog_cidc_test.article.entity.Article;
import com.example.blog_cidc_test.article.mapper.ArticleMapper;
import com.example.blog_cidc_test.article.repository.ArticleRepository;
import com.example.blog_cidc_test.article.service.ArticleService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article/api")
public class ArticleAPIController {

    final ArticleService articleService;
    final ArticleMapper articleMapper;

    public ArticleAPIController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;

    }



    @PostMapping
    public ResponseEntity postArticle(@RequestBody ArticlePostDto articlePostDto){
        Article article = articleService.createArticle(articleMapper.articlePostDtoToArticle(articlePostDto));
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity patchArticle (@PathVariable("id")long id,
                                        @RequestBody ArticlePatchDto articlePatchDto){
        articlePatchDto.setId(id);
        Article article = articleService.updateArticle(
                articleMapper.articlePatchDtoToArticle(articlePatchDto)
        );
        return new ResponseEntity<>(
                articleMapper.articleToArticleResponseDto(article),HttpStatus.OK
        );

    }

//    @GetMapping("//")


    @GetMapping("{id}")
    public ResponseEntity getArticle(@PathVariable("id")long id){
        Article article = articleService.findArticle(id);
        return new ResponseEntity(
                articleMapper.articleToArticleResponseDto(article),HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity getArticles(@RequestParam int page, @RequestParam int size){
        Page<Article> pageArticle = articleService.findArticles(page-1,size);
        List<Article> list = pageArticle.getContent();
        return new ResponseEntity<>(
                articleMapper.articleToArticleResponseDtos(list),HttpStatus.OK
        );
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteArticle(@PathVariable("id")long id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
