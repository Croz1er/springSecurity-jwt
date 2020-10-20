package com.deer.utils.other;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/20 14:57
 */
public class DateUtils {

    private  static SimpleDateFormat sdfFormat;


    public static String getNowStart(Date date) {
        sdfFormat = new SimpleDateFormat("yyyy-MM-dd");
        return sdfFormat.format(date);
    }

    public static String getNowTime(Date date){
        sdfFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdfFormat.format(date);
    }


    /**
     * @param dateFormat 日期格式
     * @param date 日期
     * @param intNum 偏移量  正数为⤴ ，负数为⤵
     * @return 日期
     */
    public static String dateShit(DateFormat dateFormat, Date date, int intNum){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,intNum);
        return dateFormat.format(calendar.getTime());
    }




}
