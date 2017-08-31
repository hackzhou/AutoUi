package com.jdd.game.android.suites;

import com.jdd.game.android.driver.AppDriver;
import com.jdd.game.android.driver.IDriverExe;

public abstract class AbsParentTest extends AppDriver{

	protected IDriverExe startTest(String testName, String caseName) {
		IDriverExe driverExe = runAndroidDriverExe();
		driverExe.log("测试输出:《" + testName + " -【" + caseName + "】》测试开始!");
//		this.login();
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
	
}
