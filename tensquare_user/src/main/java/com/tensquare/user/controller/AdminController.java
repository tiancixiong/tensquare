package com.tensquare.user.controller;

import com.tensquare.user.pojo.Admin;
import com.tensquare.user.service.AdminService;
import entity.PageResult;
import entity.Result;
import enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 管理员_控制器层
 * @author TianCi.Xiong
 * @since 2020/10/20 22:19
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), adminService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), adminService.findById(id));
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
        Page<Admin> pageList = adminService.findSearch(searchMap, page, size);
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), new PageResult<Admin>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), adminService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param admin
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Admin admin) {
        adminService.add(admin);
        return new Result(true, ResultEnum.ADD_SUCCESS.getCode(), ResultEnum.ADD_SUCCESS.getMsg());
    }

    /**
     * 修改
     * @param admin
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Admin admin, @PathVariable String id) {
        admin.setId(id);
        adminService.update(admin);
        return new Result(true, ResultEnum.EDIT_SUCCESS.getCode(), ResultEnum.EDIT_SUCCESS.getMsg());
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        adminService.deleteById(id);
        return new Result(true, ResultEnum.DEL_SUCCESS.getCode(), ResultEnum.DEL_SUCCESS.getMsg());
    }

    /**
     * 用户登陆
     * @param loginMap
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Map<String, String> loginMap) {
        Admin admin = adminService.findByLoginnameAndPassword(loginMap.get("loginname"), loginMap.get("password"));
        if (admin != null) {
            return new Result(true, ResultEnum.SUCCESS.getCode(), "登陆成功");
        } else {
            return new Result(false, ResultEnum.LOGINERROR.getCode(), "用户名或密码错误");
        }
    }

}
