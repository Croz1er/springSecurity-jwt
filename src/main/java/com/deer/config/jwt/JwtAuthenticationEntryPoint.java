package com.deer.config.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 15:01
 *
 * 没有凭证后  进入该方法
 *
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        System.out.println("JwtAuthenticationEntryPoint:"+authException.getMessage());

        //没有凭证后，往response里塞一些值
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"没有凭证");
    }
}
