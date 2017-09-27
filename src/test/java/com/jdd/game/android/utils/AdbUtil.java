package com.jdd.game.android.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdbUtil {
	public static final String ACTIVITY_FENXIANGQUAN = "com.jddfun.game/.act.ShareAct";
	
	public static void main(String[] args) {
		System.out.println(getConnectUdid());
	}
	
	public static void exeKeyboard0(){
		exeAdb("adb shell ime set io.appium.android.ime/.UnicodeIME");
	}
	
	public static void exeKeyboard1(){
		exeAdb("adb shell ime set com.baidu.input_huawei/.ImeService");
	}
	
	public static void exeKeyboard2(){
		exeAdb("adb shell ime set com.nuance.swype.emui/com.nuance.swype.input.HuaweiIME");
	}
	
	public static void clearApp(){
		exeAdb("adb shell pm clear com.jddfun.game");
	}
	
	/**
	 * linux: adb shell dumpsys activity | grep "mFocusedActivity"
	 * windows: adb shell dumpsys activity | findstr "mFocusedActivity"
	 * @param activity
	 */
	public static void openPage(String activity){
		exeAdb("adb shell am start -n " + activity);
	}
	
	private static void exeAdb(String command){
		String str[] ={"cmd", "/c", command};
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(str);
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(process != null){
				process.destroy();
			}
		}
	}
	
	/**
	 * 获取已连接设备UDID
	 * @return
	 */
	public static String getConnectUdid(){
		String str[] ={"cmd", "/c", "adb", "devices"};
		String result = "";
		Process process = null;
		BufferedReader bufferedReader = null;
		try {
			process = Runtime.getRuntime().exec(str);
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line=bufferedReader.readLine()) != null) {
				if(line.contains("device") && !line.contains("devices")){
					result += "," + line.replace("device", "").trim();
				}
			}
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bufferedReader != null){
					bufferedReader.close();
				}
				if(process != null){
					process.destroy();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result.startsWith(",") ? result.substring(1) : result;
	}

}
