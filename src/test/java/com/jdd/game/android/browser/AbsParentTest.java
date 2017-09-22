package com.jdd.game.android.browser;

import com.jdd.game.android.driver.BrowserDriver;
import com.jdd.game.android.driver.IWapDriverExe;

public abstract class AbsParentTest extends BrowserDriver{
	protected static final String OKOOO_LOGIN		= "http://192.168.101.181/channel/newokooo/home/1102/#/loginPop";
	protected static final String OKOOO_TOKEN		= "http://192.168.101.181/channel/newokooo/home/1102/?token=%s&type=jdd&status=login#/";
	protected static final String OKOOO_YOU_XI		= "http://192.168.101.181/channel/newokooo/home/1102/#/";
	protected static final String OKOOO_BEI_BAO		= "http://192.168.101.181/channel/newokooo/home/1102/#/knapsack";
	protected static final String OKOOO_CHOU_JIANG	= "http://192.168.101.181/channel/newokooo/home/1102/#/luckdraw";
	protected static final String OKOOO_GE_REN		= "http://192.168.101.181/channel/newokooo/home/1102/#/personal";

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
			driverExe.waitPageLoad(3);
			if(page == 1){
				openYouXi();
			}else if(page == 2){
				openBeiBao();
			}else if(page == 3){
				openChouJiang();
			}else if(page == 4){
				openGeRen();
			}
		}
		return driverExe;
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
