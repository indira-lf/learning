package com.feng.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author
 * @time 2022/11/9 13:52
 * @Description- 日期工具类
 */
public class DateFormatUtils {

    //日期格式
    public static final String HEAD_SEND_DATE_PATTERN = "yyyyMMdd";
    public static final String HEAD_SEND_TIME_PATTERN = "HHmmss";
    public static final String ISO_DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String ISO_DATE_PATTERN = "yyyy-MM-dd";
    public static final String ISO_TIME_PATTERN = "HH:mm:ss";
    public static final String ISO_NANO_TIME_PATTERN = "HH:mm:ss:SSS";
    public static final String DB_DATE_TIME_PATTERN = "yyyyMMddHHmmss";
    public static final String ISO_NANO_PATTERN = "yyyy-MM-dd HH:mm:ss:SSS";

    public static String getFormatDate(String pattern) {
        return getFormatDate(new Date(),pattern);
    }

    public static String getFormatDate(Date date, String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(date);
    }

    /**
     * pattern = yyyyMMdd
     */
    public static String getDate(){
        return getFormatDate(HEAD_SEND_DATE_PATTERN);
    }

    /**
     * 转换时间(yyyy-MM-dd) to (yyyyMMdd)格式
     */
    public static String getDateFormatSwitch(String date) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat(ISO_DATE_PATTERN);
        SimpleDateFormat format2 = new SimpleDateFormat(HEAD_SEND_DATE_PATTERN);
        Date parse = format1.parse(date);
        return format2.format(parse);
    }

    /**
     * 时间格式转换
     * @param sendDate 时间
     * @param beforeFormat 转换前格式
     * @param afterFormat 转换后格式
     * @return
     * @throws ParseException
     */
    public static String getDateFormatSwitch(String sendDate,String beforeFormat,String afterFormat) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat(beforeFormat);
        SimpleDateFormat format2 = new SimpleDateFormat(afterFormat);
        Date parse = format1.parse(sendDate);
        return format2.format(parse);
    }

    /**
     * 获取时间
     * @return
     */
    public static String getTime() {
        return getFormatDate(HEAD_SEND_TIME_PATTERN);
    }

    /**
     * pattern=yyyy-MM-dd'T'HH:mm:ss
     * @return
     */
    public static String getIsoDateTime() {
        return getFormatDate(ISO_DATE_TIME_PATTERN);
    }

    /**
     * 将Date对象转换为字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String getTime(Date date,String pattern){
        return getFormatDate(date,pattern);
    }

    /**
     *
     * @param date 时间
     * @param year +/- 年
     * @return
     */
    public static Date updateYear(String date,Integer year) throws ParseException {
        GregorianCalendar calendar = calendar(date);
        calendar.add(Calendar.DAY_OF_MONTH,year);
        return calendar.getTime();
    }

    /**
     *
     * @param date 时间
     * @param year +/- 年
     * @return
     */
    public static Date updateYear(Date date,Integer year) {
        GregorianCalendar calendar = calendar(date);
        calendar.add(Calendar.DAY_OF_MONTH,year);
        return calendar.getTime();
    }

    /**
     *
     * @param date 时间
     * @param month +/- 月
     * @return
     */
    public static Date updateMonth(String date,Integer month) throws ParseException {
        GregorianCalendar calendar = calendar(date);
        calendar.add(Calendar.MONTH,month);
        return calendar.getTime();
    }
    /**
     *
     * @param date 时间
     * @param month +/- 月
     * @return
     */
    public static Date updateMonth(Date date,Integer month) {
        GregorianCalendar calendar = calendar(date);
        calendar.add(Calendar.MONTH,month);
        return calendar.getTime();
    }

    /**
     *
     * @param date 时间
     * @param day +/- 日
     * @return
     */
    public static Date updateDay(String date,Integer day) throws ParseException {
        GregorianCalendar calendar = calendar(date);
        calendar.add(Calendar.DAY_OF_MONTH,day);
        return calendar.getTime();
    }
    /**
     *
     * @param date 时间
     * @param day +/- 日
     * @return
     */
    public static Date updateDay(Date date,Integer day) {
        GregorianCalendar calendar = calendar(date);
        calendar.add(Calendar.DAY_OF_MONTH,day);
        return calendar.getTime();
    }

    public static GregorianCalendar calendar(Date date){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }

    public static GregorianCalendar calendar(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(ISO_DATE_PATTERN+ISO_TIME_PATTERN);
        Date parse = format.parse(date);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(parse);
        return calendar;
    }

//    public static void main(String[] args) {
//        LocalDate startDate = LocalDate.of(2021, 3, 9);
//        LocalDate endDate = LocalDate.of(2021, 7, 8);
//        long between = ChronoUnit.DAYS.between(startDate, endDate);
//        long between1 = ChronoUnit.MONTHS.between(startDate, endDate);
//        System.out.println(between);
//        System.out.println(between1);
//    }

}
