package com.deer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deer.dao.CommentDao;
import com.deer.entity.Comment;
import com.deer.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author lujy
 * @since 2020-10-20 13:04:09
 */
@Service("commentService")
@Transactional(readOnly = true)

public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Override
    public Integer getCommentTotal(Integer status) throws Exception {
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<Comment>().eq("status", status);
        return commentDao.selectCount(commentQueryWrapper);
    }
}
