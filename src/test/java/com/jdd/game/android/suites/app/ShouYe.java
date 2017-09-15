package com.jdd.game.android.suites.app;

//import org.testng.annotations.Listeners;
//import com.jdd.game.android.report.MyReporter;
import org.testng.annotations.Test;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.suites.AbsParentTest;
import com.jdd.pages.*;

//@Listeners({MyReporter.class})
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
		IDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI, 0, true);
		CaiDanPage cdp = new CaiDanPage();
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.assertElement(yxdtp.getYonghutouxiangUiObject(), "用户头像");
		driverExe.assertElement(yxdtp.getYonghuidUiObject(), "用户ID");
		driverExe.logOut("用户ID[" + driverExe.getNameByXpath(yxdtp.getYonghuidUiObject().getLocator()) + "]", false);
		driverExe.assertElement(yxdtp.getYonghunichengUiObject(), "用户昵称");
		driverExe.logOut("用户昵称[" + driverExe.getNameByXpath(yxdtp.getYonghunichengUiObject().getLocator()) + "]", false);
		driverExe.assertElement(yxdtp.getJinyezishuUiObject(), "金叶子数");
		driverExe.logOut("金叶子数[" + driverExe.getNameByXpath(yxdtp.getJinyezishuUiObject().getLocator()) + "]", false);
		driverExe.assertElement(yxdtp.getRenwuUiObject(), "任务");
		driverExe.tapElement(yxdtp.getRenwuUiObject(), "任务");
		driverExe.tapElement(cdp.getHuodongguanbiUiObject(), "任务关闭");
		driverExe.assertElement(yxdtp.getXiaoxiUiObject(), "消息中心");
		driverExe.tapElement(yxdtp.getXiaoxiUiObject(), "消息中心");
		back();
		driverExe.assertPage("下级奖励");
		driverExe.assertElement(yxdtp.getXiajijiangliUiObject(), "下级奖励");
		driverExe.logOut("下级奖励[" + driverExe.getNameByXpath(yxdtp.getXiajijiangliUiObject().getLocator()) + "]", false);
		driverExe.assertElement(yxdtp.getDaojishiUiObject(), "倒计时");
		driverExe.logOut("倒计时[" + driverExe.getNameByXpath(yxdtp.getDaojishiUiObject().getLocator()) + "]", false);
		if(!driverExe.isTextInPage("暂无榜单")){
			driverExe.assertElement(yxdtp.getGuanjunUiObject(), "排行榜-冠军");
			driverExe.logOut("排行榜-冠军[" + driverExe.getNameByXpath(yxdtp.getGuanjunUiObject().getLocator()) + "]", false);
		}
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_UP, 0.1, 1);
		driverExe.assertPage("大神分享");
		driverExe.assertPage("查看更多");
		driverExe.tapElement(yxdtp.getChakangengduoUiObject(), "查看更多");
		back();
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}
	
	@Test
	@MobileTest
	public void ChongZhiTiaoZhuan() {//充值跳转
		IDriverExe driverExe = startTest(JDDFUN_GAME, CHONG_ZHI_TIAO_ZHUAN, 0, true);
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		ChongZhiPage czp = new ChongZhiPage();
		driverExe.tapElement(yxdtp.getJinyezishuUiObject(), "金叶子数");
		driverExe.waitPageLoad(10);
		driverExe.tapElementWebView(czp.getChongzhioneUiObject().getLocator(), "充值-1");
		driverExe.tapElementWebView(czp.getChongzhitwoUiObject().getLocator(), "充值-2");
		driverExe.tapElement(czp.getZhifubaozhifuUiObject(), "支付宝-支付");
		endTest(JDDFUN_GAME, CHONG_ZHI_TIAO_ZHUAN);
	}
	
	@Test
	@MobileTest
	public void MeiRiQianDao() {//每日签到
		IDriverExe driverExe = startTest(JDDFUN_GAME, MEI_RI_QIAN_DAO, 0, true);
		CaiDanPage cdp = new CaiDanPage();
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.assertElement(yxdtp.getRenwuUiObject(), "任务");
		driverExe.tapElement(yxdtp.getRenwuUiObject(), "任务");
		driverExe.assertPage("每日签到");
		driverExe.tapElement(yxdtp.getLijichoujiangUiObject(), "立即抽奖");
		driverExe.waitPageLoad(3);
		driverExe.logOut("签到几天[" + driverExe.getNameByXpath(yxdtp.getQiandaojitianUiObject().getLocator()) + "]", false);
		driverExe.tapElement(cdp.getHuodongguanbiUiObject(), "任务关闭");
		endTest(JDDFUN_GAME, MEI_RI_QIAN_DAO);
	}
	
	@Test
	@MobileTest
	public void PaiHangBang() {//排行榜
		IDriverExe driverExe = startTest(JDDFUN_GAME, PAI_HANG_BANG, 0, true);
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		PaiHangBangPage phbp = new PaiHangBangPage();
		driverExe.tapElement(yxdtp.getJinrupaihangbangUiObject(), "进入排行榜");
		driverExe.waitPageLoad(5);
		driverExe.logOut("验证查看排行榜", true);
		driverExe.tapElementWebView(phbp.getShangqibangdanUiObject().getLocator(), "上期榜单");
		driverExe.waitPageLoad(1);
		driverExe.logOut("验证查看上期榜单", true);
		driverExe.tapElementWebView(phbp.getGuanbibangdanUiObject().getLocator(), "上期榜单-关闭");
		driverExe.tapElementWebView(phbp.getDajiangmijiUiObject().getLocator(), "大奖获取秘籍");
		driverExe.waitPageLoad(1);
		driverExe.logOut("验证查看规则详情", true);
		driverExe.tapElementWebView(phbp.getGuanbimijiUiObject().getLocator(), "大奖获取秘籍-关闭");
		driverExe.tapElementWebView(phbp.getFuhaobangUiObject().getLocator(), "富豪榜");
		driverExe.waitPageLoad(1);
		driverExe.logOut("验证查看富豪榜", true);
		driverExe.tapElementWebView(phbp.getBangzhuUiObject().getLocator(), "帮助");
		driverExe.waitPageLoad(3);
		driverExe.assertPage("帮助中心");
		endTest(JDDFUN_GAME, PAI_HANG_BANG);
	}
	
	@Test
	@MobileTest
	public void LunBoTu() {//轮播图
		IDriverExe driverExe = startTest(JDDFUN_GAME, LUN_BO_TU, 0, true);
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.tapElement(yxdtp.getLunbotuUiObject(), "轮播图");
		driverExe.waitPageLoad(3);
		back();
		driverExe.tapElement(yxdtp.getLunbotuUiObject(), "轮播图");
		driverExe.waitPageLoad(3);
		back();
		endTest(JDDFUN_GAME, LUN_BO_TU);
	}
	
	@Test
	@MobileTest
	public void GongLueFenXiang() {//攻略分享
		IDriverExe driverExe = startTest(JDDFUN_GAME, GONG_LUE_FEN_XIANG, 0, true);
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_UP, 0.3, 1);
		driverExe.tapElementByXpath(yxdtp.getGongluefenxiangUiObject().getLocator(), 0, "攻略");
		driverExe.waitPageLoad(5);
		driverExe.assertPage("攻略详情");
		back();
		driverExe.tapElementByXpath(yxdtp.getGongluefenxiangUiObject().getLocator(), 1, "分享");
		driverExe.waitPageLoad(5);
		driverExe.assertPage("详情");
		back();
		endTest(JDDFUN_GAME, GONG_LUE_FEN_XIANG);
	}
	
	@Test
	@MobileTest
	public void CeBianLan() {//侧边栏
		IDriverExe driverExe = startTest(JDDFUN_GAME, CE_BIAN_LAN, 0, true);
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_UP, 0.1, 1);
		driverExe.tapElement(yxdtp.getXianshibianlanUiObject(), "显示边栏");
		if(driverExe.isTextInPage("立即开启")){
			driverExe.tapElement(yxdtp.getLijikaiqiUiObject(), "立即开启");
		}
		if(driverExe.isTextInPage("幸运转盘")){
			driverExe.tapElement(yxdtp.getXingyunzhuanpanUiObject(), "幸运转盘");
			driverExe.waitPageLoad(5);
			driverExe.assertPage("幸运转盘");
			back();
		}
		if(driverExe.isTextInPage("首充送话费")){
			driverExe.tapElement(yxdtp.getShouchongsonghuafeiUiObject(), "首充送话费");
			driverExe.waitPageLoad(5);
			driverExe.assertPage("充值回馈");
			back();
		}
		endTest(JDDFUN_GAME, CE_BIAN_LAN);
	}

}
