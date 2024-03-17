package com.example.demo.src.article;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.article.model.GetAllArticles;
import com.example.demo.src.article.model.GetArticlesRes;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.List;


@RestController
@RequestMapping("/app/articles")
public class ArticleController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final ArticleProvider articleProvider;

    public ArticleController(ArticleProvider articleProvider) {
        this.articleProvider = articleProvider;
    }

    /*
     * 전체 기사 조회 API
     * [GET] / articles
     */
    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetArticlesRes>> getArticles(){

        try{
            List<GetArticlesRes> getArticles= articleProvider.retrieveArticle();

            return new BaseResponse<>(getArticles);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }

    }
}
