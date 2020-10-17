package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 吐槽_数据访问层
 * @author TianCi.Xiong
 * @since 2020/10/17 21:33
 */
public interface SpitDao extends MongoRepository<Spit, String> {
}
