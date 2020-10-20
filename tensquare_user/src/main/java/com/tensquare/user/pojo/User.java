package com.tensquare.user.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import helper.DateHelper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户_实体类
 * @author TianCi.Xiong
 * @since 2020/10/20 21:10
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    @Id
    private String id;//ID

    private String loginname;//登录名
    private String password;//密码
    private String nickname;//昵称
    private String sex;//性别
    // 出生年月日
    @DateTimeFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    @JsonFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    private Date birthday;
    private String avatar;//头像
    private String mobile;//电话号码
    private String email;//E-Mail
    // 注册日期
    @DateTimeFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    @JsonFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    private Date regdate;
    // 修改日期
    @DateTimeFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    @JsonFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    private Date updatedate;
    // 最后登陆日期
    @DateTimeFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    @JsonFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    private Date lastdate;
    private Long online;//在线时长（分钟）
    private String interest;//兴趣
    private String personality;//个性
    private Integer fanscount;//粉丝数
    private Integer followcount;//关注数

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.util.Date getRegdate() {
        return regdate;
    }

    public void setRegdate(java.util.Date regdate) {
        this.regdate = regdate;
    }

    public java.util.Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(java.util.Date updatedate) {
        this.updatedate = updatedate;
    }

    public java.util.Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(java.util.Date lastdate) {
        this.lastdate = lastdate;
    }

    public Long getOnline() {
        return online;
    }

    public void setOnline(Long online) {
        this.online = online;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public Integer getFanscount() {
        return fanscount;
    }

    public void setFanscount(Integer fanscount) {
        this.fanscount = fanscount;
    }

    public Integer getFollowcount() {
        return followcount;
    }

    public void setFollowcount(Integer followcount) {
        this.followcount = followcount;
    }
}
