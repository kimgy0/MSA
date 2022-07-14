package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * API GATEWAY에서는 사전/사후 처리에 대한 개념이 장점이라고 말한다.
 *즉,사전 처리의 예로써는 인증서비스,사후는 로깅 서비스 등이 있다.
 */
@Component
@Slf4j
public class ZuulLogingFilter extends ZuulFilter {

    /**
     *어떤 동작을 할 건지 필요한 내용은 정의한다.
     */
    @Override
    public String filterType() {
/**
 * pre는 사전, post는 사후.
 */
        return "pre";
    }
    /**
     * 필터의 순서인데 우리는 하나만 정의했기 때문에 1
     */
    @Override
    public int filterOrder() {
        return 1;
    }


    /**
     *
     * 필터를 사용할건지 말건지 true/false 로 정의
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *어떤 동작을 할 건지 필요한 내용은 정의한다.
     */
    @Override
    public Object run() throws ZuulException {
        log.info("************************* printing logs : ");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("************************* " + request.getRequestURI());
        return null;
    }
}

