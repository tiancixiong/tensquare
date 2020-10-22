package com.tensquare.user.dao;

import com.tensquare.user.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户_数据访问接口
 * @author TianCi.Xiong
 * @since 2020/10/20 21:11
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    /**
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    public User findByMobile(String mobile);

    /**
     * 更新粉丝数
     * @param userid 用户ID
     * @param x      粉丝数
     */
    @Modifying
    @Query("update User u set u.fanscount=u.fanscount+?2 where u.id=?1")
    public void incFanscount(String userid, int x);

    /**
     * 更新关注数
     * @param userid 用户ID
     * @param x      粉丝数
     */
    @Modifying
    @Query("update User u set u.followcount=u.followcount+?2 where u.id=?1")
    public void incFollowcount(String userid, int x);

}
