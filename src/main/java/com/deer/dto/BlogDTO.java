package com.deer.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客表(Blog)表实体类
 *
 * @author lujy
 * @since 2020-10-20 13:01:58
 */
@Data
@SuppressWarnings("serial")
public class BlogDTO implements Serializable {

    /**
     * 唯一uid
     */
    private String uid;
    /**
     * 博客标题
     */
    private String title;
    /**
     * 博客简介
     */
    private String summary;
    /**
     * 博客内容
     */
    private String content;
    /**
     * 标签uid
     */
    private String tagUid;
    /**
     * 博客点击数
     */
    private Integer clickCount;
    /**
     * 博客收藏数
     */
    private Integer collectCount;
    /**
     * 标题图片uid
     */
    private String fileUid;
    /**
     * 状态
     */
    private Object status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 管理员uid
     */
    private String adminUid;
    /**
     * 是否原创（0:不是 1：是）
     */
    private String isOriginal;
    /**
     * 作者
     */
    private String author;
    /**
     * 文章出处
     */
    private String articlesPart;
    /**
     * 博客分类UID
     */
    private String blogSortUid;
    /**
     * 推荐等级(0:正常)
     */
    private Integer level;
    /**
     * 是否发布：0：否，1：是
     */
    private String isPublish;
    /**
     * 排序字段
     */
    private Integer sort;
    /**
     * 是否开启评论(0:否 1:是)
     */
    private Integer openComment;


}
