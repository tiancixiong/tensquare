package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 不喜欢列表_数据访问层
 * @author TianCi.Xiong
 * @since 2020/10/22 21:46
 */
public interface NoFriendDao extends JpaRepository<NoFriend, String> {
}
