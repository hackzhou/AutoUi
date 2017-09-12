package com.jdd.game.android.suites.app;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.report.MyReporter;
import com.jdd.game.android.suites.AbsParentTest;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.pages.*;

@Listeners({MyReporter.class})
public class DaiLiShang extends AbsParentTest {
	private static final String JDDFUN_GAME			= "微竞猜-代理商";
	private static final String YE_MIAN_XIAN_SHI	= "页面元素显示";	//1
	
	@Test
	@MobileTest
	public void YeMianXianShi() {//页面元素显示
		IDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI, true);
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		YaoQingHaoYouPage yqhyp = new YaoQingHaoYouPage();
		WoDeHaoYouPage wdhyp = new WoDeHaoYouPage();
		TianXieYaoQingMaPage txyqmp = new TianXieYaoQingMaPage();
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getYaoqinghaoyouUiObject(), "点击[邀请好友]");
		driverExe.assertElement(yqhyp.getWodeyaoqingmaUiObject(), "验证[邀请好友]是否存在");
		String code = driverExe.getNameByXpath(yqhyp.getWodeyaoqingmaUiObject().getLocator());
		driverExe.log("测试输出:我的邀请码[" + code + "]");
		driverExe.tapElement(yqhyp.getWodehaoyouUiObject(), "点击[我的好友]");
		driverExe.assertPage("支持记录", "验证[支持记录]是否存在");
		driverExe.assertPage("返利记录", "验证[返利记录]是否存在");
		driverExe.tapElement(wdhyp.getFanlijiluUiObject(), "点击[返利记录]");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]");
		driverExe.tapElement(yqhyp.getTianxieyaoqingmaUiObject(), "点击[填写邀请码]");
		driverExe.assertPage("填写邀请码", "验证[填写邀请码]是否存在");
		driverExe.appendTextField(txyqmp.getYaoqingmaUiTextView(), code);
		driverExe.tapElement(txyqmp.getQuerenUiObject(), "点击[确认]");
		driverExe.waitPageLoad(3);
		driverExe.appendTextField(txyqmp.getYaoqingmaUiTextView(), "0000000");
		driverExe.tapElement(txyqmp.getQuerenUiObject(), "点击[确认]");
		driverExe.waitPageLoad(3);
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}
}
