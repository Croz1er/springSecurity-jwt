package com.deer.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Web访问记录表(WebVisit)表实体类
 *
 * @author makejava
 * @since 2020-10-20 14:52:25
 */
@Data
@SuppressWarnings("serial")
public class WebVisitDTO implements Serializable {

    /**
     * 主键
     */
    private String uid;
    /**
     * 用户uid
     */
    private String userUid;
    /**
     * 访问ip地址
     */
    private String ip;
    /**
     * 用户行为
     */
    private String behavior;
    /**
     * 模块uid（文章uid，标签uid，分类uid）
     */
    private String moduleUid;
    /**
     * 附加数据(比如搜索内容)
     */
    private String otherData;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 浏览器
     */
    private String browser;
    /**
     * ip来源
     */
    private String ipSource;


}
