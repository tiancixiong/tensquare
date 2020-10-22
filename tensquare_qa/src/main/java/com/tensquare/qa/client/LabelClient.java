package com.tensquare.qa.client;

import com.tensquare.qa.client.impl.LabelClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 问答客户端
 * @author TianCi.Xiong
 * @since 2020/10/22 19:49
 */
@FeignClient(name = "tensquare-base", fallback = LabelClientImpl.class)
public interface LabelClient {
    @RequestMapping(value = "/label/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id);
}
