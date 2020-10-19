package com.deer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deer.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员表(Admin)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-16 11:11:48
 */

public interface AdminDao extends BaseMapper<Admin> {

}
