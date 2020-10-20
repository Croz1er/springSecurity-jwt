package com.deer.config.security;

import com.deer.config.jwt.JwtAuthenticationEntryPoint;
import com.deer.config.jwt.JwtAuthorizationTokenFilter;
import com.deer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 13:24
 * <p>
 * security 的配置类
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtAuthenticationEntryPoint myAuthEntryPoint;

    @Resource
    private JwtAuthorizationTokenFilter myAuthTokenFilter;

    @Resource
    private AdminService adminService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println(123);
        auth.userDetailsService(adminService).passwordEncoder(new BCryptPasswordEncoder());
        System.out.println(321);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(myAuthEntryPoint);
        http.cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**","/index/**").permitAll()
                .anyRequest().authenticated()
                .and()
                //基于token 所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("http://localhost:9528/#/login")
                .loginProcessingUrl("/auth/login")
                .successHandler(new LoginSuccessHandel())
                .failureHandler(new LoginFailureHandel())
                .and()
                .rememberMe().rememberMeParameter("isRememberMe");
        http.headers().cacheControl();
        http.addFilterBefore(myAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**", "/elementuidemo/**",
//                "/img/**", "/js/**", "/plugins/**", "/static/json/**", "/pages/**");
//    }
}

