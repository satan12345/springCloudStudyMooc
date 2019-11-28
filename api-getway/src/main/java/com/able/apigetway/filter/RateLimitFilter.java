package com.able.apigetway.filter;

/**
 * @param
 * @author jipeng
 * @date 2019-11-27 17:48
 */

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * 限流拦截器
 */
public class RateLimitFilter extends ZuulFilter {

    private static final RateLimiter RATE_LIMITER=RateLimiter.create(100);
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return Boolean.TRUE;
    }

    @Override
    public Object run() throws ZuulException {
        if (!RATE_LIMITER.tryAcquire()) {
            throw new RuntimeException("");
        }
        return null;
    }
}

