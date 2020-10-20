package com.deer.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表(User)表实体类
 *
 * @author lujy
 * @since 2020-10-20 13:05:17
 */
@Data
@SuppressWarnings("serial")
public class UserDTO implements Serializable {

    /**
     * 唯一uid
     */
    private String uid;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 性别(1:男2:女)
     */
    private Object gender;
    /**
     * 个人头像
     */
    private String avatar;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 出生年月日
     */
    private Date birthday;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 邮箱验证码
     */
    private String validCode;
    /**
     * 自我简介最多150字
     */
    private String summary;
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
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 资料来源
     */
    private String source;
    /**
     * 平台uuid
     */
    private String uuid;
    /**
     * QQ号
     */
    private String qqNumber;
    /**
     * 微信号
     */
    private String weChat;
    /**
     * 职业
     */
    private String occupation;
    /**
     * 评论状态 1:正常 0:禁言
     */
    private Integer commentStatus;
    /**
     * ip来源
     */
    private String ipSource;
    /**
     * 浏览器
     */
    private String browser;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 是否开启邮件通知 1:开启 0:关闭
     */
    private Integer startEmailNotification;
    /**
     * 用户标签：0：普通用户，1：管理员，2：博主 等
     */
    private Integer userTag;


}
