package com.jdd.game.android.suites.app;

import org.testng.annotations.Test;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.suites.AbsParentTest;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.pages.*;

public class LingJiangTai extends AbsParentTest {
	private static final String JDDFUN_GAME			= "微竞猜-领奖台";
	private static final String YE_MIAN_XIAN_SHI	= "页面元素显示";	//1
	private static final String SUI_PIAN_SHI_WU		= "碎片实物";		//2
	
	@Test
	@MobileTest
	public void YeMianXianShi() {//页面元素显示
		IDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI, true);
		CaiDanPage cdp = new CaiDanPage();
		LingJiangTaiPage ljtp = new LingJiangTaiPage();
		driverExe.tapElement(cdp.getLingjiangtaiUiObject(), "点击[领奖台]标签页");
		driverExe.assertElement(ljtp.getXingyundachoujiangUiObject(), "验证[幸运大抽奖]是否存在");
		driverExe.log("测试输出:免费抽奖次数[" + driverExe.getNameByXpath(ljtp.getMianfeicishuUiObject().getLocator()) + "]");
		driverExe.tapElement(ljtp.getXingyundachoujiangUiObject(), "点击[幸运大抽奖]");
		driverExe.waitPageLoad(5);
		driverExe.assertPage("欢乐套圈", "验证[欢乐套圈]是否存在");
		driverExe.back();
		driverExe.assertElement(ljtp.getChaojipaihangbangUiObject(), "验证[超级排行榜]是否存在");
		driverExe.log("测试输出:倒计时[" + driverExe.getNameByXpath(ljtp.getDaojishiUiObject().getLocator()) + "]");
		driverExe.tapElement(ljtp.getChaojipaihangbangUiObject(), "点击[超级排行榜]");
		driverExe.waitPageLoad(5);
		driverExe.back();
		driverExe.assertPage("我的碎片合集", "验证[我的碎片合集]是否存在");
		
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}
	
	@Test
	@MobileTest
	public void SuiPianShiWu() {//碎片实物
		IDriverExe driverExe = startTest(JDDFUN_GAME, SUI_PIAN_SHI_WU, true);
		CaiDanPage cdp = new CaiDanPage();
		LingJiangTaiPage ljtp = new LingJiangTaiPage();
		driverExe.tapElement(cdp.getLingjiangtaiUiObject(), "点击[领奖台]标签页");
		driverExe.assertPage("碎片记录", "验证[碎片记录]是否存在");
		driverExe.assertPage("实物记录", "验证[实物记录]是否存在");
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_UP, 0.2, 1);
		driverExe.log("测试输出:查看碎片记录", true);
		driverExe.tapElement(ljtp.getShiwujiluUiObject(), "点击[实物记录]");
		driverExe.waitPageLoad(2);
		driverExe.log("测试输出:查看实物记录", true);
		endTest(JDDFUN_GAME, SUI_PIAN_SHI_WU);
	}

}
