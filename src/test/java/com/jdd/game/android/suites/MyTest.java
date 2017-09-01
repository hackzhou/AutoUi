package com.jdd.game.android.suites;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.report.MyReporter;
import com.jdd.pages.LoginPage;

@Listeners({MyReporter.class})
public class MyTest extends AbsParentTest {
	private static final String NAME_TEST	= "微竞猜";

	@Test
	@MobileTest
	public void test1() {
		String caseName = "测试登录";
		IDriverExe driverExe = startTest(NAME_TEST, caseName);
		LoginPage lp = new LoginPage();
		driverExe.tapElement(lp.getPhoneLoginUiObject(), "点击手机登录");
		driverExe.appendTextField(lp.getPhoneNumberUiTextView(), "13151815253");
		driverExe.appendTextField(lp.getPasswordUiTextView(), "zhouzhou");
		driverExe.clear2SetTextField(lp.getPhoneNumberUiTextView(), "13151815253");
		driverExe.tapElement(lp.getLoginUiObject(), "登录确认");
		driverExe.waitPageLoad(10);
		endTest(NAME_TEST, caseName);
	}

}