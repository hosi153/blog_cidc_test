package com.example.blog_cidc_test.article.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArticlePatchDto {

    private long id;

    private String ArticleContent;
    private String ArticleTitle;

    @Builder

    public ArticlePatchDto(long id, String articleContent, String articleTitle) {
        this.id = id;
        ArticleContent = articleContent;
        ArticleTitle = articleTitle;
    }
}
