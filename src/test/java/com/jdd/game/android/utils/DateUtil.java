package com.jdd.game.android.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 取得当前日期
	 * @return (yyyy年M月d日)
	 */
	public static String getCurrentDate() {
		return new SimpleDateFormat("yyyy年M月d日").format(new Date());
	}
	
	/**
	 * 满足下单选择日期时候，选择从当前日期加一天到加num天后日期之间的随机日期。
	 * @return (yyyy年M月d日)
	 */
	public static String getRandomDate(int num) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    calendar.add(Calendar.DATE, (int) (Math.random() * num) + 1);
		return new SimpleDateFormat("yyyy年M月d日").format(calendar.getTime());
	}
	
	/**
	 * 满足下单选择日期时候，选择从当前日期加num天后日期。
	 * @return (yyyy年M月d日)
	 */
	public static String getSpecifyDate(int num) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    calendar.add(Calendar.DATE, num);
		return new SimpleDateFormat("yyyy年M月d日").format(calendar.getTime());
	}
	
	public static String getSpecifyDate(int num,String dateFormat) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    calendar.add(Calendar.DATE, num);
		return new SimpleDateFormat(dateFormat).format(calendar.getTime());
	}
	
	public static String getSpecifyDate(String dateFormat, String dateStr) {
		Calendar calendar = Calendar.getInstance();
		if(!dateFormat.contains("yyyy")){
			dateFormat = "yyyy-" + dateFormat;
			dateStr = calendar.get(Calendar.YEAR) + "-" + dateStr;
		}
		try {
			calendar.setTime(new SimpleDateFormat(dateFormat).parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    if(calendar.getTimeInMillis() < System.currentTimeMillis()){
	    	calendar.add(Calendar.YEAR, 1);
	    }
		return new SimpleDateFormat("yyyy年M月d日").format(calendar.getTime());
	}
	
	/**
	 * 返回时间差
	 * @param t (时间差)
	 * @return (XX天XX小时XX分XX秒)
	 */
	public static String subTime(long l){
		long day = l / (24 * 60 * 60 * 1000);
		String dayStr = (day == 0) ? "" : day + "天";
		long hour = (l / (60 * 60 * 1000) - day * 24);
		String hourStr = (hour == 0) ? "" : hour + "小时";
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		String minStr = (min == 0) ? "" : min + "分";
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		String sStr = (s == 0) ? "<1秒" : s + "秒";
		return dayStr + hourStr + minStr + sStr;
	}
	
}
