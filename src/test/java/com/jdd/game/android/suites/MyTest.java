package com.jdd.game.android.suites;

import org.testng.annotations.Test;
import com.jdd.game.android.driver.AppDriver;
import com.jdd.game.android.driver.IDriverExe;
import com.paypal.selion.annotations.MobileTest;

public class MyTest extends AppDriver {

	@Test
	@MobileTest(mobileNodeType = "appium", device = "android")
	public void test1() {
		IDriverExe driverExe = runAndroidDriverExe();
		driverExe.waitPageLoad(10);
		driverExe.isTextInPage("");
		driverExe.waitPageLoad(10);
	}

}