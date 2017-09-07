package com.jdd.game.android.suites;

import com.jdd.game.android.driver.AppDriver;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.pages.CaiDanPage;
import com.jdd.pages.DengLuPage;

public abstract class AbsParentTest extends AppDriver{
	
	protected IDriverExe startTest(String testName, String caseName, boolean login) {
		return startTest(testName, caseName, login, null, null);
	}
			
	protected IDriverExe startTest(String testName, String caseName, boolean login, String username, String password) {
		IDriverExe driverExe = runAndroidDriverExe();
		driverExe.waitPageLoad(1);
		driverExe.log("测试输出:《" + testName + " -【" + caseName + "】》测试开始!");
		if(login){
			if(isEmpty(username) || isEmpty(password)){
				shiWan();
			}else{
				login(username, password);
			}
		}
		return driverExe;
	}
	
	protected void endTest(String testName, String caseName) {
		IDriverExe driverExe = getAndroidDriverExe();
		driverExe.waitPageLoad(1);
		driverExe.log("测试输出:《" + testName + " -【" + caseName + "】》测试结束!");
		driverExe.closeApp();
		driverExe.quitApp();
	}
	
	private void login(String username, String password) {
		IDriverExe driverExe = getAndroidDriverExe();
		DengLuPage dlp = new DengLuPage();
		driverExe.tapElement(dlp.getShoujidengluUiObject(), "点击手机登录");
		driverExe.appendTextField(dlp.getShoujihaomaUiTextView(), username);
		driverExe.appendTextField(dlp.getMimaUiTextView(), password);
		driverExe.tapElement(dlp.getDengluUiObject(), "登录确认");
		if(waitCloseDialog()){
			closeDialog();
		}
	}
	
	private void shiWan() {
		IDriverExe driverExe = getAndroidDriverExe();
		DengLuPage dlp = new DengLuPage();
		driverExe.tapElement(dlp.getYoukeshiwanUiObject(), "点击游客试玩");
		if(waitCloseDialog()){
			closeDialog();
		}
	}
	
	private boolean waitCloseDialog() {
		int count = 5;
		IDriverExe driverExe = getAndroidDriverExe();
		for (int i = 0; i < count; i++) {
			driverExe.waitPageLoad(1);
			if(driverExe.isTextInPage("每日签到") && driverExe.isTextInPage("敬请期待")){
				return true;
			}
		}
		return false;
	}
	
	private void closeDialog() {
		IDriverExe driverExe = getAndroidDriverExe();
		driverExe.foundTapElement(new CaiDanPage().getHuodongguanbiUiObject(), "点击[活动关闭]按钮");
	}
	
	private boolean isEmpty(String text){
		if(text == null || text.isEmpty()){
			return true;
		}
		return false;
	}
	
}
