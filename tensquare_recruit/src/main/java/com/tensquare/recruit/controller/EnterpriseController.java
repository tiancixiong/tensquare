package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import entity.PageResult;
import entity.Result;
import enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 企业控制器层
 * @author TianCi.Xiong
 * @since 2020/10/14 12:54
 **/
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), enterpriseService.findAll());
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), enterpriseService.findById(id));
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
        Page<Enterprise> pageList = enterpriseService.findSearch(searchMap, page, size);
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), new PageResult<Enterprise>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), enterpriseService.findSearch(searchMap));
    }

    /**
     * 增加
     * @param enterprise
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Enterprise enterprise) {
        enterpriseService.add(enterprise);
        return new Result(true, ResultEnum.ADD_SUCCESS.getCode(), ResultEnum.ADD_SUCCESS.getMsg());
    }

    /**
     * 修改
     * @param enterprise
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Enterprise enterprise, @PathVariable String id) {
        enterprise.setId(id);
        enterpriseService.update(enterprise);
        return new Result(true, ResultEnum.EDIT_SUCCESS.getCode(), ResultEnum.EDIT_SUCCESS.getMsg());
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        enterpriseService.deleteById(id);
        return new Result(true, ResultEnum.DEL_SUCCESS.getCode(), ResultEnum.DEL_SUCCESS.getMsg());
    }

    /**
     * 查询热门企业
     * @return
     */
    @RequestMapping(value = "/search/hotlist", method = RequestMethod.GET)
    public Result hotlist() {
        return new Result(true, ResultEnum.QUERY_SUCCESS.getCode(), ResultEnum.QUERY_SUCCESS.getMsg(), enterpriseService.hotlist());
    }
}
