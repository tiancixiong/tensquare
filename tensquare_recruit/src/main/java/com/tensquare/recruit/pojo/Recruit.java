package com.tensquare.recruit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import helper.DateHelper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 职位实体类
 * @author TianCi.Xiong
 * @since 2020/10/14 14:26
 */
@Entity
@Table(name = "tb_recruit")
public class Recruit implements Serializable {
    @Id
    private String id;
    // 职位名称
    private String jobname;
    // 薪资范围
    private String salary;
    // 经验要求
    private String experience;
    // 学历要求
    private String education;
    // 任职方式
    private String type;
    // 办公地址
    private String address;
    // 企业ID
    private String eid;
    // 创建日期
    @DateTimeFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    @JsonFormat(pattern = DateHelper.yyyy_MM_dd_HH_mm_ss)
    private Date createtime;
    // 状态
    private String state;
    // 网址
    private String url;
    // 标签
    private String label;
    // 职位描述
    private String content1;
    // 职位要求
    private String content2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String condition) {
        this.experience = condition;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public java.util.Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label1) {
        this.label = label1;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

}
