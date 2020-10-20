package com.deer.config.security;

import com.deer.base.Result;
import com.deer.base.SysConf;
import com.deer.common.security.SecurityUser;
import com.deer.utils.enums.ResultCode;
import com.deer.utils.jwt.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 16:04
 */
@Component
public class LoginSuccessHandel extends SavedRequestAwareAuthenticationSuccessHandler {

    @Value(value = "${tokenHead}")
    private String tokenHead;



    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        Authentication auth) throws ServletException, IOException {
        System.out.println("登录成功");
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        SecurityUser securityUser = (SecurityUser) auth.getPrincipal();

        String token = jwtTokenUtil.generateToken(securityUser);

        String userName = jwtTokenUtil.getUserNameFromToken(token);

        String bToken = "Bearer " + token;

        resp.addHeader(SysConf.TOKEN, bToken);

        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<>();
        map.put("token",bToken);
        String value = objectMapper.writeValueAsString(new Result(ResultCode.SUCCESS, map));
        out.write(value);
        out.flush();
        out.close();
    }

}
