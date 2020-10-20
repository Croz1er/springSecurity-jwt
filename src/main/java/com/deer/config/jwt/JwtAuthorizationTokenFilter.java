package com.deer.config.jwt;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.deer.base.SysConf;
import com.deer.entity.Admin;
import com.deer.service.AdminService;
import com.deer.utils.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
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
    @Value(value = "${tokenHead}")
    private String tokenHead;

    @Value(value = "${tokenHeader}")
    private String tokenHeader;

    /**
     * token过期的时间
     */
    @Value(value = "${audience.expiresSecond}")
    private Long expiresSecond;

    /**
     * token刷新的时间
     */
    @Value(value = "${audience.refreshSecond}")
    private Long refreshSecond;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(tokenHeader);


        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            String authToken = authHeader.substring(tokenHead.length());

            String username = tokenUtil.getUserNameFromToken(authToken);


            Admin admin = adminService.getOne(new QueryWrapper<>(new Admin(), "uid").eq("user_name", username));

            String uid = admin.getUid();

            //把adminUid存储到request中
            request.setAttribute(SysConf.ADMIN_UID, uid);

            request.setAttribute(SysConf.USER_NAME, username);
            request.setAttribute(SysConf.TOKEN, authHeader);


            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.adminService.loadUserByUsername(username);
                //验证令牌时候有效
                Boolean aBoolean = tokenUtil.validateToken(authToken, userDetails);

                if (aBoolean) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails, null, userDetails.getAuthorities()
                            );
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }
        }

        chain.doFilter(request, response);
    }
}
