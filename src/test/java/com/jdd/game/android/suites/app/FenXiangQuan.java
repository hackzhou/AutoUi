package com.jdd.game.android.suites.app;

//import org.testng.annotations.Listeners;
//import com.jdd.game.android.report.MyReporter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.Test;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.suites.AbsParentTest;
import com.jdd.game.android.utils.AdbUtil;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.pages.*;

//@Listeners({MyReporter.class})
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
		IDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI, 4, true);
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		driverExe.assertPage("分享圈");
		driverExe.assertElement(fxqp.getBangzhuUiObject(), "帮助");
		driverExe.assertElement(fxqp.getQuanbuUiObject(), "全部");
		driverExe.assertElement(fxqp.getWoUiObject(), "我");
		driverExe.assertElement(fxqp.getTieshiUiObject(), "贴士");
		driverExe.assertElement(fxqp.getGonglueUiObject(), "攻略");
		driverExe.assertElement(fxqp.getNeirongUiObject(), "内容");
		driverExe.tapElement(fxqp.getWoUiObject(), "我");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}
	
	@Test
	@MobileTest
	public void ShuaXinChaKan() {//刷新查看
		IDriverExe driverExe = startTest(JDDFUN_GAME, SHUA_XIN_CHA_KAN, 4, true);
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		driverExe.swipeDirection(Const.SWIPE_DIRECTION_DOWN, 0.6, 1);
		driverExe.tapElement(fxqp.getTieshiUiObject(), "贴士");
		driverExe.logOut("获取贴士内容[" + driverExe.getNameByXpath(fxqp.getTieshineirongUiObject().getLocator()) + "]", false);
		driverExe.tapElement(fxqp.getGonglueUiObject(), "攻略");
		back();
		endTest(JDDFUN_GAME, SHUA_XIN_CHA_KAN);
	}
	
	@Test
	@MobileTest
	public void DianZan() {//点赞
		IDriverExe driverExe = startTest(JDDFUN_GAME, Dian_Zan, 4, true);
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		driverExe.logOut("攻略点赞数[" + driverExe.getNameByXpath(fxqp.getGongluedianzanshuUiObject().getLocator()) + "]", false);
		driverExe.tapElement(fxqp.getGongluedianzanUiObject(), "攻略点赞");
		driverExe.logOut("攻略点赞数[" + driverExe.getNameByXpath(fxqp.getGongluedianzanshuUiObject().getLocator()) + "]", false);
		driverExe.logOut("分享点赞数[" + driverExe.getNameByXpath(fxqp.getFenxiangdianzanshuUiObject().getLocator()) + "]", false);
		driverExe.tapElement(fxqp.getFenxiangdianzanUiObject(), "分享点赞");
		driverExe.logOut("分享点赞数[" + driverExe.getNameByXpath(fxqp.getFenxiangdianzanshuUiObject().getLocator()) + "]", false);
		endTest(JDDFUN_GAME, Dian_Zan);
	}
	
	@Test
	@MobileTest
	public void FaBuFenXiang() {//发布分享
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String text = "自动化测试，请忽略！-" + sdf.format(new Date());
		IDriverExe driverExe = startTest(JDDFUN_GAME, FA_BU_FEN_XIANG, 4, true);
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		FenXiangFaBuPage fxfbp = new FenXiangFaBuPage();
		driverExe.tapElement(fxqp.getFabufenxiangUiObject(), "发布分享");
		driverExe.waitPageLoad(2);
		driverExe.assertPage("分享中奖信息或游戏心得");
		driverExe.appendTextField(fxfbp.getFenxiangneirongUiTextView(), text);
		driverExe.tapElement(fxfbp.getTianjiatupianUiObject(), "添加图片");
		driverExe.tapElement(fxfbp.getBendixiangceUiObject(), "本地相册");
		driverExe.tapElement(fxfbp.getTupianOneUiObject(), "照片1");
		driverExe.tapElement(fxfbp.getWanchengUiObject(), "完成");
		driverExe.tapElement(fxfbp.getFabuUiObject(), "发布");
		driverExe.waitPageLoad(5);
		driverExe.assertPage("待审核");
		driverExe.assertPage(text);
		endTest(JDDFUN_GAME, FA_BU_FEN_XIANG);
	}
	
	@Test
	@MobileTest
	public void FenXiangPingLun() {//分享评论
		IDriverExe driverExe = startTest(JDDFUN_GAME, FEN_XIANG_PING_LUN, 4, true);
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		FenXiangXiangQingPage fxxqp = new FenXiangXiangQingPage();
		driverExe.tapElement(fxqp.getNeirongUiObject(), "评论内容");
		driverExe.assertPage("详情");
		driverExe.logOut("当前评论数[" + driverExe.getNameByXpath(fxxqp.getPinglunshuUiObject().getLocator()) + "]", false);
		driverExe.appendTextField(fxxqp.getPinglunUiTextView(), "自动化测试，请忽略！");
		AdbUtil.exeKeyboard1();
		driverExe.waitPageLoad(2);
		driverExe.tapElement(fxxqp.getFasongUiObject(), "发送");
		AdbUtil.exeKeyboard0();
		driverExe.waitPageLoad(2);
		driverExe.logOut("当前评论数[" + driverExe.getNameByXpath(fxxqp.getPinglunshuUiObject().getLocator()) + "]", false);
		endTest(JDDFUN_GAME, FEN_XIANG_PING_LUN);
	}
	
	@Test
	@MobileTest
	public void GongLueFenXiang() {//攻略分享
		IDriverExe driverExe = startTest(JDDFUN_GAME, GONG_LUE_FEN_XIANG, 4, true);
		FenXiangQuanPage fxqp = new FenXiangQuanPage();
		driverExe.tapElement(fxqp.getGonglueUiObject(), "攻略");
		driverExe.waitPageLoad(3);
		driverExe.tapElement(fxqp.getGongluefenxiangUiObject(), "攻略分享");
		driverExe.assertPage("微信好友");
		driverExe.assertPage("朋友圈");
		driverExe.assertPage("QQ");
		driverExe.assertPage("QQ空间");
		endTest(JDDFUN_GAME, GONG_LUE_FEN_XIANG);
	}
	
}
