package com.tensquare.user.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 管理员_实体类
 * @author TianCi.Xiong
 * @since 2020/10/20 22:20
 */
@Entity
@Table(name = "tb_admin")
public class Admin implements Serializable {
    @Id
    private String id;//ID

    private String loginname;//登陆名称
    private String password;//密码
    private String state;//状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
