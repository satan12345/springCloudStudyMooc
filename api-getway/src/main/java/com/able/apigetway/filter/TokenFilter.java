package com.able.apigetway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @param
 * @author jipeng
 * @date 2019-11-25 21:52
 */
@Component
public class TokenFilter extends ZuulFilter {
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
//        RequestContext requestContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = requestContext.getRequest();
//        String token = request.getParameter("token");
//        if (StringUtils.isEmpty(token)) {
//            requestContext.setSendZuulResponse(Boolean.FALSE);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }


        return null;
    }

}

