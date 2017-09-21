package com.jdd.game.android.browser;

import org.testng.annotations.Test;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IWapDriverExe;
import com.paypal.selion.annotations.MobileTest;

public class BrowserTest2 extends AbsParentTest{
	private static final String JDDFUN_GAME			= "WAP";
	private static final String YE_MIAN_XIAN_SHI	= "页面元素显示";	//1
	
	@Test
	@MobileTest
	public void testWithBrowser() {
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI, null, 0);
		driverExe.open("https://m.baidu.com/");
		driverExe.sendKey(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='index-kw']", "苏州");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='index-bn']", "百度一下");
		driverExe.waitPageLoad(5);
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}
	
}
