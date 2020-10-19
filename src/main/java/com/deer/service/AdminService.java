package com.deer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deer.entity.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * 管理员表(Admin)表服务接口
 *
 * @author makejava
 * @since 2020-10-16 11:11:49
 */
public interface AdminService extends IService<Admin> , UserDetailsService {

}
