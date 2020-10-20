package com.tensquare.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.user.pojo.User;

/**
 * 用户_数据访问接口
 * @author TianCi.Xiong
 * @since 2020/10/20 21:11
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

}
