package com.deer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.deer.entity.WebVisit;

import java.util.List;

/**
 * Web访问记录表(WebVisit)表服务接口
 *
 * @author makejava
 * @since 2020-10-20 14:52:25
 */
public interface WebVisitService extends IService<WebVisit> {

    Integer getWebVisitorTotal();

    List<String> getWebVisWeek();

    List<String> getWebVisPV() throws Exception;

    List<String> getWebVisUV();

    Integer selectWebVisitPV(String date,String nextDate);

    Integer selectWebVisitUV(String date,String nextDate);

}
