package com.jdd.game.android.suites.app;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.report.MyReporter;
import com.jdd.game.android.suites.AbsParentTest;
import com.paypal.selion.annotations.MobileTest;
import com.jdd.pages.*;

@Listeners({MyReporter.class})
public class GeRenZhongXin extends AbsParentTest {
	private static final String NAME_TEST	= "微竞猜";
	
	@Test
	@MobileTest
	public void yeMianXianShi() {//页面元素显示
		String caseName = "页面元素显示";
		IDriverExe driverExe = startTest(NAME_TEST, caseName);
		shiWan();
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
//		driverExe.foundTapElement(cdp.getHuodongguanbiUiObject(), "点击[活动关闭]按钮");
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.assertElement(wdp.getTouxiangUiObject(), "验证[头像]是否存在");
		driverExe.assertElement(wdp.getNichengUiObject(), "验证[昵称]是否存在");
		driverExe.tapElement(wdp.getXiugainichengUiObject(), "点击[修改昵称]");
		driverExe.appendTextField(wdp.getXiugainichengUiTextView(), "自动化测试");
//		driverExe.tapElement(wdp.getNichengquerenUiObject(), "点击[修改昵称确认]");
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
	public void xiuGaiTouXiang() {//修改头像
		String caseName = "修改 头像";
		IDriverExe driverExe = startTest(NAME_TEST, caseName);
		shiWan();
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		TouXiangPage txp = new TouXiangPage();
//		driverExe.foundTapElement(cdp.getHuodongguanbiUiObject(), "点击[活动关闭]按钮");
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getTouxiangUiObject(), "点击[头像]");
		driverExe.tapElement(txp.getPaishezhaopianUiObject(), "点击[拍摄照片]");
		driverExe.waitPageLoad(1);
		driverExe.foundTapElement(txp.getYunxuUiButton(), "点击[允许调用摄像头]按钮");
		driverExe.tapElement(txp.getPaizhaoUiObject(), "点击[拍照]按钮");
		driverExe.waitPageLoad(3);
		driverExe.tapElement(txp.getPaizhaowanchengUiObject(), "点击[拍照完成]按钮");
		driverExe.tapElement(wdp.getTouxiangUiObject(), "点击[头像]");
		driverExe.tapElement(txp.getBendixiangceUiObject(), "点击[本地相册]");
		driverExe.tapElement(txp.getZhaopianUiObject(), "点击[照片]");
		driverExe.waitPageLoad(3);
		endTest(NAME_TEST, caseName);
	}
	
	@Test
	@MobileTest
	public void xiuGaiNiCheng() {//修改昵称
		
	}
	
	@Test
	@MobileTest
	public void ChongZhi() {//充值
		
	}
	
	@Test
	@MobileTest
	public void ZiJinMingXi() {//资金明细
		String caseName = "资金明细";
		IDriverExe driverExe = startTest(NAME_TEST, caseName);
		login("13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		ZiJinMingXiPage zjmx = new ZiJinMingXiPage();
//		driverExe.foundTapElement(cdp.getHuodongguanbiUiObject(), "点击[活动关闭]按钮");
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getZijinmingxiUiObject(), "点击[资金明细]");
		driverExe.tapElement(zjmx.getChongzhijiluUiObject(), "点击[充值记录]");
		driverExe.tapElement(zjmx.getJinyezijiluUiObject(), "点击[金叶子记录]");
		driverExe.tapElement(zjmx.getRiliUiObject(), "点击[日历]");
		driverExe.waitPageLoad(3);
		endTest(NAME_TEST, caseName);
	}
	
	@Test
	@MobileTest
	public void ShouHuoXinXi() {//收货信息
		String caseName = "收货信息";
		IDriverExe driverExe = startTest(NAME_TEST, caseName);
		login("13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		ShouHuoXinXiPage shxx = new ShouHuoXinXiPage();
//		driverExe.foundTapElement(cdp.getHuodongguanbiUiObject(), "点击[活动关闭]按钮");
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getShouhuoxinxiUiObject(), "点击[收货信息]");
		driverExe.assertPage("收货人", "验证[收货人]是否存在");
		driverExe.assertPage("联系电话", "验证[联系电话]是否存在");
		driverExe.assertPage("详细地址", "验证[详细地址]是否存在");
		driverExe.appendTextField(shxx.getShouhuorenUiTextView(), "周洲");
		driverExe.appendTextField(shxx.getLianxidianhuaUiTextView(), "13151815253");
		driverExe.appendTextField(shxx.getXiangxidizhiUiTextView(), "苏州工业园区");
		driverExe.tapElement(shxx.getQuerenUiObject(), "确认");
		driverExe.waitPageLoad(1);
		endTest(NAME_TEST, caseName);
	}
	
