package com.jdd.game.android.browser.suites;

import org.testng.annotations.Test;
import com.jdd.game.android.browser.AbsParentTest;
import com.jdd.game.android.driver.IWapDriverExe;
import com.paypal.selion.annotations.MobileTest;

public class Okooo extends AbsParentTest{
	private static final String TOKEN				= "77b2b07e84c88c707b7f124b41257ae0";
	private static final String JDDFUN_GAME			= "okooo";	//http://m.okooo.com/game/	http://192.168.101.181/channel/newokooo/home/1102/#/loginPop
	private static final String DENG_LU				= "登录";			//1
	private static final String YOU_XI_SHANG_CHENG	= "游戏商城";		//2
	private static final String YOU_XI_CHONG_ZHI	= "游戏充值回馈";	//3
	private static final String YOU_XI_REN_WU		= "游戏任务";		//4
	private static final String YOU_XI_PAI_HANG_BANG= "游戏排行榜";		//5
	private static final String YOU_XI_RU_KOU		= "游戏入口";		//6
	private static final String YOU_XI_CE_BIAN_LAM	= "游戏侧边栏";		//7
	private static final String GE_REN				= "个人";			//8
	
	@Test
	@MobileTest
	public void DengLu() {//登录
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, DENG_LU);
		driverExe.click("//*[@id='router-content']/div/div/p[1]", "澳客登录");
		driverExe.result("登录澳客账户");
		driverExe.sendKey("//*[@id='UserName']", "13151815253");
		driverExe.sendKey("//*[@id='Password']", "zhouzhou");
		driverExe.sendKey("//*[@id='AuthCode']", "1234");
		driverExe.click("//*[@id='loginObj']", "登录");
		driverExe.waitPageLoad(3);
		driverExe.open(String.format(OKOOO_TOKEN, TOKEN));
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
		driverExe.result("ID");
		driverExe.open(OKOOO_BEI_BAO);
		driverExe.waitPageLoad(3);
		driverExe.result("我的碎片包");
		driverExe.open(OKOOO_CHOU_JIANG);
		driverExe.waitPageLoad(3);
		driverExe.result("套圈大神榜");
		driverExe.open(OKOOO_GE_REN);
		driverExe.waitPageLoad(3);
		driverExe.result("投注记录");
		endTest(JDDFUN_GAME, DENG_LU);
	}
	
	@Test
	@MobileTest
	public void YouXiShangCheng() {//游戏-商城
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_SHANG_CHENG, 1);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click("//*[@id='router-content']/div/div/p[2]", "快速试玩");
		driverExe.click("//*[@id='router-content']/div/div[1]/div/div/div[1]/div[1]/div[2]/div/img[2]", "商城");
		driverExe.result("商城");
		driverExe.click("//*[@id='app']/div/div[5]/ul/li[1]/div[3]/a", "周卡");
		driverExe.result("支付宝支付");
		driverExe.result("微信支付");
		driverExe.click("//*[@id='app']/div/div[1]/div[1]/img", "返回");
		driverExe.waitPageLoad(2);
		driverExe.click("//*[@id='router-content']/div/div[1]/div/div/div[1]/div[1]/div[2]/div/img[2]", "商城");
		driverExe.click("//*[@id='app']/div/div[2]/img", "充值送话费");
		driverExe.waitPageLoad(2);
		driverExe.click("//*[@id='router-content']/div/div[4]/div/div[2]/p[1]", "活动关闭");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, YOU_XI_SHANG_CHENG);
	}
	
	@Test
	@MobileTest
	public void YouXiChongZhiHuiKui() {//游戏-充值回馈
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_CHONG_ZHI, 1);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click("//*[@id='router-content']/div/div/p[2]", "快速试玩");
		driverExe.click("//*[@id='router-content']/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/div[2]", "充值送话费");
		driverExe.click("//*[@id='router-content']/div/div[4]/div/div[2]/p[2]", "充值");
		driverExe.waitPageLoad(1);
		driverExe.result("支付宝支付");
		driverExe.result("微信支付");
		driverExe.getElementValue("//*[@id='app']/div/div[2]/div[1]/span[3]", "充值金额");
		endTest(JDDFUN_GAME, YOU_XI_CHONG_ZHI);
	}
	
	@Test
	@MobileTest
	public void YouXiRenWu() {//游戏-任务
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_REN_WU, 1);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click("//*[@id='router-content']/div/div[1]/div/div/div[1]/div[2]/ul/li[2]/div", "任务");
		driverExe.result("每日任务");
		driverExe.result("前往");
		driverExe.waitPageLoad(1);
		driverExe.click("//*[@id='router-content']/div/div[3]/div[2]/div[1]/ul/li[2]", "成长任务");
		driverExe.waitPageLoad(1);
		driverExe.result("前往");
		endTest(JDDFUN_GAME, YOU_XI_REN_WU);
	}
	
	@Test
	@MobileTest
	public void YouXiPaiHangBang() {//游戏-排行榜
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_PAI_HANG_BANG, 1);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click("//*[@id='router-content']/div/div[1]/div/div/div[2]/div[1]/a", "查看更多奖励");
		driverExe.waitPageLoad(1);
		driverExe.result("我的盈利");
		driverExe.result("盈利榜");
		driverExe.result("财富榜");
		driverExe.getElementValue("//*[@id='router-content']/div/div[3]/div[2]/div/div[3]/div[1]/ul/li[1]/span[2]", "盈利");
		driverExe.getElementValue("//*[@id='router-content']/div/div[3]/div[2]/div/div[3]/div[1]/ul/li[2]/span[2]", "奖励");
		driverExe.click("//*[@id='router-content']/div/div[3]/div[2]/div/div[2]/ul/li[2]", "盈利榜");
		driverExe.waitPageLoad(1);
		driverExe.getElementValue("//*[@id='router-content']/div/div[3]/div[2]/div/div[3]/div[1]/div[2]/ul/li[1]/em", "我的排名");
		driverExe.getElementValue("//*[@id='router-content']/div/div[3]/div[2]/div/div[3]/div[1]/div[2]/ul/li[2]/em", "我的奖励");
		driverExe.click("//*[@id='router-content']/div/div[3]/div[2]/div/div[2]/ul/li[3]", "财富榜");
		driverExe.waitPageLoad(1);
		driverExe.getElementValue("//*[@id='router-content']/div/div[3]/div[2]/div/div[3]/div[1]/span", "排名");
		driverExe.click("//*[@id='router-content']/div/div[3]/div[2]/a/img", "关闭");
		endTest(JDDFUN_GAME, YOU_XI_PAI_HANG_BANG);
	}
	
	@Test
	@MobileTest
	public void YouXiRuKou() {//游戏-入口
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_RU_KOU, 1);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click("//*[@id='router-content']/div/div[1]/div/div/div[4]/div/div/ul/li[1]", "游戏1");
		driverExe.waitPageLoad(6);
		driverExe.back();
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, YOU_XI_RU_KOU);
	}
	
	@Test
	@MobileTest
	public void YouXiCeBianLan() {//游戏-侧边栏
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_CE_BIAN_LAM, 1);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click("//*[@id='router-content']/div/div[3]/div/ul/li[1]/div/span/i", "超值特惠");
		driverExe.waitPageLoad(2);
		driverExe.click("//*[@id='router-content']/div/div[5]/div[2]/a/img", "关闭");
		driverExe.click("//*[@id='router-content']/div/div[3]/div/ul/li[2]/div/span/i", "新手礼包");
		driverExe.waitPageLoad(2);
		driverExe.click("//*[@id='router-content']/div/div[4]/div[2]/a[1]/img", "关闭");
		driverExe.click("//*[@id='router-content']/div/div[3]/div/ul/li[3]/div/span/i", "限时奖励");
		driverExe.waitPageLoad(2);
		driverExe.result("幸运转盘");
		driverExe.click("//*[@id='router-content']/div/div[6]/div/div[1]/div/a/img", "返回");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, YOU_XI_CE_BIAN_LAM);
	}
	
	@Test
	@MobileTest
	public void BeiBao() {//背包
		
	}
	
	@Test
	@MobileTest
	public void ChouJiang() {//抽奖
		
	}
	
	@Test
	@MobileTest
	public void GeRen() {//个人
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, GE_REN, 4);
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
