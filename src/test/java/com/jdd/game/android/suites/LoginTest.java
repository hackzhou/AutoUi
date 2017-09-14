package com.jdd.game.android.suites;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.report.MyReporter;
import com.jdd.pages.DengLuPage;

@Listeners({MyReporter.class})
public class LoginTest extends AbsParentTest {
	private static final String NAME_TEST	= "微竞猜";
	private static final String LOGIN_TEST	= "测试登录";

	@Test
	@MobileTest
	public void login() {
		IDriverExe driverExe = startTest(NAME_TEST, LOGIN_TEST, 0, false);
		DengLuPage dl = new DengLuPage();
		driverExe.tapElement(dl.getShoujidengluUiObject(), "点击手机登录");
		driverExe.appendTextField(dl.getShoujihaomaUiTextView(), "13151815253");
		driverExe.appendTextField(dl.getMimaUiTextView(), "zhouzhou");
		driverExe.clear2SetTextField(dl.getShoujihaomaUiTextView(), "13151815253");
		driverExe.tapElement(dl.getDengluUiObject(), "登录确认");
		endTest(NAME_TEST, LOGIN_TEST);
	}

}