package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 文章_数据访问层接口
 * @author TianCi.Xiong
 * @since 2020/10/19 21:17
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article, String> {
    /**
     * 检索
     * @param
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
