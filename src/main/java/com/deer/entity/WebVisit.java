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
 * Web访问记录表(WebVisit)表实体类
 *
 * @author makejava
 * @since 2020-10-20 14:52:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_web_visit")
@SuppressWarnings("serial")
public class WebVisit extends Model<WebVisit> {

    /**主键*/
    @TableId(type = IdType.AUTO)
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
