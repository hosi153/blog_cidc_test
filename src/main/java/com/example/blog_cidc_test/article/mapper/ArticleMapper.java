package com.example.blog_cidc_test.article.mapper;

import com.example.blog_cidc_test.article.dto.ArticlePatchDto;
import com.example.blog_cidc_test.article.dto.ArticlePostDto;
import com.example.blog_cidc_test.article.dto.ArticleResponseDto;
import com.example.blog_cidc_test.article.entity.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

 Article articlePostDtoToArticle(ArticlePostDto articlePostDto);
     Article articlePatchDtoToArticle(ArticlePatchDto articlePatchDto);

     ArticleResponseDto articleToArticleResponseDto (Article article);
     List<ArticleResponseDto> articleToArticleResponseDtos (List<Article> articles);


}
