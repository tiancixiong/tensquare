package com.tensquare.friend.controller;

import com.tensquare.friend.service.FriendService;
import entity.Result;
import enums.ResultEnum;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 交友_控制器类
 * @author TianCi.Xiong
 * @since 2020/10/22 21:27
 */
@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 添加好友
     * @param friendid 对方用户ID
     * @param type     1：喜欢 0：不喜欢
     * @return
     */
    @RequestMapping(value = "/like/{friendid}/{type}", method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid, @PathVariable String type) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, ResultEnum.ACCESSERROR.getCode(), "无权访问");
        }
        if (type.equals("1")) {
            //如果是喜欢
            if (friendService.addFriend(claims.getId(), friendid) == 0) {
                return new Result(false, ResultEnum.REPERROR.getCode(), "已经添加此好友");
            }
        } else {
            //不喜欢
            friendService.addNoFriend(claims.getId(), friendid);//向不喜欢列表中添加记录
        }
        return new Result(true, ResultEnum.SUCCESS.getCode(), "操作成功");
    }

    /**
     * 删除好友
     * @param friendid
     * @return
     */
    @RequestMapping(value = "/{friendid}", method = RequestMethod.DELETE)
    public Result remove(@PathVariable String friendid) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, ResultEnum.ACCESSERROR.getCode(), "无权访问");
        }
        friendService.deleteFriend(claims.getId(), friendid);
        return new Result(true, ResultEnum.SUCCESS.getCode(), "删除成功");
    }

}
