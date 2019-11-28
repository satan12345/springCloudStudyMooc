package com.able.apigetway.filter;

import com.able.apigetway.constant.RedisConstant;
import com.able.apigetway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/** 权限拦截 区分买家与买家
 * @param
 * @author jipeng
 * @date 2019-11-25 21:52
 */
@Component
public class AuthFilter extends ZuulFilter {

   @Resource
    StringRedisTemplate stringRedisTemplate;

    /**
     * 过滤器的类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器顺序越小越靠前 优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return Boolean.TRUE;
    }

    @Override
    public Object run() throws ZuulException{
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if ("/order/order/create".equals(request.getRequestURI())) {
            Cookie cookie = CookieUtil.get(request, "openid");
            if (Objects.isNull(cookie)|| StringUtils.isEmpty(cookie.getValue())) {
                requestContext.setSendZuulResponse(Boolean.FALSE);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }

        }
        if ("/order/order/finish".equals(request.getRequestURI())) {
            Cookie cookie = CookieUtil.get(request, "token");
            if (Objects.isNull(cookie)|| StringUtils.isEmpty(cookie.getValue())||
            StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))) {

                requestContext.setSendZuulResponse(Boolean.FALSE);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }

        }

//        if (StringUtils.isEmpty(token)) {
//            requestContext.setSendZuulResponse(Boolean.FALSE);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }
        /**
         * /order/create  只能买家访问(cookie里有openid)
         * /order/finish 只能卖家访问(cookie里有token 并且对应的redis中的值)
         * /product/list 都可以访问
         */

        return null;
    }

}

