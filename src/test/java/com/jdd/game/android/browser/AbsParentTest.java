package com.jdd.game.android.browser;

import com.jdd.game.android.driver.BrowserDriver;
import com.jdd.game.android.driver.IDriverExe;

public abstract class AbsParentTest extends BrowserDriver{

	protected IDriverExe startTest(String testName, String caseName) {
		IDriverExe driverExe = runBrowserDriverExe();
		driverExe.waitPageLoad(1);
		driverExe.log("测试输出:《" + testName + "-【" + caseName + "】》测试开始！");
		return driverExe;
	}
	
	protected void endTest(String testName, String caseName) {
		IDriverExe driverExe = getBrowserDriverExe();
		driverExe.waitPageLoad(1);
		driverExe.log("测试输出:《" + testName + "-【" + caseName + "】》测试结束！");
		driverExe.close();
		driverExe.quit();
	}

}
