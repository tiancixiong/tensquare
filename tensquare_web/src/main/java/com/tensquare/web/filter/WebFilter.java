package com.tensquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul过滤器
 * @author TianCi.Xiong
 * @since 2020/10/22 22:47
 */
@Component
public class WebFilter extends ZuulFilter {

    /**
     * 定义过滤器类型
     * @return pre-可以在请求被路由之前调用
     * route-在路由请求时候被调用
     * post-在route和error过滤器之后被调用
     * error-处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        return "pre";// 前置过滤器
    }

    /**
     * 通过int值来定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;// 优先级为0，数字越大，优先级越低
    }

    /**
     * 判断该过滤器是否要执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("zuul过滤器...");
        //向header中添加鉴权令牌
        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取header
        HttpServletRequest request = requestContext.getRequest();
        String authorization = request.getHeader("Authorization");
        if (authorization != null) {
            requestContext.addZuulRequestHeader("Authorization", authorization);
        }
        return null;
    }
}
