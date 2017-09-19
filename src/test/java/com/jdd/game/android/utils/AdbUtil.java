package com.jdd.game.android.utils;

public class AdbUtil {
	public static final String ACTIVITY_FENXIANGQUAN = "com.jddfun.game/.act.ShareAct";
	
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

}
