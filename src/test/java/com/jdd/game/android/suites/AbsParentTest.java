package com.jdd.game.android.suites;

import com.jdd.game.android.driver.AppDriver;
import com.jdd.game.android.driver.IAppDriverExe;
import com.jdd.game.android.utils.AdbUtil;
import com.jdd.pages.CaiDanPage;
import com.jdd.pages.DengLuPage;

public abstract class AbsParentTest extends AppDriver{
	private static final Integer WAIT_HOME_PAGE_DIALOG		= 3;
	
	/**
	 * 开始测试用例
	 * @param testName (测试集名称)
	 * @param caseName (案例名称)
	 * @param page (0:主页;1:游戏大厅;2:领奖台;3:我的;4:分享圈;)
	 * @param login (是否登录)
	 * @return
	 */
	protected IAppDriverExe startTest(String testName, String caseName, Integer page, boolean login) {
		return startTest(testName, caseName, page, login, null, null);
	}
	
	/**
	 * 开始测试用例
	 * @param testName (测试集名称)
	 * @param caseName (案例名称)
	 * @param page (0:主页;1:游戏大厅;2:领奖台;3:我的;4:分享圈;)
	 * @param login (是否登录)
	 * @param username (用户名)
	 * @param password (密码)
	 * @return
	 */
	protected IAppDriverExe startTest(String testName, String caseName, Integer page, boolean login, String username, String password) {
		IAppDriverExe driverExe = runAndroidDriverExe();
		driverExe.waitPageLoad(1);
		driverExe.log("测试输出:《" + testName + "-【" + caseName + "】》测试开始！");
		if(login){
			if(isEmpty(username) || isEmpty(password)){
				shiWan();
			}else{
				login(username, password);
			}
			driverExe.waitPageLoad(1);
		}
		if(page == 1){
			openYouXiDaTing();
		}else if(page == 2){
			openLingJiangTai();
		}else if(page == 3){
			openWoDe();
		}else if(page == 4){
			openFenXiangQuan();
		}
		return driverExe;
	}
	
	protected void endTest(String testName, String caseName) {
		IAppDriverExe driverExe = getAndroidDriverExe();
		driverExe.waitPageLoad(1);
		driverExe.log("测试输出:《" + testName + "-【" + caseName + "】》测试结束！");
		driverExe.closeApp();
		driverExe.quitApp();
	}
	
	private void login(String username, String password) {
		IAppDriverExe driverExe = getAndroidDriverExe();
		DengLuPage dlp = new DengLuPage();
		driverExe.tapElement(dlp.getShoujidengluUiObject(), "手机登录");
		driverExe.appendTextField(dlp.getShoujihaomaUiTextView(), username);
		driverExe.appendTextField(dlp.getMimaUiTextView(), password);
		driverExe.tapElement(dlp.getDengluUiObject(), "登录确认");
		if(waitCloseDialog()){
			closeDialog();
		}
	}
	
	private void shiWan() {
		IAppDriverExe driverExe = getAndroidDriverExe();
		DengLuPage dlp = new DengLuPage();
		driverExe.tapElement(dlp.getYoukeshiwanUiObject(), "游客试玩");
		if(waitCloseDialog()){
			closeDialog();
		}
	}
	
	private boolean waitCloseDialog() {
		IAppDriverExe driverExe = getAndroidDriverExe();
		for (int i = 0; i < WAIT_HOME_PAGE_DIALOG; i++) {
			driverExe.waitPageLoad(1);
			if(driverExe.isTextInPage("每日签到") && driverExe.isTextInPage("敬请期待")){
				return true;
			}
		}
		return false;
	}
	
	private void closeDialog() {
		IAppDriverExe driverExe = getAndroidDriverExe();
		CaiDanPage cdp = new CaiDanPage();
		driverExe.tapElement(cdp.getLijichoujiangUiObject(), "立即抽奖");
		driverExe.foundTapElement(cdp.getHuodongguanbiUiObject(), "活动关闭");
		if(driverExe.isTextInPage("去赢钱")) {
			driverExe.foundTapElement(cdp.getQiyingqianUiObject(), "去赢钱");
			//driverExe.keyboardClick(4);
		}
		driverExe.waitPageLoad(3);
	}
	
	private boolean isEmpty(String text){
		if(text == null || text.isEmpty()){
			return true;
		}
		return false;
	}
	
	protected void openYouXiDaTing() {
		IAppDriverExe driverExe = getAndroidDriverExe();
		CaiDanPage cdp = new CaiDanPage();
		driverExe.tapElement(cdp.getYouxidatingUiObject(), "游戏大厅");
		if(!driverExe.isTextInPage("下级奖励")){
			driverExe.waitPageLoad(1);
			driverExe.tapElement(cdp.getYouxidatingUiObject(), "游戏大厅");
		}
	}
	
	protected void openLingJiangTai() {
		IAppDriverExe driverExe = getAndroidDriverExe();
		CaiDanPage cdp = new CaiDanPage();
		driverExe.tapElement(cdp.getLingjiangtaiUiObject(), "领奖台");
		if(!driverExe.isTextInPage("我的碎片合集")){
			driverExe.waitPageLoad(1);
			driverExe.tapElement(cdp.getLingjiangtaiUiObject(), "领奖台");
		}
	}
	
	protected void openWoDe() {
		IAppDriverExe driverExe = getAndroidDriverExe();
		CaiDanPage cdp = new CaiDanPage();
		//driverExe.swipeDirection(Const.SWIPE_DIRECTION_UP, 0.1, 1);
		driverExe.tapElement(cdp.getWodeUiObject(), "我的");
		if(!driverExe.isTextInPage("ID | ")){
			driverExe.waitPageLoad(1);
			driverExe.tapElement(cdp.getWodeUiObject(), "我的");
		}
	}
	
	protected void openFenXiangQuan(){
		IAppDriverExe driverExe = getAndroidDriverExe();
		driverExe.assertPage("大神分享", "验证[大神分享]是否存在");
		driverExe.assertPage("查看更多", "验证[查看更多]是否存在");
		AdbUtil.openPage(AdbUtil.ACTIVITY_FENXIANGQUAN);
		driverExe.waitPageLoad(1);
	}
	
	protected void back() {
		IAppDriverExe driverExe = getAndroidDriverExe();
		driverExe.tapElement(new CaiDanPage().getFanhuiUiObject(), "返回");
		driverExe.waitPageLoad(1);
	}
	
}
