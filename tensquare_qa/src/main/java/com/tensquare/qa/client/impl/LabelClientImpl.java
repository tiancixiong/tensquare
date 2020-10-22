package com.tensquare.qa.client.impl;

import com.tensquare.qa.client.LabelClient;
import entity.Result;
import enums.ResultEnum;
import org.springframework.stereotype.Component;

/**
 * 熔断实现类
 * @author TianCi.Xiong
 * @since 2020/10/22 22:24
 */
@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findById(String id) {
        return new Result(false, ResultEnum.FAIL.getCode(), "熔断器启动了");
    }
}
