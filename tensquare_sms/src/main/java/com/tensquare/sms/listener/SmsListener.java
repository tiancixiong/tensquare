package com.tensquare.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息监听类，发送短信
 * @author TianCi.Xiong
 * @since 2020/10/20 21:32
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {
    @Autowired
    private SmsUtil smsUtil;
    @Value("${aliyun.sms.template_code}")
    private String template_code;//模板编号
    @Value("${aliyun.sms.sign_name}")
    private String sign_name;//签名

    /**
     * 发送短信
     * @param map
     */
    @RabbitHandler
    public void sendSms(Map<String, String> map) {
        System.out.println("手机号：" + map.get("mobile"));
        System.out.println("验证码：" + map.get("code"));
        try {
            smsUtil.sendSms(map.get("mobile"), template_code, sign_name, "{\"number\":\"" + map.get("code") + "\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
