package com.example.demo.src.article.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GetArticlesRes {
    private String userId;
    private int id;
    private String articleURL;
    private String keyword;
}
