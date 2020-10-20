package com.deer.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 游客表(Visitor)表实体类
 *
 * @author lujy
 * @since 2020-10-20 13:05:34
 */
@Data
@SuppressWarnings("serial")
public class VisitorDTO implements Serializable {

    /**
     * 唯一uid
     */
    private String uid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 登录次数
     */
    private Integer loginCount;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 最后登录IP
     */
    private String lastLoginIp;
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


}
