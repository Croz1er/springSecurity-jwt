package com.deer.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员表(Admin)表实体类
 *
 * @author makejava
 * @since 2020-10-16 11:11:51
 */
@Data
@SuppressWarnings("serial")
public class AdminDTO implements Serializable {

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
    private String gender;
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
     * github地址
     */
    private String github;
    /**
     * gitee地址
     */
    private String gitee;
    /**
     * 拥有的角色uid
     */
    private String roleUid;
    /**
     * 履历
     */
    private String personResume;


}
