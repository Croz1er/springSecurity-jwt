package com.deer.config.security;

import com.deer.common.security.SecurityUser;
import com.deer.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 13:55
 *
 * security的用户工厂类
 */
public class SecurityUserFactory {

    public SecurityUserFactory() {
    }

    /**
     * 通过admin 来创建一个securityUser的工厂类
     * @param admin 用户
     * @return securityUser
     */
    public static SecurityUser creat(Admin admin){
        final boolean enable = admin.getStatus() == 1;
        return new SecurityUser(admin.getUid(),admin.getUserName(),admin.getPassWord(),enable,getGrantedAuthority(admin));
    }

    /**
     * 通过admin的r角色名称 获取权限集合
     * @param admin 用户 管理员
     * @return 返回权限的集合
     */
    private static Collection<? extends GrantedAuthority> getGrantedAuthority(Admin admin) {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<String> roleNames = admin.getRoleName();
        roleNames.forEach((roleName)->{
            authorities.add(new SimpleGrantedAuthority("ROLE_"+roleName));
        });
        return authorities;
    }
}
