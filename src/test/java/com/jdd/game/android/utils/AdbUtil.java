package com.jdd.game.android.utils;

public class AdbUtil {
	
	public void exeKeyboard0(){
		exeAdb("adb shell ime set io.appium.android.ime/.UnicodeIME");
	}
	
	public void exeKeyboard1(){
		exeAdb("adb shell ime set com.baidu.input_huawei/.ImeService");
	}
	
	public void exeKeyboard2(){
		exeAdb("adb shell ime set com.nuance.swype.emui/com.nuance.swype.input.HuaweiIME");
	}
	
	private void exeAdb(String command){
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