	@Test
	@MobileTest
	public void KeFu() {//客服
		String caseName = "客服";
		IDriverExe driverExe = startTest(NAME_TEST, caseName);
		login("13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		KeFuPage kf = new KeFuPage();
//		driverExe.foundTapElement(cdp.getHuodongguanbiUiObject(), "点击[活动关闭]按钮");
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getKefuUiObject(), "点击[客服]");
		driverExe.waitPageLoad(2);
		driverExe.assertPage("为您服务", "验证[微竞猜客服]是否连接成功");
		driverExe.appendTextField(kf.getXiaoxikuangUiTextView(), "自动化测试，请忽略！");
		driverExe.tapElement(kf.getFasongxiaoxiUiObject(), "发送消息");
		driverExe.waitPageLoad(2);
		driverExe.tapElement(kf.getFanhuiUiObject(), "返回");
		driverExe.waitPageLoad(1);
		endTest(NAME_TEST, caseName);
	}
	
	@Test
	@MobileTest
	public void SheZhi() {//设置
		String caseName = "设置";
		IDriverExe driverExe = startTest(NAME_TEST, caseName);
		login("13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		SheZhiPage szp = new SheZhiPage();
		TongZhiZhongXinPage tzzx = new TongZhiZhongXinPage();
//		driverExe.foundTapElement(cdp.getHuodongguanbiUiObject(), "点击[活动关闭]按钮");
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getShezhiUiObject(), "点击[设置]");
		driverExe.tapElement(szp.getTongzhizhongxinUiObject(), "点击[通知中心]");
		driverExe.assertPage("中奖通知", "验证[中奖通知]是否存在");
		driverExe.assertPage("免打扰时间", "验证[免打扰时间]是否存在");
		driverExe.assertPage("发烧模式", "验证[发烧模式]是否存在");
		driverExe.tapElement(tzzx.getZhongjiangUiObject(), "点击[中奖通知]");
		driverExe.waitPageLoad(1);
		driverExe.tapElement(tzzx.getMiandaraoUiObject(), "点击[免打扰时间]");
		driverExe.waitPageLoad(1);
		driverExe.tapElement(tzzx.getFashaomoshiUiObject(), "点击[发烧模式]");
		driverExe.waitPageLoad(1);
		driverExe.tapElement(tzzx.getZhongjiangUiObject(), "点击[中奖通知]");
		driverExe.waitPageLoad(1);
		driverExe.tapElement(tzzx.getFashaomoshiUiObject(), "点击[发烧模式]");
		driverExe.waitPageLoad(1);
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]");
		driverExe.assertPage("清除缓存", "验证[清除缓存]是否存在");
		driverExe.tapElement(szp.getQingchuhuancunUiObject(), "点击[清除缓存]");
		driverExe.assertPage("帮助中心", "验证[帮助中心]是否存在");
		driverExe.tapElement(szp.getBangzhuzhongxinUiObject(), "点击[帮助中心]");
		driverExe.waitPageLoad(5);
		driverExe.assertPage("帮助中心", "验证[帮助中心页面]是否加载成功");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]");
		driverExe.assertPage("关于我们", "验证[关于我们]是否存在");
		driverExe.tapElement(szp.getGuanyuwomenUiObject(), "点击[关于我们]");
		driverExe.assertPage("微竞猜", "验证[关于我们页面]是否加载成功");
		driverExe.assertPage("V", "验证[关于我们页面]是否加载成功");
		driverExe.assertPage("苏州市联科创智信息技术有限公司", "验证[关于我们页面]是否加载成功");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "返回");
		driverExe.waitPageLoad(1);
		driverExe.tapElement(szp.getTuichudengluUiObject(), "点击[退出登录]按钮");
		driverExe.tapElement(szp.getTuichuquerenUiObject(), "点击[退出确认]按钮");
		driverExe.waitPageLoad(1);
		endTest(NAME_TEST, caseName);
	}

}
