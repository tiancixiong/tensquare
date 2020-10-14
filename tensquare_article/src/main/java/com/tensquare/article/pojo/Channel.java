package com.tensquare.article.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 频道_实体类
 * @author TianCi.Xiong
 * @since 2020/10/14 18:45
 */
@Entity
@Table(name = "tb_channel")
public class Channel implements Serializable {
    @Id
    private String id;
    // 频道名称
    private String name;
    // 状态
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
