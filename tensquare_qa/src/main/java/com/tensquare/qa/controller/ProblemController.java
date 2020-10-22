package com.tensquare.qa.controller;

import com.tensquare.qa.client.LabelClient;
import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import enums.ResultEnum;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 问题_控制器层
 * @author TianCi.Xiong
 * @since 2020/10/14 16:48
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LabelClient labelClient;

    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), problemService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), problemService.findById(id));
    }


    /**
     * 分页+多条件查询
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), new PageResult<Problem>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), problemService.findSearch(searchMap));
    }

    /**
     * 发布问题
     * @param problem
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Problem problem) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, ResultEnum.ACCESSERROR.getCode(), "无权访问");
        }
        problem.setUserid(claims.getId());

        problemService.add(problem);
        return new Result(true, ResultEnum.ADD_SUCCESS.getCode(), "增加成功");
    }

    /**
     * 修改
     * @param problem
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Problem problem, @PathVariable String id) {
        problem.setId(id);
        problemService.update(problem);
        return new Result(true, ResultEnum.EDIT_SUCCESS.getCode(), ResultEnum.EDIT_SUCCESS.getMsg());
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        problemService.deleteById(id);
        return new Result(true, ResultEnum.DEL_SUCCESS.getCode(), ResultEnum.DEL_SUCCESS.getMsg());
    }

    /**
     * 根据标签ID查询最新问题列表
     * @param labelid
     * @return
     */
    @RequestMapping(value = "/newlist/{labelid}/{page}/{size}", method = RequestMethod.GET)
    public Result findNewListByLabelId(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
        Page<Problem> pageList = problemService.findNewListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), pageResult);
    }

    /**
     * 根据标签ID查询热门问题列表
     * @param labelid
     * @return
     */
    @RequestMapping(value = "/hotlist/{labelid}/{page}/{size}", method = RequestMethod.GET)
    public Result findHotListByLabelId(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
        Page<Problem> pageList = problemService.findHotListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), pageResult);
    }

    /**
     * 根据标签ID查询等待回答列表
     * @param labelid
     * @return
     */
    @RequestMapping(value = "/waitlist/{labelid}/{page}/{size}", method = RequestMethod.GET)
    public Result findWaitListByLabelId(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
        Page<Problem> pageList = problemService.findWaitListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), pageResult);
    }

    /**
     *
     * @param labelid
     * @return
     */
    @RequestMapping(value = "/label/{labelid}")
    public Result findLabelById(@PathVariable String labelid) {
        Result result = labelClient.findById(labelid);
        return result;
    }

}
