package cc.antx.utils.time;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 超详细的时间工具类
 *
 * @author zhong
 * @date 2023-02-03 13:39
 */
public class TimeUtils {

    /**
     * 获取格式化好的时间
     * 格式为: 2023-02-03 13:53:12
     *
     * @return 时间
     */
    public static String getNowFormatTime() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(now);
    }

    //===================================================================

    /**
     * 获取当天开始时间
     *
     * @return 当天开始时间
     */
    public static Date getDayBegin() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);//0点
        cal.set(Calendar.MINUTE, 0);//0分
        cal.set(Calendar.SECOND, 0);//0秒
        cal.set(Calendar.MILLISECOND, 0);//0毫秒
        return cal.getTime();
    }


    /**
     * 获取当天结束时间
     *
     * @return 当天结束时间
     */
    public static Date getDayEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);//23点
        cal.set(Calendar.MINUTE, 59);//59分
        cal.set(Calendar.SECOND, 59);//59秒
        return cal.getTime();
    }


    /**
     * 获取当前小时开始时间
     *
     * @return 当前小时开始时间
     */
    public static Date getHoursBegin() {
        Calendar cal = Calendar.getInstance();
        //  cal.set(Calendar.HOUR_OF_DAY, 0);//0点
        cal.set(Calendar.MINUTE, 0);//0分
        cal.set(Calendar.SECOND, 0);//0秒
        cal.set(Calendar.MILLISECOND, 0);//0毫秒
        return cal.getTime();
    }


    /**
     * 获取当前小时结束时间
     *
     * @return 当前小时结束时间
     */
    public static Date getHoursEnd() {
        Calendar cal = Calendar.getInstance();
        //  cal.set(Calendar.HOUR_OF_DAY, 23);//23点
        cal.set(Calendar.MINUTE, 59);//59分
        cal.set(Calendar.SECOND, 59);//59秒
        return cal.getTime();
    }


    /**
     * 获取昨天开始时间
     *
     * @return 昨天开始时间
     */
    public static Date getBeginDayOfYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayBegin());//当天开始时间
        cal.add(Calendar.DAY_OF_MONTH, -1);//当天月份天数减1
        return cal.getTime();
    }


    /**
     * 获取昨天结束时间
     *
     * @return 昨天结束时间
     */
    public static Date getEndDayOfYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayEnd());//当天结束时间
        cal.add(Calendar.DAY_OF_MONTH, -1);//当天月份天数减1
        return cal.getTime();
    }


    /**
     * 获取明天开始时间
     *
     * @return 明天开始时间
     */
    public static Date getBeginDayOfTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayBegin());//当天开始时间
        cal.add(Calendar.DAY_OF_MONTH, 1);//当天月份天数加1
        return cal.getTime();
    }


    /**
     * 获取明天结束时间
     *
     * @return 明天结束时间
     */
    public static Date getEndDayOfTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDayEnd());//当天结束时间
        cal.add(Calendar.DAY_OF_MONTH, 1);//当天月份天数加1
        return cal.getTime();
    }


    /**
     * 获取某个日期的开始时间
     *
     * @param d 日期
     * @return 某个日期的开始时间
     */
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 获取某个日期的结束时间
     *
     * @param d 日期
     * @return 某个日期的结束时间
     */
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 获取本周的开始时间
     *
     * @return 本周的开始时间
     */
    @SuppressWarnings("unused")
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            dayOfWeek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayOfWeek);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取本周的结束时间
     *
     * @return 本周的结束时间
     */
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }


    /**
     * 获取上周开始时间
     *
     * @return 上周开始时间
     */
    @SuppressWarnings("unused")
    public static Date getBeginDayOfLastWeek() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek - 7);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取上周的结束时间
     *
     * @return 上周的结束时间
     */
    public static Date getEndDayOfLastWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfLastWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }


    /**
     * 获取今年是哪一年
     *
     * @return 今年是哪一年
     */
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(Calendar.YEAR);
    }

    /**
     * 获取传入日期的年份数据
     *
     * @param date 日期
     * @return 传入日期的年份数据
     */
    public static Integer getNowYear(Date date) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(Calendar.YEAR);
    }


    /**
     * 获取本月是哪一月
     *
     * @return 本月是哪一月
     */
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(Calendar.MONTH) + 1;
    }

    /**
     * 根据传入的日期获取月份
     *
     * @param date 日期
     * @return 传入的日期获取月份
     */
    public static int getNowMonth(Date date) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(Calendar.MONTH) + 1;
    }


    /**
     * 获取本月的开始时间
     *
     * @return 本月的开始时间
     */
    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    /***
     * 获取当年指定月份的开始时间
     * @param month 月份
     * @return 当年指定月份的开始时间
     */
    public static Date getBeginDayOfMonth(int month) {
        int nowMonth = getNowMonth();
        month = nowMonth - month;
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1 - month, 1);
        return getDayStartTime(calendar.getTime());
    }

    /***
     * 获取指定年份指定月份的数据
     * @param date   指定年份的日期数据
     * @param month   月份
     * @return 指定年份指定月份的数据
     */
    public static Date getBeginDayOfMonth(Date date, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(date), month - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    /**
     * 获取指定年份指定月份的数据
     *
     * @param year  年份  int类型
     * @param month 月份
     * @return 指定年份指定月份的数据
     */
    public static Date getBeginDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    /**
     * 获取当年指定月份结束时间
     *
     * @return 当年指定月份结束时间
     */
    public static Date getEndDayOfMonth(int month) {
        int nowMonth = getNowMonth();
        month = nowMonth - month;
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1 - month, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 1 - month, day);
        return getDayEndTime(calendar.getTime());
    }

    /**
     * 获取指定年份指定月份的结束时间
     *
     * @param date  日期类型的时间--自动获取年份
     * @param month 月份
     * @return 指定年份指定月份的结束时间
     */
    public static Date getEndDayOfMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(date), month - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(date), month - 1, day);
        return getDayEndTime(calendar.getTime());
    }

    /**
     * 获取指定年份指定月份的结束时间
     *
     * @param year  年份
     * @param month 月份
     * @return 指定年份指定月份的结束时间
     */
    public static Date getEndDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(year, month - 1, day);
        return getDayEndTime(calendar.getTime());
    }

    /**
     * 获取本月的结束时间
     *
     * @return 本月的结束时间
     */
    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        int day = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(getNowYear(), getNowMonth() - 1, day);
        return getDayEndTime(calendar.getTime());
    }


    /**
     * 获取上月的开始时间
     *
     * @return 上月的开始时间
     */
    public static Date getBeginDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 2, 1);
        return getDayStartTime(calendar.getTime());
    }


    /**
     * 获取上月的结束时间
     *
     * @return 上月的结束时间
     */
    public static Date getEndDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 2, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 2, day);
        return getDayEndTime(calendar.getTime());
    }

    /**
     * 返回当前季度的开始时间
     *
     * @return 当前季度的开始时间
     */
    public static Date getCurrentQuarterDateBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int month = calendar.get(Calendar.MONTH);
        int quarter = month / 3 + 1;
        int startMonth = 1;
        if (quarter == 2) {
            startMonth = 4;
        } else if (quarter == 3) {
            startMonth = 7;
        } else if (quarter == 4) {
            startMonth = 10;
        }
        calendar.set(Calendar.MONTH, startMonth - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取指定季度的开始时间
     *
     * @param quarter 季度
     * @return 指定季度的开始时间
     */
    public static Date getCurrentQuarterDateBegin(int quarter) {
        Calendar calendar = Calendar.getInstance();
        int startMonth = 1;
        if (quarter == 2) {
            startMonth = 4;
        } else if (quarter == 3) {
            startMonth = 7;
        } else if (quarter == 4) {
            startMonth = 10;
        }
        calendar.set(Calendar.MONTH, startMonth - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return getDayStartTime(calendar.getTime());
    }

    /**
     * 获取指定季度的结束时间
     *
     * @param quarter 季度
     * @return 指定季度的结束时间
     */
    public static Date getCurrentQuarterDateEnd(int quarter) {
        Calendar calendar = Calendar.getInstance();
        int endMonth = 3;
        if (quarter == 2) {
            endMonth = 6;
        } else if (quarter == 3) {
            endMonth = 9;
        } else if (quarter == 4) {
            endMonth = 12;
        }
        calendar.set(Calendar.MONTH, endMonth - 1);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        return getDayEndTime(calendar.getTime());
    }

    /**
     * 返回当前季度结束时间
     *
     * @return 当前季度结束时间
     */
    public static Date getCurrentQuarterDateEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int month = calendar.get(Calendar.MONTH);
        int quarter = month / 3 + 1;
        int endMonth = 3;
        if (quarter == 2) {
            endMonth = 6;
        } else if (quarter == 3) {
            endMonth = 9;
        } else if (quarter == 4) {
            endMonth = 12;
        }
        calendar.set(Calendar.MONTH, endMonth - 1);
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, lastDay);
        return calendar.getTime();
    }


    /**
     * 获取本年的开始时间
     *
     * @return 本年的开始时间
     */
    public static Date getBeginDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取本年的结束时间
     *
     * @return 本年的结束时间
     */
    public static Date getEndDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return getDayEndTime(cal.getTime());
    }


    /**
     * 获取两个日期相减得到的天数
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 两个日期相减得到的天数
     */
    public static int getDiffDays(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null) {
            throw new IllegalArgumentException("getDiffDays param is null!");
        }
        long diff = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);
        return (int) diff;
    }


    /**
     * 获取两个日期相减得到的毫秒数
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 两个日期相减得到的毫秒数
     */
    public static long dateDiff(Date beginDate, Date endDate) {
        long date1ms = beginDate.getTime();
        long date2ms = endDate.getTime();
        return date2ms - date1ms;
    }


    /**
     * 获取两个日期中的最大日期
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 两个日期中的最大日起
     */
    public static Date max(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return beginDate;
        }
        return endDate;
    }


    /**
     * 获取两个日期中的最小日期
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 两个日期中的最小日期
     */
    public static Date min(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return endDate;
        }
        if (endDate == null) {
            return beginDate;
        }
        if (beginDate.after(endDate)) {
            return endDate;
        }
        return beginDate;
    }


    /**
     * 获取某月该季度的第一个月
     *
     * @param date 季度
     * @return 某月该季度的第一个月
     */
    public static Date getFirstSeasonDate(Date date) {
        final int[] SEASON = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int sean = SEASON[cal.get(Calendar.MONTH)];
        cal.set(Calendar.MONTH, sean * 3 - 3);
        return cal.getTime();
    }


    /**
     * 返回某个日期下几天的日期
     *
     * @param date 日期
     * @param i    下几天天数
     * @return 某个日期下几天的日期
     */
    public static Date getNextDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
        return cal.getTime();
    }


    /**
     * 返回某个日期前几天的日期
     *
     * @param date 日期
     * @param i    前几天的天数
     * @return 某个日期前几天的日期
     */
    public static Date getFrontDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
        return cal.getTime();
    }


    /**
     * 获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）
     *
     * @param beginYear  年份
     * @param beginMonth 月份
     * @param k          天数
     * @return 某年某月按天切片日期集合
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static List getTimeList(int beginYear, int beginMonth, int k) {
        List list = new ArrayList();
        Calendar begincal = new GregorianCalendar(beginYear, beginMonth, 1);
        int max = begincal.getActualMaximum(Calendar.DATE);
        for (int i = 1; i < max; i = i + k) {
            list.add(begincal.getTime());
            begincal.add(Calendar.DATE, k);
        }
        begincal = new GregorianCalendar(beginYear, beginMonth, max);
        list.add(begincal.getTime());
        return list;
    }


    /**
     * 获取某年某月到某年某月按天的切片日期集合（间隔天数的集合）
     *
     * @param beginYear  开始年份
     * @param beginMonth 开始月份
     * @param endYear    结束年份
     * @param endMonth   结束月份
     * @param k          天数
     * @return 某年某月到某年某月按天的切片日期集合
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static List getTimeList(int beginYear, int beginMonth, int endYear, int endMonth, int k) {
        List list = new ArrayList();
        if (beginYear == endYear) {
            for (int j = beginMonth; j <= endMonth; j++) {
                list.add(getTimeList(beginYear, j, k));
            }
        } else {
            {
                for (int j = beginMonth; j < 12; j++) {
                    list.add(getTimeList(beginYear, j, k));
                }
                for (int i = beginYear + 1; i < endYear; i++) {
                    for (int j = 0; j < 12; j++) {
                        list.add(getTimeList(i, j, k));
                    }
                }
                for (int j = 0; j <= endMonth; j++) {
                    list.add(getTimeList(endYear, j, k));
                }
            }
        }
        return list;
    }


    //=================================时间格式转换==========================

    /**
     * date类型进行格式化输出（返回类型：String）
     * 格式:  2023-02-03 13:53:12
     *
     * @param date 日期
     * @return date的String类型
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }


    /**
     * 将"2023-02-03 13:53:12"型字符串转化为Date
     *
     * @param s 字符串
     * @return 字符串日期的Date类型
     */
    public static Date StringToDate(String s) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return formatter.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 将"2015-08"型字符串转化为Date
     *
     * @param s 字符串
     * @return 字符串日期的Date类型
     */
    public static Date StringToDateYearAndMonth(String s) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            return formatter.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将CST时间类型字符串进行格式化输出
     *
     * @param s 字符串
     * @return 格式化时间
     */
    public static String CSTFormat(String s) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            Date date = formatter.parse(s);
            return dateFormat(date);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 将long类型转化为Date
     *
     * @param s 字符串
     * @return Date类型
     */
    public static Date LongToDare(long s) {
        return new Date(s * 1000);
    }


    //====================================其他常见日期操作方法======================

    /**
     * 判断当前日期是否在[startDate, endDate]区间
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 当前世界是否在指定区间
     */
    public static boolean isEffectiveDate(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return false;
        }
        long currentTime = new Date().getTime();
        return currentTime >= startDate.getTime()
                && currentTime <= endDate.getTime();
    }


    /**
     * 得到二个日期间的间隔天数
     *
     * @param secondString：后一个日期
     * @param firstString：前一个日期
     * @return 间隔天数
     */
    public static String getTwoDay(String secondString, String firstString) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            Date secondTime = myFormatter.parse(secondString);
            Date firstTime = myFormatter.parse(firstString);
            day = (secondTime.getTime() - firstTime.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return "";
        }
        return day + "";
    }


    /**
     * 时间前推或后推分钟,其中JJ表示分钟.
     *
     * @param StringTime：时间
     * @param minute：分钟（有正负之分）
     * @return 时间推前或推后的时间
     */
    public static String getPreTime(String StringTime, String minute) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate1;
        try {
            Date date1 = format.parse(StringTime);
            long Time = (date1.getTime() / 1000) + Integer.parseInt(minute) * 60L;
            date1.setTime(Time * 1000);
            mydate1 = format.format(date1);
        } catch (Exception e) {
            return "";
        }
        return mydate1;
    }


    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param s 字符串
     * @return Date类型时间
     */
    public static Date strToDate(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(s, pos);
    }


    /**
     * 得到一个时间延后或前移几天的时间
     *
     * @param nowDate：时间
     * @param delay：前移或后延的天数
     * @return 延后或前移几天的时间
     */
    public static String getNextDay(String nowDate, String delay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String mdate;
            Date d = strToDate(nowDate);
            long myTime = (d.getTime() / 1000) + (long) Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = format.format(d);
            return mdate;
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 判断是否闰年
     * 详细设计：
     * 1.被400整除是闰年，否则：
     * 2.不能被4整除则不是闰年
     * 3.能被4整除同时不能被100整除则是闰年
     * 3.能被4整除同时能被100整除则不是闰年
     *
     * @param date 时间
     * @return 是否为闰年
     */
    public static boolean isLeapYear(String date) {
        Date d = strToDate(date);
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(d);
        int year = gc.get(Calendar.YEAR);
        if ((year % 400) == 0) {
            return true;
        } else if ((year % 4) == 0) {
            return (year % 100) != 0;
        } else {
            return false;
        }
    }


    /**
     * 返回美国时间格式
     *
     * @param s 字符串
     * @return 美国时间格式
     */
    public static String getEDate(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(s, pos);
        String j = strtodate.toString();
        String[] k = j.split(" ");
        return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
    }


    /**
     * 判断二个时间是否在同一个周
     *
     * @param date1 第一个时间
     * @param date2 第二个时间
     * @return 二个时间是否在同一个周
     */
    public static boolean isSameWeekDates(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if (0 == subYear) {
            return cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR);
        } else if (1 == subYear && Calendar.DECEMBER == cal2.get(Calendar.MONTH)) {
            return cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR);
        } else if (-1 == subYear && Calendar.DECEMBER == cal1.get(Calendar.MONTH)) {
            return cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR);
        }
        return false;
    }


    /**
     * 产生周序列,即得到当前时间所在的年度是第几周
     *
     * @return 当前时间所在的年度是第几周
     */
    public static String getSeqWeek() {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
        if (week.length() == 1)
            week = "0" + week;
        String year = Integer.toString(c.get(Calendar.YEAR));
        return year + "年第" + week + "周";
    }


    /**
     * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
     *
     * @param s：日期
     * @param num：星期几（星期天是一周的第一天）
     * @return 几号
     */
    public static String getWeek(String s, String num) {
        // 再转换为时间
        Date dd = strToDate(s);
        Calendar c = Calendar.getInstance();
        c.setTime(dd);
        switch (num) {
            case "1" ->
                // 返回星期一所在的日期
                    c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            case "2" ->
                // 返回星期二所在的日期
                    c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            case "3" ->
                // 返回星期三所在的日期
                    c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            case "4" ->
                // 返回星期四所在的日期
                    c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            case "5" ->
                // 返回星期五所在的日期
                    c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            case "6" ->
                // 返回星期六所在的日期
                    c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
            case "0" ->
                // 返回星期日所在的日期
                    c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }


    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param s 字符串
     * @return 星期几
     */
    public static String getWeek(String s) {
        // 再转换为时间
        Date date = strToDate(s);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }


    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param s 字符串
     * @return 星期几
     */
    public static String getWeekStr(String s) {
        String str;
        str = getWeek(s);
        str = switch (str) {
            case "1" -> "星期日";
            case "2" -> "星期一";
            case "3" -> "星期二";
            case "4" -> "星期三";
            case "5" -> "星期四";
            case "6" -> "星期五";
            case "7" -> "星期六";
            default -> str;
        };
        return str;
    }


    /**
     * 两个时间之间的天数
     *
     * @param date1 第一个时间
     * @param date2 第二个时间
     * @return 之间的天数
     */
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals(""))
            return 0;
        if (date2 == null || date2.equals(""))
            return 0;
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception ignored) {
        }
        assert date != null;
        assert mydate != null;
        return (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
    }


    /**
     * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
     * 此函数返回该日历第一行星期日所在的日期
     *
     * @param s 字符串
     * @return 日历
     */
    public static String getNowMonth(String s) {
        // 取该时间所在月的一号
        s = s.substring(0, 8) + "01";
        // 得到这个月的1号是星期几
        Date date = strToDate(s);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int u = c.get(Calendar.DAY_OF_WEEK);
        return getNextDay(s, (1 - u) + "");
    }


    /**
     * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写
     *
     * @param sFormat 格式化格式字符串
     * @return 时间
     */
    public static String getUserDate(String sFormat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(sFormat);
        return formatter.format(currentTime);
    }


    /**
     * 返回一个i位数的随机数
     *
     * @param i 位数
     * @return 随机数
     */
    public static String getRandom(int i) {
        Random jjj = new Random();
        // int suiJiShu = jjj.nextInt(9);
        if (i == 0)
            return "";
        StringBuilder jj = new StringBuilder();
        for (int k = 0; k < i; k++) {
            jj.append(jjj.nextInt(9));
        }
        return jj.toString();
    }


    /**
     * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
     *
     * @param k：表示是取几位随机数，可以自己定
     * @return 随机数
     */
    public static String getNo(int k) {
        return getUserDate("yyyyMMddhhmmss") + getRandom(k);
    }
}