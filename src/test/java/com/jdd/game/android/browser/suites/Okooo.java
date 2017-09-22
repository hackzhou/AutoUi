package com.jdd.game.android.browser.suites;

import org.testng.annotations.Test;
import com.jdd.game.android.browser.AbsParentTest;
import com.jdd.game.android.driver.IWapDriverExe;
import com.jdd.pages.WapOkoooPage;
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
	private static final String BEI_BAO				= "背包";			//8
	private static final String CHOU_JIANG			= "抽奖";			//9
	private static final String GE_REN				= "个人";			//10
	
	@Test
	@MobileTest
	public void DengLu() {//登录
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, DENG_LU);
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.click(wop.getAokedengluUiObject().getLocator(), "澳客登录");
		driverExe.result("登录澳客账户");
		driverExe.sendKey(wop.getYonghumingUiObject().getLocator(), "13151815253");
		driverExe.sendKey(wop.getMimaUiObject().getLocator(), "zhouzhou");
		driverExe.sendKey(wop.getYanzhengmaUiObject().getLocator(), "1234");
		driverExe.click(wop.getDengluUiObject().getLocator(), "登录");
		driverExe.waitPageLoad(3);
		driverExe.open(String.format(OKOOO_TOKEN, TOKEN));
		if(driverExe.result("澳客登录") && driverExe.result("快速试玩")){
			driverExe.logOut("登录失败[TOKEN-已过期]", false);
		}else{
			driverExe.logOut("登录成功[TOKEN-未过期]", false);
		}
		driverExe.waitPageLoad(3);
		driverExe.open(OKOOO_LOGIN);
		driverExe.click(wop.getKuaisushiwanUiObject().getLocator(), "快速试玩");
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
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.click(wop.getShangchengUiObject().getLocator(), "商城");
		driverExe.result("商城");
		driverExe.click(wop.getZhoukaUiObject().getLocator(), "周卡");
		driverExe.getElementValue(wop.getYouxibiduihuanUiObject().getLocator(), "游戏币兑换金额");
		driverExe.result("支付宝支付");
		driverExe.result("微信支付");
		driverExe.click(wop.getFanhuishangchengUiObject().getLocator(), "返回");
		driverExe.waitPageLoad(2);
		driverExe.click(wop.getShangchengUiObject().getLocator(), "商城");
		driverExe.click(wop.getPijiuqingliangUiObject().getLocator(), "清凉啤酒");
		driverExe.getElementValue(wop.getYouxibiduihuanUiObject().getLocator(), "游戏币兑换金额");
		driverExe.result("支付宝支付");
		driverExe.result("微信支付");
		driverExe.result("立即兑换");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, YOU_XI_SHANG_CHENG);
	}
	
	@Test
	@MobileTest
	public void YouXiChongZhiHuiKui() {//游戏-充值回馈
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_CHONG_ZHI, 1);
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.click(wop.getSonghuafeiUiObject().getLocator(), "充值送话费");
		driverExe.click(wop.getChongzhiyouxiUiObject().getLocator(), "充值");
		driverExe.waitPageLoad(1);
		driverExe.result("支付宝支付");
		driverExe.result("微信支付");
		driverExe.getElementValue(wop.getChongzhijineUiObject().getLocator(), "充值金额");
		endTest(JDDFUN_GAME, YOU_XI_CHONG_ZHI);
	}
	
	@Test
	@MobileTest
	public void YouXiRenWu() {//游戏-任务
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_REN_WU, 1);
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.click(wop.getRenwuyouxiUiObject().getLocator(), "任务");
		driverExe.result("每日任务");
		driverExe.result("前往");
		driverExe.waitPageLoad(1);
		driverExe.click(wop.getChengzhangrenwuUiObject().getLocator(), "成长任务");
		driverExe.waitPageLoad(1);
		driverExe.result("前往");
		endTest(JDDFUN_GAME, YOU_XI_REN_WU);
	}
	
	@Test
	@MobileTest
	public void YouXiPaiHangBang() {//游戏-排行榜
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_PAI_HANG_BANG, 1);
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.click(wop.getChakangengduojiangliUiObject().getLocator(), "查看更多奖励");
		driverExe.waitPageLoad(1);
		driverExe.result("我的盈利");
		driverExe.result("盈利榜");
		driverExe.result("财富榜");
		driverExe.getElementValue(wop.getYingliUiObject().getLocator(), "盈利");
		driverExe.getElementValue(wop.getJiangliUiObject().getLocator(), "奖励");
		driverExe.click(wop.getYinglibangUiObject().getLocator(), "盈利榜");
		driverExe.waitPageLoad(1);
		driverExe.getElementValue(wop.getWodepaimingUiObject().getLocator(), "我的排名");
		driverExe.getElementValue(wop.getWodejiangliUiObject().getLocator(), "我的奖励");
		driverExe.click(wop.getCaifubangUiObject().getLocator(), "财富榜");
		driverExe.waitPageLoad(1);
		driverExe.getElementValue(wop.getPaimingUiObject().getLocator(), "排名");
		driverExe.click(wop.getGuanbipaihangbangUiObject().getLocator(), "关闭");
		endTest(JDDFUN_GAME, YOU_XI_PAI_HANG_BANG);
	}
	
	@Test
	@MobileTest
	public void YouXiRuKou() {//游戏-入口
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_RU_KOU, 1);
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.click(wop.getRukouyouxi1UiObject().getLocator(), "游戏入口1");
		driverExe.waitPageLoad(6);
		driverExe.back();
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, YOU_XI_RU_KOU);
	}
	
	@Test
	@MobileTest
	public void YouXiCeBianLan() {//游戏-侧边栏
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, YOU_XI_CE_BIAN_LAM, 1);
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.click(wop.getChaozhitehuiUiObject().getLocator(), "超值特惠");
		driverExe.waitPageLoad(2);
		driverExe.click(wop.getGuanbichaozhiUiObject().getLocator(), "关闭");
		driverExe.click(wop.getXinshoulibaoUiObject().getLocator(), "新手礼包");
		driverExe.waitPageLoad(2);
		driverExe.click(wop.getGuanbixinshouUiObject().getLocator(), "关闭");
		driverExe.click(wop.getXianshijiangliUiObject().getLocator(), "限时奖励");
		driverExe.waitPageLoad(2);
		driverExe.result("幸运转盘");
		driverExe.click(wop.getFanhuicebianlanUiObject().getLocator(), "返回");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, YOU_XI_CE_BIAN_LAM);
	}
	
	@Test
	@MobileTest
	public void BeiBao() {//背包
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, BEI_BAO, 2);
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.result("我的碎片包");
		driverExe.click(wop.getHuafeiquanUiObject().getLocator(), "话费券");
		driverExe.result("我的话费券");
		driverExe.getElementValue(wop.getWodehuafeiquanUiObject().getLocator(), "我的话费券");
		driverExe.click(wop.getGuanbibeibaoUiObject().getLocator(), "关闭");
		driverExe.click(wop.getJingdongquanUiObject().getLocator(), "京东券");
		driverExe.result("我的京东卡");
		driverExe.getElementValue(wop.getWodejingdongkaUiObject().getLocator(), "我的京东卡");
		driverExe.click(wop.getGuanbibeibaoUiObject().getLocator(), "关闭");
		driverExe.click(wop.getIphone7UiObject().getLocator(), "iphone7");
		driverExe.result("iPhone7");
		driverExe.getElementValue(wop.getIphone7quanUiObject().getLocator(), "iPhone7券");
		driverExe.click(wop.getGuanbibeibaoUiObject().getLocator(), "关闭");
		driverExe.click(wop.getRenwuUiObject().getLocator(), "任务");
		driverExe.result("碎片记录");
		driverExe.click(wop.getHechengjiluUiObject().getLocator(), "合成记录");
		driverExe.result("获取时间");
		driverExe.result("奖品");
		driverExe.result("来源");
		driverExe.click(wop.getGuanbibeibaoUiObject().getLocator(), "关闭");
		driverExe.click(wop.getShuomingUiObject().getLocator(), "说明");
		driverExe.result("碎片说明");
		driverExe.click(wop.getGuanbibeibaoUiObject().getLocator(), "关闭");
		driverExe.result("奖励");
		driverExe.result("领奖时间");
		driverExe.result("奖品");
		driverExe.result("状态");
		endTest(JDDFUN_GAME, BEI_BAO);
	}
	
	@Test
	@MobileTest
	public void ChouJiang() {//抽奖
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, CHOU_JIANG, 3);
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.click(wop.getHuanletaoquanUiObject().getLocator(), "欢乐套圈");
		driverExe.waitPageLoad(4);
		driverExe.back();
		driverExe.waitPageLoad(1);
		driverExe.click(wop.getBizhongtaoquanUiObject().getLocator(), "必中套圈");
		driverExe.waitPageLoad(4);
		driverExe.back();
		driverExe.waitPageLoad(1);
		driverExe.result("限时兑换");
		driverExe.result("套圈大神榜");
		driverExe.click(wop.getTaoquandashenbangUiObject().getLocator(), "套圈大神榜");
		driverExe.result("奖品");
		driverExe.result("中奖类型");
		driverExe.result("中奖时间");
		driverExe.result("大神昵称");
		endTest(JDDFUN_GAME, CHOU_JIANG);
	}
	
	@Test
	@MobileTest
	public void GeRen() {//个人
		IWapDriverExe driverExe = startTest(JDDFUN_GAME, GE_REN, 4);
		WapOkoooPage wop = new WapOkoooPage();
		driverExe.getElementValue(wop.getZhanghaoUiObject().getLocator(), "账号");
		driverExe.getElementValue(wop.getJinyezishuUiObject().getLocator(), "金叶子数");
		driverExe.click(wop.getChongzhiUiObject().getLocator(), "投注记录");
		driverExe.result("商城");
		driverExe.back();//*[@id="app"]/div/div[1]/div[1]/img
		driverExe.waitPageLoad(3);
		driverExe.click(wop.getTouzhujiluUiObject().getLocator(), "投注记录");
		driverExe.result("时间");
		driverExe.result("游戏");
		driverExe.result("金叶子数");
		driverExe.click(wop.getFanhuigeren1UiObject().getLocator(), "返回");
		driverExe.click(wop.getZijinmingxiUiObject().getLocator(), "资金明细");
		driverExe.result("时间");
		driverExe.result("业务");
		driverExe.result("金额");
		driverExe.result("状态");
		driverExe.click(wop.getFanhuigeren1UiObject().getLocator(), "返回");
		driverExe.click(wop.getWodexiaoxiUiObject().getLocator(), "我的消息");
		driverExe.result("消息");
		driverExe.click(wop.getZhongjiangxinxiUiObject().getLocator(), "中奖信息");
		driverExe.result("中奖信息");
		driverExe.click(wop.getFanhuigeren2UiObject().getLocator(), "返回");
		driverExe.click(wop.getKefuzhuanquUiObject().getLocator(), "客服专区");
		driverExe.result("官方qq群：602079021");
		driverExe.result("官方客服电话：");
		driverExe.result("0512-62873936");
		driverExe.result("加入玩家QQ群可与更多玩家互动获取攻略哦");
		driverExe.click(wop.getFanhuigeren2UiObject().getLocator(), "返回");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, GE_REN);
	}
	
}
