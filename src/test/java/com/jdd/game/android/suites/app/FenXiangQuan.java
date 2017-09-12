package com.jdd.game.android.suites.app;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.report.MyReporter;
import com.jdd.game.android.suites.AbsParentTest;
import com.jdd.game.android.utils.AdbUtil;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.pages.*;

@Listeners({MyReporter.class})
public class FenXiangQuan extends AbsParentTest {
	private static final String JDDFUN_GAME			= "微竞猜-分享圈";
	private static final String YE_MIAN_XIAN_SHI	= "页面元素显示";	//1
	private static final String SHUA_XIN_CHA_KAN	= "刷新查看";		//2
	private static final String Dian_Zan			= "点赞";			//3
	private static final String FA_BU_FEN_XIANG		= "发布分享";		//4
	private static final String FEN_XIANG_PING_LUN	= "分享评论";		//5
	private static final String GONG_LUE_FEN_XIANG	= "攻略分享";		//6
	
	@Test
	@MobileTest
	public void YeMianXianShi() {//页面元素显示
		IDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI, true);
		entryHome();
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		driverExe.assertPage("分享圈", "验证[分享圈]是否存在");
		driverExe.assertElement(fxqp.getBangzhuUiObject(), "验证[帮助]是否存在");
		driverExe.assertElement(fxqp.getQuanbuUiObject(), "验证[全部]是否存在");
		driverExe.assertElement(fxqp.getWoUiObject(), "验证[我]是否存在");
		driverExe.assertElement(fxqp.getWoUiObject(), "验证[我]是否存在");
		driverExe.assertElement(fxqp.getTieshiUiObject(), "验证[贴士]是否存在");
		driverExe.assertElement(fxqp.getGonglueUiObject(), "验证[攻略]是否存在");
		driverExe.assertElement(fxqp.getNeirongUiObject(), "验证[内容]是否存在");
		driverExe.tapElement(fxqp.getWoUiObject(), "点击[我]标签页");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}
	
	@Test
	@MobileTest
	public void ShuaXinChaKan() {//刷新查看
		IDriverExe driverExe = startTest(JDDFUN_GAME, SHUA_XIN_CHA_KAN, true);
		entryHome();
		CaiDanPage cdp = new CaiDanPage();
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_DOWN, 0.6, 1);
		driverExe.tapElement(fxqp.getTieshiUiObject(), "点击[贴士]控件");
		driverExe.log("测试输出:获取贴士内容[" + driverExe.getNameByXpath(fxqp.getTieshineirongUiObject().getLocator()) + "]");
		driverExe.tapElement(fxqp.getGonglueUiObject(), "点击[攻略]控件");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]控件");
		endTest(JDDFUN_GAME, SHUA_XIN_CHA_KAN);
	}
	
	@Test
	@MobileTest
	public void DianZan() {//点赞
		IDriverExe driverExe = startTest(JDDFUN_GAME, Dian_Zan, true);
		entryHome();
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		driverExe.log("测试输出:攻略点赞数[" + driverExe.getNameByXpath(fxqp.getGongluedianzanshuUiObject().getLocator()) + "]");
		driverExe.tapElement(fxqp.getGongluedianzanUiObject(), "点击[攻略点赞]控件");
		driverExe.log("测试输出:攻略点赞数[" + driverExe.getNameByXpath(fxqp.getGongluedianzanshuUiObject().getLocator()) + "]");
		driverExe.log("测试输出:分享点赞数[" + driverExe.getNameByXpath(fxqp.getFenxiangdianzanshuUiObject().getLocator()) + "]");
		driverExe.tapElement(fxqp.getFenxiangdianzanUiObject(), "点击[分享点赞]控件");
		driverExe.log("测试输出:分享点赞数[" + driverExe.getNameByXpath(fxqp.getFenxiangdianzanshuUiObject().getLocator()) + "]");
		endTest(JDDFUN_GAME, Dian_Zan);
	}
	
	@Test
	@MobileTest
	public void FaBuFenXiang() {//发布分享
		IDriverExe driverExe = startTest(JDDFUN_GAME, FA_BU_FEN_XIANG, true);
		entryHome();
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		FenXiangFaBuPage fxfbp = new FenXiangFaBuPage();
		driverExe.tapElement(fxqp.getFabufenxiangUiObject(), "点击[发布分享]按钮");
		driverExe.waitPageLoad(1);
		driverExe.assertPage("分享中奖信息或游戏心得", "验证[分享中奖信息或游戏心得]是否存在");
		driverExe.appendTextField(fxfbp.getFenxiangneirongUiTextView(), "自动化测试，请忽略！自动化测试，请忽略！");
		driverExe.tapElement(fxfbp.getTianjiatupianUiObject(), "点击[添加图片]按钮");
		driverExe.tapElement(fxfbp.getBendixiangceUiObject(), "点击[本地相册]按钮");
		driverExe.tapElement(fxfbp.getTupianOneUiObject(), "点击[照片1]按钮");
		driverExe.tapElement(fxfbp.getWanchengUiObject(), "点击[完成]按钮");
		driverExe.tapElement(fxfbp.getFabuUiObject(), "点击[发布]按钮");
		driverExe.waitPageLoad(3);
		endTest(JDDFUN_GAME, FA_BU_FEN_XIANG);
	}
	
	@Test
	@MobileTest
	public void FenXiangPingLun() {//分享评论
		IDriverExe driverExe = startTest(JDDFUN_GAME, FEN_XIANG_PING_LUN, true);
		entryHome();
		AdbUtil adb = new AdbUtil();
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		FenXiangXiangQingPage fxxqp = new FenXiangXiangQingPage();
		driverExe.tapElement(fxqp.getNeirongUiObject(), "点击[评论内容]控件");
		driverExe.appendTextField(fxxqp.getPinglunUiTextView(), "自动化测试，请忽略！");
		adb.exeKeyboard1();
		driverExe.waitPageLoad(2);
		driverExe.tapElement(fxxqp.getFasongUiObject(), "点击[发送]控件");
		adb.exeKeyboard0();
		driverExe.waitPageLoad(2);
		endTest(JDDFUN_GAME, FEN_XIANG_PING_LUN);
	}
	
	@Test
	@MobileTest
	public void GongLueFenXiang() {//攻略分享
		IDriverExe driverExe = startTest(JDDFUN_GAME, GONG_LUE_FEN_XIANG, true);
		entryHome();
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		driverExe.tapElement(fxqp.getGonglueUiObject(), "点击[攻略]控件");
		driverExe.waitPageLoad(3);
		driverExe.tapElement(fxqp.getGongluefenxiangUiObject(), "点击[攻略分享]控件");
		driverExe.assertPage("微信好友", "验证[微信好友]是否存在");
		driverExe.assertPage("朋友圈", "验证[朋友圈]是否存在");
		driverExe.assertPage("QQ", "验证[QQ]是否存在");
		driverExe.assertPage("QQ空间", "验证[QQ空间]是否存在");
		endTest(JDDFUN_GAME, GONG_LUE_FEN_XIANG);
	}
	
	private void entryHome(){//进入分享圈主页
		IDriverExe driverExe = getAndroidDriverExe();
		driverExe.assertPage("大神分享", "验证[大神分享]是否存在");
		driverExe.assertPage("查看更多", "验证[查看更多]是否存在");
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_UP, 0.1, 1);
		driverExe.tapElement(new YouXiDaTingPage().getChakangengduoUiObject(), "点击[查看更多]标签页");
		driverExe.waitPageLoad(1);
	}

}
