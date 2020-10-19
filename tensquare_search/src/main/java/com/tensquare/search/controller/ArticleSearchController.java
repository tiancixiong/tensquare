package com.tensquare.search.controller;

/**
 * 文章_控制器层
 * @author TianCi.Xiong
 * @since 2020/10/19 21:19
 */

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleSearchController {
    @Autowired
    private ArticleSearchService articleSearchService;

    /**
     * 添加文章
     * @param article
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        articleSearchService.save(article);
        return new Result(true, ResultEnum.ADD_SUCCESS.getCode(), "操作成功");
    }

    /**
     * 文章搜索
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search/{keywords}/{page}/{size}", method = RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords, @PathVariable int page, @PathVariable int size) {
        Page<Article> articlePage = articleSearchService.findByTitleLike(keywords, page, size);
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), "查询成功",
                new PageResult<Article>(articlePage.getTotalElements(), articlePage.getContent()));
    }
}
