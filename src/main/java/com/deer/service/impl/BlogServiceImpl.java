package com.deer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deer.dao.BlogDao;
import com.deer.entity.Blog;
import com.deer.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Blob;

/**
 * 博客表(Blog)表服务实现类
 *
 * @author lujy
 * @since 2020-10-20 13:01:55
 */
@Service("blogService")
@Transactional(readOnly = true)
public class BlogServiceImpl extends ServiceImpl<BlogDao, Blog> implements BlogService {

    @Resource
    private BlogDao blogDao;


    public Integer getBlogTotal(Integer status) throws Exception{
        QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>(new Blog()).eq("status", status).eq("is_publish", status);
        return blogDao.selectCount(blogQueryWrapper);
    }
}
