package com.tensquare.article.dao;

import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 评论_数据访问接口
 * @author TianCi.Xiong
 * @since 2020/10/18 22:53
 */
public interface CommentDao extends MongoRepository<Comment, String> {
    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid);
}
