package com.deer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deer.entity.WebVisit;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Web访问记录表(WebVisit)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-20 14:52:25
 */
public interface WebVisitDao extends BaseMapper<WebVisit> {

    @Select("select count(ip) from " +
            "(" +
            "select ip from mogu_blog.t_web_visit " +
            "where create_time < #{nextDate} " +
            "and create_time >= #{date} " +
            ") as temp; ")
    Integer selectWebVisitPV(String date, String nextDate);

    @Select("select count(ip) from " +
            "(" +
            "select ip from mogu_blog.t_web_visit " +
            "where create_time < #{nextDate} " +
            "and create_time >= #{date} " +
            "group by ip) as temp; ")
    Integer selectWebVisitUV(String date, String nextDate);

}
