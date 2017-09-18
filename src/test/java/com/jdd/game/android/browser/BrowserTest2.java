package com.jdd.game.android.browser;

import org.testng.annotations.Test;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.BrowserDriver;
import com.jdd.game.android.driver.IDriverExe;
import com.paypal.selion.annotations.MobileTest;

public class BrowserTest2 extends BrowserDriver{

	@Test
	@MobileTest
	public void testWithBrowser() {
		IDriverExe driverExe = runBrowserDriverExe();
		driverExe.open("https://www.baidu.com/");
		driverExe.sendKey(Const.LOCATIONTYPE_PC_XPATH, ".//*[@id='kw']", "苏州");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, ".//*[@id='su']");
		driverExe.waitPageLoad(5);
	}
	
}
