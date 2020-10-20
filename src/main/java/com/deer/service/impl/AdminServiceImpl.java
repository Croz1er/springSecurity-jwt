package com.deer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deer.config.security.SecurityUserFactory;
import com.deer.dao.AdminDao;
import com.deer.dao.RoleDao;
import com.deer.entity.Admin;
import com.deer.entity.Role;
import com.deer.service.AdminService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员表(Admin)表服务实现类
 *
 * @author lujy
 * @since 2020-10-16 11:11:49
 */
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {

    @Resource
    private AdminDao adminDao;
    @Resource
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminDao.selectOne(new QueryWrapper<Admin>().eq("user_name", username));
        if (admin == null) {
            throw new UsernameNotFoundException("该用户名不存在：" + username);
        }
        String roleUid = admin.getRoleUid();
        Role role = roleDao.selectOne(new QueryWrapper<Role>().eq("uid", roleUid));

        List<String> roleNames = new ArrayList<>();
        roleNames.add(role.getRoleName());

        admin.setRoleName(roleNames);

        return SecurityUserFactory.creat(admin);

    }
}
