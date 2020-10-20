package com.deer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deer.dao.RoleDao;
import com.deer.entity.Role;
import com.deer.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Role)表服务实现类
 *
 * @author lujy
 * @since 2020-10-16 13:30:13
 */
@Service
@Transactional(readOnly = true)

public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

}
