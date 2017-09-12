package com.jdd.game.android.suites.app;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.report.MyReporter;
import com.jdd.game.android.suites.AbsParentTest;
import com.jdd.pages.*;

@Listeners({MyReporter.class})
public class ShouYe extends AbsParentTest {
	private static final String JDDFUN_GAME				= "微竞猜-首页";
	private static final String YE_MIAN_XIAN_SHI		= "页面元素显示";	//1
	private static final String CHONG_ZHI_TIAO_ZHUAN	= "充值跳转";		//2
	private static final String MEI_RI_QIAN_DAO			= "每日签到";		//3
	private static final String PAI_HANG_BANG			= "排行榜";		//4
	private static final String LUN_BO_TU				= "轮播图";		//5
	private static final String GONG_LUE_FEN_XIANG		= "攻略分享";		//6
	private static final String CE_BIAN_LAN				= "侧边栏";		//7
	
	@Test
	@MobileTest
	public void YeMianXianShi() {//页面元素显示
		IDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI, true);
		CaiDanPage cdp = new CaiDanPage();
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.assertElement(yxdtp.getYonghutouxiangUiObject(), "验证[用户头像]是否存在");
		driverExe.assertElement(yxdtp.getYonghuidUiObject(), "验证[用户ID]是否存在");
		driverExe.log("测试输出:用户ID[" + driverExe.getNameByXpath(yxdtp.getYonghuidUiObject().getLocator()) + "]");
		driverExe.assertElement(yxdtp.getYonghunichengUiObject(), "验证[用户昵称]是否存在");
		driverExe.log("测试输出:用户昵称[" + driverExe.getNameByXpath(yxdtp.getYonghunichengUiObject().getLocator()) + "]");
		driverExe.assertElement(yxdtp.getJinyezishuUiObject(), "验证[金叶子数]是否存在");
		driverExe.log("测试输出:金叶子数[" + driverExe.getNameByXpath(yxdtp.getJinyezishuUiObject().getLocator()) + "]");
		driverExe.assertElement(yxdtp.getRenwuUiObject(), "验证[任务]是否存在");
		driverExe.tapElement(yxdtp.getRenwuUiObject(), "点击[任务]控件");
		driverExe.tapElement(cdp.getHuodongguanbiUiObject(), "点击[任务关闭]按钮");
		driverExe.assertElement(yxdtp.getTongzhiUiObject(), "验证[通知]是否存在");
		driverExe.tapElement(yxdtp.getTongzhiUiObject(), "点击[通知]控件");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]按钮");
		driverExe.assertPage("下级奖励", "验证[下级奖励]标签是否存在");
		driverExe.assertElement(yxdtp.getXiajijiangliUiObject(), "验证[下级奖励]是否存在");
		driverExe.log("测试输出:下级奖励[" + driverExe.getNameByXpath(yxdtp.getXiajijiangliUiObject().getLocator()) + "]");
		driverExe.assertElement(yxdtp.getDaojishiUiObject(), "验证[倒计时]是否存在");
		driverExe.log("测试输出:倒计时[" + driverExe.getNameByXpath(yxdtp.getDaojishiUiObject().getLocator()) + "]");
		if(!driverExe.isTextInPage("暂无榜单")){
			driverExe.assertElement(yxdtp.getGuanjunUiObject(), "验证[排行榜-冠军]是否存在");
			driverExe.log("测试输出:排行榜-冠军[" + driverExe.getNameByXpath(yxdtp.getGuanjunUiObject().getLocator()) + "]");
		}
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_UP, 0.1, 1);
		driverExe.assertPage("大神分享", "验证[大神分享]是否存在");
		driverExe.assertPage("查看更多", "验证[查看更多]是否存在");
		driverExe.tapElement(yxdtp.getChakangengduoUiObject(), "点击[查看更多]标签页");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]按钮");
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}
	
	@Test
	@MobileTest
	public void ChongZhiTiaoZhuan() {//充值跳转
		IDriverExe driverExe = startTest(JDDFUN_GAME, CHONG_ZHI_TIAO_ZHUAN, true);
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		ChongZhiPage czp = new ChongZhiPage();
		driverExe.tapElement(yxdtp.getJinyezishuUiObject(), "点击[金叶子数]控件");
		driverExe.waitPageLoad(10);
		driverExe.tapElementWebView(czp.getChongzhioneUiObject().getLocator(), "点击[充值]按钮1");
		driverExe.tapElementWebView(czp.getChongzhitwoUiObject().getLocator(), "点击[充值]按钮2");
		driverExe.tapElement(czp.getZhifubaozhifuUiObject(), "点击[支付宝支付]按钮");
		endTest(JDDFUN_GAME, CHONG_ZHI_TIAO_ZHUAN);
	}
	
	@Test
	@MobileTest
	public void MeiRiQianDao() {//每日签到
		IDriverExe driverExe = startTest(JDDFUN_GAME, MEI_RI_QIAN_DAO, true);
		CaiDanPage cdp = new CaiDanPage();
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.assertElement(yxdtp.getRenwuUiObject(), "验证[任务]是否存在");
		driverExe.tapElement(yxdtp.getRenwuUiObject(), "点击[任务]控件");
		driverExe.assertPage("每日签到", "验证[每日签到]是否存在");
		driverExe.tapElement(yxdtp.getLijichoujiangUiObject(), "点击[立即抽奖]按钮");
		driverExe.waitPageLoad(3);
		driverExe.log("测试输出:签到几天[" + driverExe.getNameByXpath(yxdtp.getQiandaojitianUiObject().getLocator()) + "]");
		driverExe.tapElement(cdp.getHuodongguanbiUiObject(), "点击[任务关闭]按钮");
		endTest(JDDFUN_GAME, MEI_RI_QIAN_DAO);
	}
	
	@Test
	@MobileTest
	public void PaiHangBang() {//排行榜
		IDriverExe driverExe = startTest(JDDFUN_GAME, PAI_HANG_BANG, true);
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.tapElement(yxdtp.getJinrupaihangbangUiObject(), "点击[进入排行榜]控件");
		driverExe.waitPageLoad(5);
		driverExe.log("测试输出:验证查看排行榜", true);
		endTest(JDDFUN_GAME, PAI_HANG_BANG);
	}
	
	@Test
	@MobileTest
	public void LunBoTu() {//轮播图
		IDriverExe driverExe = startTest(JDDFUN_GAME, LUN_BO_TU, true);
		CaiDanPage cdp = new CaiDanPage();
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.tapElement(yxdtp.getLunbotuUiObject(), "点击[轮播图]控件");
		driverExe.waitPageLoad(3);
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]按钮");
		driverExe.tapElement(yxdtp.getLunbotuUiObject(), "点击[轮播图]控件");
		driverExe.waitPageLoad(3);
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]按钮");
		endTest(JDDFUN_GAME, LUN_BO_TU);
	}
	
	@Test
	@MobileTest
	public void GongLueFenXiang() {//攻略分享
		IDriverExe driverExe = startTest(JDDFUN_GAME, GONG_LUE_FEN_XIANG, true);
		CaiDanPage cdp = new CaiDanPage();
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_UP, 0.4, 1);
		driverExe.tapElementByXpath(yxdtp.getGongluefenxiangUiObject().getLocator(), 0, "点击[攻略]控件");
		driverExe.waitPageLoad(3);
		driverExe.assertPage("攻略详情", "验证[攻略详情]是否存在");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]按钮");
		driverExe.tapElementByXpath(yxdtp.getGongluefenxiangUiObject().getLocator(), 1, "点击[分享]控件");
		driverExe.waitPageLoad(3);
		driverExe.assertPage("详情", "验证[详情]是否存在");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]按钮");
		endTest(JDDFUN_GAME, GONG_LUE_FEN_XIANG);
	}
	
	@Test
	@MobileTest
	public void CeBianLan() {//侧边栏
		IDriverExe driverExe = startTest(JDDFUN_GAME, CE_BIAN_LAN, true);
		CaiDanPage cdp = new CaiDanPage();
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_UP, 0.1, 1);
		driverExe.tapElement(yxdtp.getXianshibianlanUiObject(), "点击[显示边栏]按钮");
		if(driverExe.isTextInPage("立即开启")){
			driverExe.tapElement(yxdtp.getLijikaiqiUiObject(), "点击[立即开启]按钮");
		}
		if(driverExe.isTextInPage("幸运转盘")){
			driverExe.tapElement(yxdtp.getXingyunzhuanpanUiObject(), "点击[幸运转盘]按钮");
			driverExe.waitPageLoad(3);
			driverExe.assertPage("幸运转盘", "验证[幸运转盘]是否存在");
			driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]按钮");
		}
		if(driverExe.isTextInPage("首充送话费")){
			driverExe.tapElement(yxdtp.getShouchongsonghuafeiUiObject(), "点击[首充送话费]按钮");
			driverExe.waitPageLoad(3);
			driverExe.assertPage("充值回馈", "验证[充值回馈]是否存在");
			driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]按钮");
		}
		endTest(JDDFUN_GAME, CE_BIAN_LAN);
	}

}
