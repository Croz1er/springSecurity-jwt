package com.deer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deer.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author lujy
 * @since 2020-10-20 13:05:16
 */
public interface UserService extends IService<User> {

    Integer getUserTotal(Integer status) throws Exception;

}
