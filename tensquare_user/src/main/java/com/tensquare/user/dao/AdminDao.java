package com.tensquare.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.user.pojo.Admin;

/**
 * 管理员_数据访问接口
 * @author TianCi.Xiong
 * @since 2020/10/20 22:20
 */
public interface AdminDao extends JpaRepository<Admin, String>, JpaSpecificationExecutor<Admin> {
    public Admin findByLoginname(String loginname);
}
