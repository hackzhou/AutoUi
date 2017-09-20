package com.jdd.game.android.browser.suites.okooo;

import org.testng.annotations.Test;
import com.jdd.game.android.browser.AbsParentTest;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IDriverExe;
import com.paypal.selion.annotations.MobileTest;

public class GeRenZhongXin extends AbsParentTest{
	private static final String JDDFUN_GAME			= "okooo-个人中心";
	private static final String YE_MIAN_XIAN_SHI	= "个人资料";	//1
	
	@Test
	@MobileTest
	public void GeRenZiLiao() {//个人资料
		IDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
		driverExe.open("http://192.168.101.181/channel/newokooo/home/");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div/p[2]", "快速试玩");
		driverExe.foundClick(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[4]/div[2]/p[1]", "活动关闭");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[2]/ul/li[4]/a", "个人");
		driverExe.getElementValue(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[1]/p/span", "账号");
		driverExe.getElementValue(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[2]/p[2]", "金叶子数");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[3]/ul/li[1]/span", "投注记录");
		driverExe.result("时间");
		driverExe.result("游戏");
		driverExe.result("金叶子数");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[6]/div[1]/div[1]/div/a/img", "返回");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[3]/ul/li[2]/span", "资金明细");
		driverExe.result("时间");
		driverExe.result("业务");
		driverExe.result("金额");
		driverExe.result("状态");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[6]/div[1]/div[1]/div/a/img", "返回");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[3]/ul/li[3]/a/span", "我的消息");
		driverExe.result("消息");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[6]/div[2]/ul/li[2]/span", "中奖信息");
		driverExe.result("中奖信息");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[6]/div[1]/div/a/img", "返回");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[3]/ul/li[4]/a/span", "客服专区");
		driverExe.result("官方qq群：602079021");
		driverExe.result("官方客服电话：");
		driverExe.result("0512-62873936");
		driverExe.result("加入玩家QQ群可与更多玩家互动获取攻略哦");
		driverExe.click(Const.LOCATIONTYPE_PC_XPATH, "//*[@id='router-content']/div/div[6]/div[1]/div/a/img", "返回");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}

}
