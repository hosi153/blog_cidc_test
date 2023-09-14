package com.example.blog_cidc_test.article.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArticlePostDto {



    private String ArticleContent;
    private String ArticleTitle;


    @Builder

    public ArticlePostDto(String articleContent, String articleTitle) {
        ArticleContent = articleContent;
        ArticleTitle = articleTitle;
    }
}
