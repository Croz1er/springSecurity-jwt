package com.deer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deer.dao.UserDao;
import com.deer.entity.Comment;
import com.deer.entity.User;
import com.deer.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户表(User)表服务实现类
 *
 * @author lujy
 * @since 2020-10-20 13:05:16
 */
@Service("userService")
@Transactional(readOnly = true)

public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Integer getUserTotal(Integer status) throws Exception {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>().eq("status", status);
        return userDao.selectCount(userQueryWrapper);
    }
}
