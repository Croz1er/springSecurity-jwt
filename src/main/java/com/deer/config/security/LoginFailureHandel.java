package com.deer.config.security;

import com.deer.base.Result;
import com.deer.common.security.SecurityUser;
import com.deer.utils.enums.ResultCode;
import com.deer.utils.jwt.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 16:04
 */
@Component
public class LoginFailureHandel extends SimpleUrlAuthenticationFailureHandler {



    @Override
    public void onAuthenticationFailure(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        AuthenticationException exception) throws ServletException, IOException {
        System.out.println("登录失败");
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString
                (new Result(ResultCode.USER_NOT_LOGIN,null));
        out.write(value);
        out.flush();
        out.close();
    }
}
