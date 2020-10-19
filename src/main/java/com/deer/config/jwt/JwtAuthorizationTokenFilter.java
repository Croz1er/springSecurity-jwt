package com.deer.config.jwt;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deer.base.SysConf;
import com.deer.entity.Admin;
import com.deer.service.AdminService;
import com.deer.utils.jwt.JwtTokenUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 15:12
 */
@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    @Resource
    private AdminService adminService;
    @Resource
    private JwtTokenUtil tokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String tokenHeader = "token";
//        String authHeader = request.getHeader(tokenHeader);
        String authHeader = request.getParameter("token");
//        System.out.println("测试>>>===>>"+authHeader);
//        System.out.println("验证");
//        System.out.println("111"+authHeader);
        String tokenHead = "Bearer ";

        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            String authToken = authHeader.substring(tokenHead.length());
            System.out.println("authToken"+authToken);
            String username = tokenUtil.getUserNameFromToken(authToken);
            System.out.println("username"+username);

            Admin admin = adminService.getOne(new QueryWrapper<>(new Admin(), "uid").eq("user_name", username));
            System.out.println(admin);
            String uid = admin.getUid();

            //把adminUid存储到request中
            request.setAttribute(SysConf.ADMIN_UID,uid);
            request.setAttribute(SysConf.USER_NAME, username);
            request.setAttribute(SysConf.TOKEN, authHeader);





            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.adminService.loadUserByUsername(username);
                //验证令牌时候有效
                Boolean aBoolean = tokenUtil.validateToken(authToken, userDetails);
                System.out.println(aBoolean);
                if (aBoolean) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails, null, userDetails.getAuthorities()
                            );
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    System.out.println("最后");
                }
            }
        }
        chain.doFilter(request,response);
    }
}
