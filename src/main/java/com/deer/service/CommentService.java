package com.deer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deer.entity.Comment;

/**
 * 评论表(Comment)表服务接口
 *
 * @author lujy
 * @since 2020-10-20 13:04:09
 */
public interface CommentService extends IService<Comment> {

    Integer getCommentTotal(Integer status) throws Exception;

}
