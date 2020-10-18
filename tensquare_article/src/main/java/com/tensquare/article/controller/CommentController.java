package com.tensquare.article.controller;

import com.tensquare.article.pojo.Comment;
import com.tensquare.article.service.CommentService;
import entity.Result;
import enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评论_控制器层
 * @author TianCi.Xiong
 * @since 2020/10/18 23:23
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 新增评论
     * @param comment
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, ResultEnum.ADD_FAIL.getCode(), "提交成功 ");
    }

    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    @RequestMapping(value = "/article/{articleid}", method = RequestMethod.GET)
    public Result findByArticleid(@PathVariable String articleid) {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), "查询成功",
                commentService.findByArticleid(articleid));
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        commentService.deleteById(id);
        return new Result(true, ResultEnum.DEL_SUCCESS.getCode(), ResultEnum.DEL_SUCCESS.getMsg());
    }
}
