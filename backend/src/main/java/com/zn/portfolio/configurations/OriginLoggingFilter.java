package com.zn.portfolio.configurations;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OriginLoggingFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String origin = request.getHeader("Origin");
        System.out.println("Request from origin: " + origin);
        if (origin == null) {
            origin = request.getHeader("Referer");
            System.out.println("referer: " + origin);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}