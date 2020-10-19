package com.deer.utils.jwt;

import com.deer.common.security.SecurityUser;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 15:23
 */
@Component
public class JwtTokenUtil implements Serializable {

    /**
     * 密钥
     */
    private String secret = "123123";

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌协议
     */
    private String generateToken(Map<String, Object> claims) {
        //过期时间  七天
        Date expirationDate = new Date(System.currentTimeMillis() + 604800L * 1000);
//        生成一个jwt的工厂
//        JwtBuilder builder = Jwts.builder();
        return Jwts.builder().
                setClaims(claims).
                setExpiration(expirationDate).
                signWith(SignatureAlgorithm.HS512, secret).
                compact();
    }

    /**
     * 从token令牌中 获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
//            e.printStackTrace();
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     *
     * @param userDetails 用户详细信息
     * @return 令牌
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());

        claims.put("created", new Date());
        return generateToken(claims);
    }


    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUserNameFromToken(String token) {
        String username;

        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();;
        } catch (Exception e) {
            username = null;
        }

        return username;
    }

    /**
     * 验证令牌时候过期
     *
     * @param token 令牌
     * @return 是否过期 true 过期  false 未过期
     */
    public Boolean isTokenExpired(String token) {

        try {
            Claims claims = this.getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 旧令牌
     * @return 新令牌
     */
    public String refreshTokens(String token) {
        String newToken;

        try {
            Claims claims = this.getClaimsFromToken(token);
            //给数据声明中存入一个新的创建时间,再根据这个时间 生成一个新的令牌
            claims.put("created", new Date());
            newToken = this.generateToken(claims);
        } catch (Exception e) {
            newToken = null;
        }
        return newToken;
    }


    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userDetails 用户详细信息
     * @return 布尔
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        SecurityUser securityUser = (SecurityUser) userDetails;
        String userNameFromToken = this.getUserNameFromToken(token);
        return securityUser != null &&
                securityUser.getUsername().equals(userNameFromToken) &&
                !this.isTokenExpired(token);
    }


}
