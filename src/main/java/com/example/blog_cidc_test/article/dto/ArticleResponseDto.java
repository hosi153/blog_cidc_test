package com.example.blog_cidc_test.article.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ArticleResponseDto {
    private long id;

    private String articleContent;
    private String articleTitle;

    @Builder
    public ArticleResponseDto(long id, String articleContent, String articleTitle) {
        this.id = id;
        this.articleContent = articleContent;
        this.articleTitle = articleTitle;
    }
}
