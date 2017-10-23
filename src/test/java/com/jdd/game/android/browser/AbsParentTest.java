package com.jdd.game.android.browser;

import com.jdd.game.android.driver.BrowserDriver;
import com.jdd.game.android.driver.IWapDriverExe;

public abstract class AbsParentTest extends BrowserDriver{
	private static final Integer WAIT_LOAD_GAME		= 5;
	protected static final String OKOOO_VERSION		= "1121";
	protected static final String OKOOO_IP			= "10.33.85.181";
	protected static final String OKOOO_LOGIN		= "http://" + OKOOO_IP + "/channel/newokooo/home/" + OKOOO_VERSION + "/#/loginPop";
	protected static final String OKOOO_TOKEN		= "http://" + OKOOO_IP + "/channel/newokooo/home/?token=%s&type=jdd&status=bind#/";
	protected static final String OKOOO_YOU_XI		= "http://" + OKOOO_IP + "/channel/newokooo/home/" + OKOOO_VERSION + "/#/";
	protected static final String OKOOO_BEI_BAO		= "http://" + OKOOO_IP + "/channel/newokooo/home/" + OKOOO_VERSION + "/#/knapsack";
	protected static final String OKOOO_CHOU_JIANG	= "http://" + OKOOO_IP + "/channel/newokooo/home/" + OKOOO_VERSION + "/#/luckdraw";
	protected static final String OKOOO_GE_REN		= "http://" + OKOOO_IP + "/channel/newokooo/home/" + OKOOO_VERSION + "/#/personal";

	protected IWapDriverExe startTest(String testName, String caseName) {
		return this.startTest(testName, caseName, false, null, 0);
	}
	
	protected IWapDriverExe startTest(String testName, String caseName, Integer page) {
		return this.startTest(testName, caseName, true, null, page);
	}
	
	protected IWapDriverExe startTest(String testName, String caseName, String token, Integer page) {
		return this.startTest(testName, caseName, true, token, page);
	}
	
	protected IWapDriverExe startTest(String testName, String caseName, Boolean login, String token, Integer page) {
		IWapDriverExe driverExe = runBrowserDriverExe();
		driverExe.waitPageLoad(1);
		driverExe.log("测试输出:《" + testName + "-【" + caseName + "】》测试开始！");
		driverExe.open(OKOOO_LOGIN);
		if(login){
			if(token == null || token.isEmpty()){
				driverExe.click("//*[@id='router-content']/div/div/p[2]", "快速试玩");
			}else{
				driverExe.open(String.format(OKOOO_TOKEN, token));
			}
			waitLoadGame();
			openPage(page);
		}
		return driverExe;
	}
	
	private void waitLoadGame() {
		IWapDriverExe driverExe = getBrowserDriverExe();
		for (int i = 0; i < WAIT_LOAD_GAME; i++) {
			driverExe.waitPageLoad(1);
			if(driverExe.isTextInPage("GameCanvas")){
				driverExe.waitPageLoad(2);
			}
		}
	}
	
	private void openPage(Integer page){
		IWapDriverExe driverExe = getBrowserDriverExe();
		if(page == 1){
			openYouXi();
			driverExe.foundClick("//*[@id='router-content']/div/div[6]/div[2]/a/img", "活动[金桂飘香]关闭");
			driverExe.foundClick("//*[@id='router-content']/div/div[4]/div/div[2]/p[1]", "活动[首次充值]关闭");
		}else if(page == 2){
			openBeiBao();
		}else if(page == 3){
			openChouJiang();
		}else if(page == 4){
			openGeRen();
		}
	}
	
	protected void endTest(String testName, String caseName) {
		IWapDriverExe driverExe = getBrowserDriverExe();
		driverExe.waitPageLoad(1);
		driverExe.log("测试输出:《" + testName + "-【" + caseName + "】》测试结束！");
		driverExe.close();
		driverExe.quit();
	}
	
	private void openYouXi() {
		IWapDriverExe driverExe = getBrowserDriverExe();
		driverExe.open(OKOOO_YOU_XI);
	}
	
	private void openBeiBao() {
		IWapDriverExe driverExe = getBrowserDriverExe();
		driverExe.open(OKOOO_BEI_BAO);
	}
	
	private void openChouJiang() {
		IWapDriverExe driverExe = getBrowserDriverExe();
		driverExe.open(OKOOO_CHOU_JIANG);
	}
	
	private void openGeRen() {
		IWapDriverExe driverExe = getBrowserDriverExe();
		driverExe.open(OKOOO_GE_REN);
	}

}
