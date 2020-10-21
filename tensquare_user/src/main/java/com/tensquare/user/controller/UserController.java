package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.PageResult;
import entity.Result;
import enums.ResultEnum;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private JwtUtil jwtUtil;

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
     * 用户注册
     * @param user
     */
    @RequestMapping(value = "/register/{code}", method = RequestMethod.POST)
    public Result register(@RequestBody User user, @PathVariable String code) {
        userService.add(user, code);
        return new Result(true, ResultEnum.ADD_SUCCESS.getCode(), "注册成功");
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
        String authHeader = request.getHeader("Authorization");//获取头信息
        if (authHeader == null) {
            return new Result(false, ResultEnum.ACCESSERROR.getCode(), "权限不足");
        }
        if (!authHeader.startsWith("Bearer ")) {
            return new Result(false, ResultEnum.ACCESSERROR.getCode(), "权限不足");
        }
        String token = authHeader.substring(7);//提取token
        Claims claims = jwtUtil.parseJWT(token);
        if (claims == null) {
            return new Result(false, ResultEnum.ACCESSERROR.getCode(), "权限不足");
        }
        if (!"admin".equals(claims.get("roles"))) {
            return new Result(false, ResultEnum.ACCESSERROR.getCode(), "权限不足");
        }

        userService.deleteById(id);
        return new Result(true, ResultEnum.DEL_SUCCESS.getCode(), ResultEnum.DEL_SUCCESS.getMsg());
    }

    /**
     * 发送短信验证码
     * @param mobile
     */
    @RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST)
    public Result sendsms(@PathVariable String mobile) {
        userService.sendSms(mobile);
        return new Result(true, ResultEnum.SUCCESS.getCode(), "发送成功");
    }

    /**
     * 用户登陆
     * @param mobile
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(String mobile, String password) {
        User user = userService.findByMobileAndPassword(mobile, password);
        if (user != null) {
            return new Result(true, ResultEnum.SUCCESS.getCode(), "登陆成功");
        } else {
            return new Result(false, ResultEnum.LOGINERROR.getCode(), "用户名或密码错误");
        }
    }

}
