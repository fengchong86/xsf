package com.xsf.app.filter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RateLimitHandler implements HandlerInterceptor {

    private final RateLimiter rateLimiter = RateLimiter.create(50.0);

    private static final boolean TRANSFINITE_BREAK = true;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(rateLimiter.tryAcquire()){
            rateLimiter.acquire();
            return true;
        }else{
            response.setStatus(HttpStatus.NOT_FOUND.value());

            return false;
        }

    }
}
