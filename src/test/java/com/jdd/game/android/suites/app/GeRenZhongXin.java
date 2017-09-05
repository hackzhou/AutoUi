package com.jdd.game.android.suites.app;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.report.MyReporter;
import com.jdd.game.android.suites.AbsParentTest;
import com.jdd.pages.CaiDanPage;
import com.jdd.pages.WoDePage;
import com.paypal.selion.annotations.MobileTest;

@Listeners({MyReporter.class})
public class GeRenZhongXin extends AbsParentTest {
	private static final String NAME_TEST	= "微竞猜";
	
	@Test
	@MobileTest
	public void yeMianXianShi() {
		String caseName = "页面元素显示";
		IDriverExe driverExe = startTest(NAME_TEST, caseName);
		shiWan();
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		driverExe.tapElement(cdp.getHuodongguanbiUiObject(), "点击[活动关闭]按钮");
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.assertElement(wdp.getTouxiangUiObject(), "验证[头像]是否存在");
		driverExe.assertElement(wdp.getNichengUiObject(), "验证[昵称]是否存在");
		driverExe.tapElement(wdp.getXiugainichengUiObject(), "点击[修改昵称]");
		driverExe.appendTextField(wdp.getXiugainichengUiTextView(), "自动化测试");
		driverExe.tapElement(wdp.getNichengquerenUiObject(), "点击[修改昵称确认]");
		driverExe.assertElement(wdp.getJinyezishuUiObject(), "验证[金叶子数]是否存在");
		driverExe.tapElement(wdp.getJinyezishuUiObject(), "点击[金叶子数]");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]");
		driverExe.assertElement(wdp.getZijinmingxiUiObject(), "验证[资金明细]是否存在");
		driverExe.assertElement(wdp.getShouhuoxinxiUiObject(), "验证[收货信息]是否存在");
		driverExe.assertElement(wdp.getYaoqinghaoyouUiObject(), "验证[邀请好友]是否存在");
		driverExe.assertElement(wdp.getKefuUiObject(), "验证[客服]是否存在");
		driverExe.assertElement(wdp.getShezhiUiObject(), "验证[设置]是否存在");
		endTest(NAME_TEST, caseName);
	}
	
	@Test
	@MobileTest
	public void xiuGaiTouXiang() {
		String caseName = "修改 头像";
		IDriverExe driverExe = startTest(NAME_TEST, caseName);
		
		endTest(NAME_TEST, caseName);
	}
	
	@Test
	@MobileTest
	public void xiuGaiNiCheng() {
		
	}

}
