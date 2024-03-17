package com.example.demo.src.article;

import com.example.demo.src.article.model.GetAllArticles;
import com.example.demo.src.article.model.GetArticlesRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ArticleDao {

    private JdbcTemplate jdbcTemplate;
    private List<GetArticlesRes> selectArticles;

    @Autowired
    public void setDataSource(DataSource dataSource){

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // article 조회
    public List<GetArticlesRes> selectArticles(){
        String selectArticleQuery = "SELECT * FROM article";
//                "        WHERE usrId = ?;";
//        String selectArticleParam = null;

        return this.jdbcTemplate.query(selectArticleQuery,
                (rs,rowNum) -> new GetArticlesRes(
                        rs.getString("userId"),
                        rs.getInt("id"),
                        rs.getString("articleURL"),
                        rs.getString("keyword")));
    }
}
