package com.deer.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Role)表实体类
 *
 * @author lujy
 * @since 2020-10-16 13:30:13
 */
@Data
@SuppressWarnings("serial")
public class RoleDTO implements Serializable {

    /**
     * 角色id
     */
    private String uid;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态
     */
    private Object status;
    /**
     * 角色介绍
     */
    private String summary;
    /**
     * 角色管辖的菜单的UID
     */
    private String categoryMenuUids;


}
