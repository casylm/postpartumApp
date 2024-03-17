package com.example.demo.src.article;

import com.example.demo.config.BaseException;
import com.example.demo.src.article.model.GetAllArticles;
import com.example.demo.src.article.model.GetArticlesRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;
import static com.example.demo.config.BaseResponseStatus.SUCCESS;

//Provider : Read 비즈니스 로직 처리
@Service
public class ArticleProvider {

    private final ArticleDao articleDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ArticleProvider(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }


    public List<GetArticlesRes> retrieveArticle() throws BaseException {

        try{
            List<GetArticlesRes> getArticles = articleDao.selectArticles();
            System.out.println(getArticles);
            return getArticles;
        } catch(Exception exception){
            System.out.println(exception);

            throw new BaseException(DATABASE_ERROR);
        }
    }
}
