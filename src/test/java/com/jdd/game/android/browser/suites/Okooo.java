package com.jdd.game.android.browser.suites;

import org.testng.annotations.Test;
import com.jdd.game.android.browser.AbsParentTest;
import com.jdd.game.android.driver.IWapDriverExe;
import com.paypal.selion.annotations.MobileTest;

public class Okooo extends AbsParentTest{
	private static final String TOKEN				= "77b2b07e84c88c707b7f124b41257ae0";
	private static final String OKOOO_LOGIN			= "http://192.168.101.181/channel/newokooo/home/1102/#/loginPop";
	private static final String OKOOO_TOKEN			= "http://192.168.101.181/channel/newokooo/home/1102/?token=" + TOKEN + "&type=jdd&status=login#/";
	private static final String OKOOO_YOU_XI		= "http://192.168.101.181/channel/newokooo/home/1102/#/";
	private static final String OKOOO_BEI_BAO		= "http://192.168.101.181/channel/newokooo/home/1102/#/knapsack";
	private static final String OKOOO_CHOU_JIANG	= "http://192.168.101.181/channel/newokooo/home/1102/#/luckdraw";
	private static final String OKOOO_GE_REN		= "http://192.168.101.181/channel/newokooo/home/1102/#/personal";
	private static final String JDDFUN_GAME			= "okooo";	//http://m.okooo.com/game/	http://192.168.101.181/channel/newokooo/home/1102/#/loginPop
	private static final String DENG_LU				= "登录";		//1
	private static final String GE_REN				= "个人";		//1
	
	@Test
	@MobileTest
	public void DengLu() {//个人中心
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, DENG_LU);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click("//*[@id='router-content']/div/div/p[1]", "澳客登录");
		driverExe.result("登录澳客账户");
		driverExe.sendKey("//*[@id='UserName']", "13151815253");
		driverExe.sendKey("//*[@id='Password']", "zhouzhou");
		driverExe.sendKey("//*[@id='AuthCode']", "1234");
		driverExe.click("//*[@id='loginObj']", "登录");
		driverExe.waitPageLoad(3);
		driverExe.open(OKOOO_TOKEN);
		if(driverExe.result("澳客登录") && driverExe.result("快速试玩")){
			driverExe.logOut("登录失败[TOKEN-已过期]", false);
		}else{
			driverExe.logOut("登录成功[TOKEN-未过期]", false);
		}
		driverExe.waitPageLoad(3);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click("//*[@id='router-content']/div/div/p[2]", "快速试玩");
		driverExe.waitPageLoad(2);
		driverExe.open(OKOOO_YOU_XI);
		driverExe.waitPageLoad(3);
		driverExe.open(OKOOO_BEI_BAO);
		driverExe.waitPageLoad(3);
		driverExe.open(OKOOO_CHOU_JIANG);
		driverExe.waitPageLoad(3);
		driverExe.open(OKOOO_GE_REN);
		driverExe.waitPageLoad(3);
		endTest(JDDFUN_GAME, DENG_LU);
	}
	
	@Test
	@MobileTest
	public void YouXi() {//个人中心
		
	}
	
	@Test
	@MobileTest
	public void BeiBao() {//个人中心
		
	}
	
	@Test
	@MobileTest
	public void ChouJiang() {//个人中心
		
	}
	
	@Test
	@MobileTest
	public void GeRen() {//个人中心
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, GE_REN);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click("//*[@id='router-content']/div/div/p[2]", "快速试玩");
		driverExe.foundClick("//*[@id='router-content']/div/div[4]/div/div[2]/p[1]", "活动关闭");
		driverExe.open(OKOOO_GE_REN);
		//driverExe.click("//*[@id='router-content']/div/div[2]/ul/li[4]/a", "个人");
		driverExe.getElementValue("//*[@id='router-content']/div/div[1]/p/span", "账号");
		driverExe.getElementValue("//*[@id='router-content']/div/div[2]/p[2]", "金叶子数");
		driverExe.click("//*[@id='router-content']/div/div[3]/ul/li[1]/span", "投注记录");
		driverExe.result("时间");
		driverExe.result("游戏");
		driverExe.result("金叶子数");
		driverExe.click("//*[@id='router-content']/div/div[6]/div[1]/div[1]/div/a/img", "返回");
		driverExe.click("//*[@id='router-content']/div/div[3]/ul/li[2]/span", "资金明细");
		driverExe.result("时间");
		driverExe.result("业务");
		driverExe.result("金额");
		driverExe.result("状态");
		driverExe.click("//*[@id='router-content']/div/div[6]/div[1]/div[1]/div/a/img", "返回");
		driverExe.click("//*[@id='router-content']/div/div[3]/ul/li[3]/a/span", "我的消息");
		driverExe.result("消息");
		driverExe.click("//*[@id='router-content']/div/div[6]/div[2]/ul/li[2]/span", "中奖信息");
		driverExe.result("中奖信息");
		driverExe.click("//*[@id='router-content']/div/div[6]/div[1]/div/a/img", "返回");
		driverExe.click("//*[@id='router-content']/div/div[3]/ul/li[4]/a/span", "客服专区");
		driverExe.result("官方qq群：602079021");
		driverExe.result("官方客服电话：");
		driverExe.result("0512-62873936");
		driverExe.result("加入玩家QQ群可与更多玩家互动获取攻略哦");
		driverExe.click("//*[@id='router-content']/div/div[6]/div[1]/div/a/img", "返回");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, GE_REN);
	}
	
}