package com.deer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deer.dao.WebVisitDao;
import com.deer.entity.WebVisit;
import com.deer.service.WebVisitService;
import com.deer.utils.other.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Web访问记录表(WebVisit)表服务实现类
 *
 * @author makejava
 * @since 2020-10-20 14:52:25
 */
@Service("webVisitService")
public class WebVisitServiceImpl extends ServiceImpl<WebVisitDao, WebVisit> implements WebVisitService {

    @Resource
    private WebVisitDao webVisitDao;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Integer getWebVisitorTotal() {
        QueryWrapper<WebVisit> webVisitQueryWrapper = new QueryWrapper<>(new WebVisit(), "ip")
                .gt("create_time", DateUtils.getNowStart(new Date()))
                .lt("create_time", DateUtils.getNowTime(new Date())).groupBy("ip");
        List<WebVisit> visits = webVisitDao.selectList(webVisitQueryWrapper);
        System.out.println(visits);
        System.out.println(visits.size());
        return visits.size();
    }


    /**
     * 获取当前时间的前一周的集合
     *
     * @return 时间结集合
     */
    @Override
    public List<String> getWebVisWeek() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<>();
        for (int i = 6; i >= 0; i--) {
            String shitTime = DateUtils.dateShit(dateFormat, date, -i);
            list.add(shitTime);
        }
        return list;
    }

    /**
     * 即页面浏览量或点击量，用户每1次对网站中的每个网页访问均被记录1个PV。
     * 用户对同一页面的多次访问，访问量累计，用以衡量网站用户访问的网页数量。
     *
     * @return 当前时间段内 所有IP（重复）
     */
    @Override
    public List<String> getWebVisPV() throws Exception {

        List<String> webVisWeek = this.getWebVisWeek();
        List<String> webVisPV = new ArrayList<>();
        webVisWeek.forEach((week) -> {
            try {


                Integer integer = this.selectWebVisitPV(week, DateUtils.dateShit(dateFormat,dateFormat.parse(week), 1));
                webVisPV.add(integer.toString());


            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        return webVisPV;
    }

    /**
     * 是指通过互联网访问、浏览这个网页的自然人。访问您网站的一台电脑客户端为一个访客。00:00-24:00内相同的客户端只被计算一次。
     * 一天内同个访客多次访问仅计算一个UV。
     *
     * @return 当天的时间段内  访问了 多少个ip
     */
    @Override
    public List<String> getWebVisUV() {
        List<String> webVisWeek = this.getWebVisWeek();
        List<String> webVisUV = new ArrayList<>();
        webVisWeek.forEach((week) -> {
            try {
                Integer integer = this.selectWebVisitUV(week, DateUtils.dateShit(dateFormat,dateFormat.parse(week), 1));
                webVisUV.add(integer.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        return webVisUV;
    }


    @Override
    public Integer selectWebVisitPV(String date, String nextDate) {
        return webVisitDao.selectWebVisitPV(date, nextDate);
    }

    @Override
    public Integer selectWebVisitUV(String date, String nextDate) {
        return webVisitDao.selectWebVisitUV(date, nextDate);
    }
}
