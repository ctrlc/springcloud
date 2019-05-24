package com.sa.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul 的核心功能：请求过滤
 * 只需要继承 ZuulFilter 并实现它的4个方法就可以对请求拦截和过滤
 * <p>
 *     创建完成过滤器后，并不会直接生效，需要为其创建具体的Bean才能启动该过滤器
 *     比如：在主类ApiZuulApplication 创建Bean
 * </p>
 */
public class AccessFilter extends ZuulFilter {
    private final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * filterType: 过滤器的类型，它决定过滤的请求在哪个生命周期中执行
     * 这里定义为 pre, 代表会在请求在被路由之前执行
     * @return pre
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder: 过滤器的执行顺序
     * 当请求在一个阶段中存在多个过滤器时，需要根据方法的返回值来依次执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter: 判断过滤器是否需要被执行
     * true: 对所有请求都会生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run: 过滤器的具体逻辑
     * <p>
     *     eg:
     *     ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由
     *     ctx.setResponseStatus-Code(401)设置其返回的错误码
     *     ...
     * </p>
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("send: {} request to {}",request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null){
            logger.warn("accessToken 为空");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return "access token is empty";
        }
        logger.info("access token ok");
        return null;
    }
}
