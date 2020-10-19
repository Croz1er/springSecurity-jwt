package com.deer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Role)表实体类
 *
 * @author makejava
 * @since 2020-10-16 13:30:13
 */
@Data
@TableName("t_role")
@SuppressWarnings("serial")
public class Role extends Model<Role> {
    @TableId(type = IdType.AUTO)
    /**角色id*/
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
