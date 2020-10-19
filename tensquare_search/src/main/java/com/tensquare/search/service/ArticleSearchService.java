package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * 文章_服务层
 * @author TianCi.Xiong
 * @since 2020/10/19 21:18
 */
@Service
public class ArticleSearchService {
    @Autowired
    private ArticleSearchDao articleSearchDao;

    /**
     * 增加文章
     * @param article
     */
    public void save(Article article) {
        articleSearchDao.save(article);
    }

    /**
     * 文章搜索
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords, keywords, pageRequest);
    }
}
