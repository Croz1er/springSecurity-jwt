package com.deer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deer.entity.Blog;

/**
 * 博客表(Blog)表服务接口
 *
 * @author lujy
 * @since 2020-10-20 13:01:55
 */
public interface BlogService extends IService<Blog> {

    Integer getBlogTotal(Integer status) throws Exception;
}
