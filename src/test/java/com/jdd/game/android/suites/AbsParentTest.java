package com.jdd.game.android.suites;

import com.jdd.game.android.driver.AppDriver;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.pages.DengLuPage;

public abstract class AbsParentTest extends AppDriver{

	protected IDriverExe startTest(String testName, String caseName) {
		IDriverExe driverExe = runAndroidDriverExe();
		driverExe.log("测试输出:《" + testName + " -【" + caseName + "】》测试开始!");
		driverExe.waitPageLoad(1);
		return driverExe;
	}
	
	protected void endTest(String testName, String caseName) {
		IDriverExe driverExe = getAndroidDriverExe();
		driverExe.waitPageLoad(1);
		driverExe.log("测试输出:《" + testName + " -【" + caseName + "】》测试结束!");
		driverExe.closeApp();
		driverExe.quitApp();
	}
	
	protected void login(String username, String password) {
		IDriverExe driverExe = getAndroidDriverExe();
		DengLuPage dl = new DengLuPage();
		driverExe.tapElement(dl.getShoujidengluUiObject(), "点击手机登录");
		driverExe.appendTextField(dl.getShoujihaomaUiTextView(), username);
		driverExe.appendTextField(dl.getMimaUiTextView(), password);
		driverExe.tapElement(dl.getDengluUiObject(), "登录确认");
		driverExe.waitPageLoad(1);
	}
	
	protected void shiWan() {
		IDriverExe driverExe = getAndroidDriverExe();
		DengLuPage dl = new DengLuPage();
		driverExe.tapElement(dl.getYoukeshiwanUiObject(), "点击游客试玩");
		driverExe.waitPageLoad(1);
	}
	
}
