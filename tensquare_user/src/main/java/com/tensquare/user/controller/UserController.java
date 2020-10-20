package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.PageResult;
import entity.Result;
import enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户_控制器层
 * @author TianCi.Xiong
 * @since 2020/10/20 21:11
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), userService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), userService.findById(id));
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
        Page<User> pageList = userService.findSearch(searchMap, page, size);
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), new PageResult<User>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), userService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param user
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        userService.add(user);
        return new Result(true, ResultEnum.ADD_SUCCESS.getCode(), ResultEnum.ADD_SUCCESS.getMsg());
    }

    /**
     * 修改
     * @param user
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody User user, @PathVariable String id) {
        user.setId(id);
        userService.update(user);
        return new Result(true, ResultEnum.EDIT_SUCCESS.getCode(), ResultEnum.EDIT_SUCCESS.getMsg());
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        userService.deleteById(id);
        return new Result(true, ResultEnum.DEL_SUCCESS.getCode(), ResultEnum.DEL_SUCCESS.getMsg());
    }

}
