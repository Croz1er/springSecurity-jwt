package com.deer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论表(Comment)表实体类
 *
 * @author lujy
 * @since 2020-10-20 13:04:09
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("serial")
@TableName("t_comment")
public class Comment extends Model<Comment> {
    @TableId(type = IdType.AUTO)
    /**唯一uid*/
    private String uid;
    /**
     * 用户uid
     */
    private String userUid;
    /**
     * 回复某条评论的uid
     */
    private String toUid;
    /**
     * 回复某个人的uid
     */
    private String toUserUid;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 博客uid
     */
    private String blogUid;
    /**
     * 状态
     */
    private Object status;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 评论来源： MESSAGE_BOARD，ABOUT，BLOG_INFO 等
     */
    private String source;
    /**
     * 评论类型 1:点赞 0:评论
     */
    private Integer type;
    /**
     * 一级评论UID
     */
    private String firstCommentUid;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.uid;
    }
}
