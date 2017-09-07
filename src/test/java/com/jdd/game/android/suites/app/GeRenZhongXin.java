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
	private static final String JDDFUN_GAME			= "微竞猜";
	private static final String YE_MIAN_XIAN_SHI	= "页面元素显示";	//1
	private static final String XIU_GAI_TOU_XIANG	= "修改头像";		//2
	private static final String XIU_GAI_NI_CHENG	= "修改昵称";		//3
	private static final String CHONG_ZHI			= "充值";			//4
	private static final String ZI_JIN_MING_XI		= "资金明细";		//5
	private static final String XIAO_XI_ZHONG_XIN	= "消息中心";		//6
	private static final String WO_DE_FU_LI			= "我的福利";		//7
	private static final String KE_FU				= "客服";			//8
	private static final String SHOU_HUO_XIN_XI		= "收货信息";		//9
	private static final String SHE_ZHI				= "设置";			//10
	private static final String LI_JI_ZHU_CE		= "立即注册";		//11
	private static final String YOU_KE_ZHU_CE		= "游客注册";		//12
	
	@Test
	@MobileTest
	public void YeMianXianShi() {//页面元素显示
		IDriverExe driverExe = startTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI, true);
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.assertElement(wdp.getTouxiangUiObject(), "验证[头像]是否存在");
		driverExe.assertElement(wdp.getNichengUiObject(), "验证[昵称]是否存在");
		driverExe.tapElement(wdp.getXiugainichengUiObject(), "点击[修改昵称]");
		driverExe.tapElement(wdp.getGuanbiUiObject(), "点击[修改昵称关闭]");
		driverExe.assertElement(wdp.getJinyezishuUiObject(), "验证[金叶子数]是否存在");
		driverExe.tapElement(wdp.getJinyezishuUiObject(), "点击[金叶子数]");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]");
		driverExe.assertElement(wdp.getZijinmingxiUiObject(), "验证[资金明细]是否存在");
		driverExe.assertElement(wdp.getShouhuoxinxiUiObject(), "验证[收货信息]是否存在");
		driverExe.assertElement(wdp.getYaoqinghaoyouUiObject(), "验证[邀请好友]是否存在");
		driverExe.assertElement(wdp.getKefuUiObject(), "验证[客服]是否存在");
		driverExe.assertElement(wdp.getShezhiUiObject(), "验证[设置]是否存在");
		endTest(JDDFUN_GAME, YE_MIAN_XIAN_SHI);
	}
	
	@Test
	@MobileTest
	public void XiuGaiTouXiang() {//修改头像
		IDriverExe driverExe = startTest(JDDFUN_GAME, XIU_GAI_TOU_XIANG, true);
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		TouXiangPage txp = new TouXiangPage();
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getTouxiangUiObject(), "点击[头像]");
		driverExe.tapElement(txp.getPaishezhaopianUiObject(), "点击[拍摄照片]");
		driverExe.waitPageLoad(1);
		driverExe.foundTapElement(cdp.getYunxuUiButton(), "点击[允许调用摄像头]按钮");
		driverExe.tapElement(txp.getPaizhaoUiObject(), "点击[拍照]按钮");
		driverExe.waitPageLoad(3);
		driverExe.tapElement(txp.getPaizhaowanchengUiObject(), "点击[拍照完成]按钮");
		driverExe.tapElement(wdp.getTouxiangUiObject(), "点击[头像]");
		driverExe.tapElement(txp.getBendixiangceUiObject(), "点击[本地相册]");
		driverExe.tapElement(txp.getZhaopianUiObject(), "点击[照片]");
		driverExe.waitPageLoad(3);
		endTest(JDDFUN_GAME, XIU_GAI_TOU_XIANG);
	}
	
	@Test
	@MobileTest
	public void XiuGaiNiCheng() {//修改昵称
		IDriverExe driverExe = startTest(JDDFUN_GAME, XIU_GAI_NI_CHENG, true);
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getXiugainichengUiObject(), "点击[修改昵称]");
		driverExe.assertPage("昵称仅可以修改一次", "验证[昵称仅可以修改一次]是否存在");
		driverExe.appendTextField(wdp.getXiugainichengUiTextView(), "123");
		driverExe.tapElement(wdp.getNichengquerenUiObject(), "点击[修改昵称确认]");
		driverExe.tapElement(wdp.getXiugainichengUiObject(), "点击[修改昵称]");
		driverExe.clear2SetTextField(wdp.getXiugainichengUiTextView(), "autotest123456789");
		driverExe.assertPage("autotest", "验证[12345678]是否存在");
		driverExe.tapElement(wdp.getGuanbiUiObject(), "点击[修改昵称关闭]");
		//driverExe.tapElement(wdp.getNichengquerenUiObject(), "点击[修改昵称确认]");
		endTest(JDDFUN_GAME, XIU_GAI_NI_CHENG);
	}
	
	@Test
	@MobileTest
	public void ChongZhi() {//充值
		IDriverExe driverExe = startTest(JDDFUN_GAME, CHONG_ZHI, true, "13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		ChongZhiPage czp = new ChongZhiPage();
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getJinyezishuUiObject(), "点击[金叶子数]");
		driverExe.waitPageLoad(5);
		driverExe.tapElementWebView(czp.getChongzhioneUiObject().getLocator(), "点击[充值]按钮1");
		driverExe.tapElementWebView(czp.getChongzhitwoUiObject().getLocator(), "点击[充值]按钮2");
		driverExe.tapElement(czp.getZhifubaozhifuUiObject(), "点击[支付宝支付]按钮");
		driverExe.waitPageLoad(3);
		endTest(JDDFUN_GAME, CHONG_ZHI);
	}
	
	@Test
	@MobileTest
	public void ZiJinMingXi() {//资金明细
		IDriverExe driverExe = startTest(JDDFUN_GAME, ZI_JIN_MING_XI, true, "13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		ZiJinMingXiPage zjmx = new ZiJinMingXiPage();
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getZijinmingxiUiObject(), "点击[资金明细]");
		driverExe.tapElement(zjmx.getChongzhijiluUiObject(), "点击[充值记录]");
		driverExe.tapElement(zjmx.getJinyezijiluUiObject(), "点击[金叶子记录]");
		driverExe.tapElement(zjmx.getRiliUiObject(), "点击[日历]");
		driverExe.waitPageLoad(3);
		endTest(JDDFUN_GAME, ZI_JIN_MING_XI);
	}
	
	@Test
	@MobileTest
	public void XiaoXiZhongXin() {//消息中心
		IDriverExe driverExe = startTest(JDDFUN_GAME, XIAO_XI_ZHONG_XIN, true, "13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.tapElement(yxdtp.getXiaoxizhongxinUiObject(), "点击[消息中心]按钮");
		driverExe.tapElement(cdp.getFanhuiUiObject(), "点击[返回]");
		endTest(JDDFUN_GAME, XIAO_XI_ZHONG_XIN);
	}
	
	@Test
	@MobileTest
	public void WoDeFuLi() {//我的福利
		IDriverExe driverExe = startTest(JDDFUN_GAME, WO_DE_FU_LI, true, "13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDeFuLiPage wdp = new WoDeFuLiPage();
		driverExe.tapElement(cdp.getLingjiangtaiUiObject(), "点击[领奖台]标签页");
		if(driverExe.isTextInPage("京东卡") || driverExe.isTextInPage("话费券")){
			driverExe.tapElement(wdp.getHechengUiObject(), "点击[合成]");
			driverExe.waitPageLoad(3);
			driverExe.log("查看碎片记录", true);
			int screenX = driverExe.getWindowWidth();
			int screenY = driverExe.getWindowHeight();
			driverExe.swipePoint(screenX * 5 / 6, screenY * 3 / 4, screenX * 1 / 6, screenY * 3 / 4);
			driverExe.tapElement(wdp.getLingquUiObject(), "点击[领取]");
			driverExe.log("查看实物记录", true);
		}
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, WO_DE_FU_LI);
	}
	
	@Test
	@MobileTest
	public void KeFu() {//客服
		IDriverExe driverExe = startTest(JDDFUN_GAME, KE_FU, true, "13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		KeFuPage kf = new KeFuPage();
		driverExe.tapElement(cdp.getWodeUiObject(), "点击[我的]标签页");
		driverExe.tapElement(wdp.getKefuUiObject(), "点击[客服]");
		driverExe.waitPageLoad(2);
		driverExe.assertPage("为您服务", "验证[微竞猜客服]是否连接成功");
		driverExe.appendTextField(kf.getXiaoxikuangUiTextView(), "自动化测试，请忽略！");
		driverExe.tapElement(kf.getFasongxiaoxiUiObject(), "发送消息");
		driverExe.waitPageLoad(2);
		driverExe.tapElement(kf.getFanhuiUiObject(), "返回");
		driverExe.waitPageLoad(1);
		endTest(JDDFUN_GAME, KE_FU);
	}
	
	@Test
	@MobileTest
	public void ShouHuoXinXi() {//收货信息
		IDriverExe driverExe = startTest(JDDFUN_GAME, SHOU_HUO_XIN_XI, true, "13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		ShouHuoXinXiPage shxx = new ShouHuoXinXiPage();
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
		endTest(JDDFUN_GAME, SHOU_HUO_XIN_XI);
	}
	
	@Test
	@MobileTest
	public void SheZhi() {//设置
		IDriverExe driverExe = startTest(JDDFUN_GAME, SHE_ZHI, true, "13151815253", "zhouzhou");
		CaiDanPage cdp = new CaiDanPage();
		WoDePage wdp = new WoDePage();
		SheZhiPage szp = new SheZhiPage();
		TongZhiZhongXinPage tzzx = new TongZhiZhongXinPage();
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
		driverExe.tapElementWebView(szp.getGuanyupaihangUiObject().getLocator(), "点击[关于排行]");
		driverExe.tapElementWebView(szp.getGuanyulingjiangtaiUiObject().getLocator(), "点击[关于领奖台]");
		driverExe.tapElementWebView(szp.getGuanyushangchengUiObject().getLocator(), "点击[关于商城]");
		driverExe.tapElementWebView(szp.getGuanyujinyeziUiObject().getLocator(), "点击[关于金叶子]");
		driverExe.tapElementWebView(szp.getQiandaorenwuUiObject().getLocator(), "点击[签到&任务]");
		driverExe.tapElementWebView(szp.getGuanyufenxiangUiObject().getLocator(), "点击[关于分享]");
		driverExe.tapElementWebView(szp.getKefuxiangguanUiObject().getLocator(), "点击[客服相关]");
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
		endTest(JDDFUN_GAME, SHE_ZHI);
	}
	
	@Test
	@MobileTest
	public void LiJiZhuCe() {//立即注册
		IDriverExe driverExe = startTest(JDDFUN_GAME, LI_JI_ZHU_CE, false);
		zhuCe(driverExe);
		endTest(JDDFUN_GAME, LI_JI_ZHU_CE);
	}
	
	@Test
	@MobileTest
	public void YouKeZhuCe() {//游客注册
		IDriverExe driverExe = startTest(JDDFUN_GAME, YOU_KE_ZHU_CE, true);
		YouXiDaTingPage yxdtp = new YouXiDaTingPage();
		driverExe.tapElement(yxdtp.getDianjidengluUiObject(), "点击[点击登录]");
		zhuCe(driverExe);
		endTest(JDDFUN_GAME, YOU_KE_ZHU_CE);
	}
	
	private void zhuCe(IDriverExe driverExe) {
		DengLuPage dlp = new DengLuPage();
		ZhuCePage zcp = new ZhuCePage();
		driverExe.tapElement(dlp.getLijizhuceUiObject(), "点击[立即注册]");
		driverExe.appendTextField(zcp.getShoujihaomaUiTextView(), "123456");
		driverExe.appendTextField(zcp.getYanzhengmaUiTextView(), "123456");
		driverExe.appendTextField(zcp.getShezhimimaUiTextView(), "123456");
		driverExe.appendTextField(zcp.getQuerenmimaUiTextView(), "123456");
		driverExe.tapElement(zcp.getQuerenUiObject(), "点击[确认]按钮");
		driverExe.log("验证提示信息[请输入正确的手机号码]", true);
		driverExe.appendTextField(zcp.getShoujihaomaUiTextView(), "13123456789");
		driverExe.tapElement(zcp.getFasongyanzhengmaUiObject(), "点击[发送验证码]按钮");
		driverExe.log("验证提示信息[验证码已发送]", true);
		driverExe.tapElement(zcp.getQuerenUiObject(), "点击[确认]按钮");
		driverExe.log("验证提示信息[验证码不正确]", true);
		driverExe.clearTextField(zcp.getShoujihaomaUiTextView());
		driverExe.log("验证禁用[确认]按钮", true);
		driverExe.appendTextField(zcp.getShoujihaomaUiTextView(), "13151815253");
		driverExe.tapElement(zcp.getQuerenUiObject(), "点击[确认]按钮");
		driverExe.log("验证提示信息[该手机号已被注册]", true);
		driverExe.waitPageLoad(1);
	}

}
