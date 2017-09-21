package com.jdd.game.android.suites.app;

//import org.testng.annotations.Listeners;
//import com.jdd.game.android.report.MyReporter;
import org.testng.annotations.Test;
import com.jdd.game.android.driver.IAppDriverExe;
import com.jdd.game.android.suites.AbsParentTest;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.pages.*;

//@Listeners({MyReporter.class})
public class DaiLiShang extends AbsParentTest {
	private static final String JDDFUN_GAME			= "微竞猜-代理商";
	private static final String YE_MIAN_XIAN_SHI	= "页面元素显示";	//1
	
	@Test
	@MobileTest
	public void YeMianXianShi() {//页面元素显示
		IAppDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI, 3, true);
		WoDePage wdp = new WoDePage();
		YaoQingHaoYouPage yqhyp = new YaoQingHaoYouPage();
		WoDeHaoYouPage wdhyp = new WoDeHaoYouPage();
		TianXieYaoQingMaPage txyqmp = new TianXieYaoQingMaPage();
		driverExe.tapElement(wdp.getYaoqinghaoyouUiObject(), "邀请好友");
		driverExe.assertPage("邀请好友");
		driverExe.assertElement(yqhyp.getWodeyaoqingmaUiObject(), "我的邀请码");
		String code = driverExe.getNameByXpath(yqhyp.getWodeyaoqingmaUiObject().getLocator());
		driverExe.logOut("我的邀请码[" + code + "]", false);
		driverExe.tapElement(yqhyp.getWodehaoyouUiObject(), "我的好友");
		driverExe.assertPage("支持记录");
		driverExe.assertPage("返利记录");
		driverExe.tapElement(wdhyp.getFanlijiluUiObject(), "返利记录");
		driverExe.back();
		driverExe.tapElement(yqhyp.getTianxieyaoqingmaUiObject(), "填写邀请码");
		driverExe.assertPage("填写邀请码");
		driverExe.appendTextField(txyqmp.getYaoqingmaUiTextView(), code);
		driverExe.tapElement(txyqmp.getQuerenUiObject(), "确认");
		driverExe.waitPageLoad(3);
		driverExe.appendTextField(txyqmp.getYaoqingmaUiTextView(), "0000000");
		driverExe.tapElement(txyqmp.getQuerenUiObject(), "确认");
		driverExe.waitPageLoad(3);
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}
}
