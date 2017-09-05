package com.jdd.game.android.driver.impl;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.exception.AutoException;
import com.jdd.game.android.utils.DateUtil;
import com.jdd.game.android.utils.PageUtil;
import com.jdd.game.android.utils.SleepUtil;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.grid.SeLionAppiumAndroidDriver;
import com.paypal.selion.platform.mobile.android.UiObject;
import com.paypal.selion.platform.mobile.android.UiTextView;
import com.paypal.selion.reports.runtime.SeLionReporter;

public class AndroidDriverExe implements IDriverExe {

	private RemoteWebDriver rwd = null;
	private long startTime = 0;
	
	public void setRwd(RemoteWebDriver rwd) {
		this.rwd = rwd;
	}

	public AndroidDriverExe(){
		super();
	}
	
	public SeLionAppiumAndroidDriver getAndroidDriver() {
		if(this.rwd == null){
			throw new AutoException("驱动异常:《请检查!》");
		}
		return (SeLionAppiumAndroidDriver) this.rwd;
	}
	
	public void driverApp(){
		setRwd(Grid.driver());
		PageUtil.waitTillActivity(this.rwd);
	}
	
	@Override
	public void back() {
		this.getAndroidDriver().navigate().back();
		this.log("测试输出:《已返回!》");
		this.waitPageLoad(1);
	}

	@Override
	public void forward() {
		this.getAndroidDriver().navigate().forward();
		this.log("测试输出:《已前进!》");
		this.waitPageLoad(1);
	}

	@Override
	public void refresh() {
		this.getAndroidDriver().navigate().refresh();
		this.log("测试输出:《已刷新!》");
		this.waitPageLoad(1);
	}
	
	@Override
	public void waitPageLoad(long s) {
		SleepUtil.sleep(s * 1000);
	}
	
	@Override
	public void swipePoint(int startx, int starty, int endx, int endy) {
		this.waitPageLoad(2);
		this.getAndroidDriver().swipe(startx, starty, endx, endy, 500);
		this.log("测试输出:《坐标(" + startx + "," + starty + ")-(" + endx + "," + endy + ")》已滑动!");
	}

	@Override
	public void swipeDirection(String direction, int num) {
		int screenX = this.getWindowWidth();
		int screenY = this.getWindowHeight();
		this.waitPageLoad(2);
		for (int i = 0; i < (num < 1 ? 1 : num); i++) {
			if (direction.equalsIgnoreCase(Const.SWIPE_DIRECTION_UP)){
				this.getAndroidDriver().swipe(screenX/2, screenY*3/4, screenX/2, screenY/4, 500);
				if(num == i - 1){
					this.log("测试输出:《屏幕(" + screenX + "," + screenY + ")向上已滑动 " + num + " 次!》");
				}
			} else if (direction.equalsIgnoreCase(Const.SWIPE_DIRECTION_DOWN)){
				this.getAndroidDriver().swipe(screenX/2, screenY/4, screenX/2, screenY*3/4, 500);
				if(num == i - 1){
					this.log("测试输出:《屏幕(" + screenX + "," + screenY + ")向下已滑动 " + num + " 次!》");
				}
			} else if(direction.equalsIgnoreCase(Const.SWIPE_DIRECTION_LEFT)){
				this.getAndroidDriver().swipe(screenX*4/5, screenY/2, screenX/5, screenY/2, 500);
				if(num == i - 1){
					this.log("测试输出:《屏幕(" + screenX + "," + screenY + ")向左已滑动 " + num + " 次!》");
				}
			} else if(direction.equalsIgnoreCase(Const.SWIPE_DIRECTION_RIGHT)){
				this.getAndroidDriver().swipe(screenX/5, screenY/2, screenX*4/5, screenY/2, 500);
				if(num == i - 1){
					this.log("测试输出:《屏幕(" + screenX + "," + screenY + ")向右已滑动 " + num + " 次!》");
				}
			} else {
				this.log("测试输出:《请选择正确的滑动方向!》");
			}
			this.waitPageLoad(2);
		}
	}
	
	@Override
	public void tapPoint(int x, int y) {
		this.waitPageLoad(2);
		this.getAndroidDriver().tap(1, x, y, 100);
		this.log("测试输出:《坐标(" + x + "," + y + ")》已点击!");
	}

	@Override
	public void tapElement(UiObject ub, String message) {
		if(PageUtil.isElementPresent(getAndroidDriver(), ub, message)){
			ub.tap();
			this.log("测试输出:《" + message + "》已点击!");
		}
	}
	
	@Override
	public void foundTapElement(UiObject ub, String message) {
		this.tapElementByXpath(ub.getLocator(), message);
	}
	
	@Override
	public void tapElementByXpath(String xpath, String message) {
		List<WebElement> list = this.getWebElements(Const.TYPE_XPATH, xpath);
		if(list != null && !list.isEmpty()){
			list.get(0).click();
			this.log("测试输出:《" + message + "》已点击!");
		}
	}
	
	@Override
	public void tapElementByID(String id, String message) {
		List<WebElement> list = this.getWebElements(Const.TYPE_ID, id);
		if(list != null && !list.isEmpty()){
			list.get(0).click();
			this.log("测试输出:《" + message + "》已点击!");
		}
	}
	
	@Override
	public void tapElementByName(String name, String message) {
		if(PageUtil.isElementPresent(getAndroidDriver(), name, message)){
			this.getWebElements(Const.TYPE_NAME, name).get(0).click();
			this.log("测试输出:《" + message + "》已点击!");
		}
	}
	
	@Override
	public void tapElementsByName(String name, String message) {
		if(PageUtil.isElementPresent(getAndroidDriver(), name, message)){
			List<WebElement> list = this.getWebElements(Const.TYPE_NAME, name);
			if(list != null && !list.isEmpty()){
				for (int i = 0; i < list.size(); i++) {
					list.get(i).click();
				}
				this.log("测试输出:《" + message + "》已点击!");
			}
		}
	}

	@Override
	public void appendTextField(UiTextView utv, String text) {
		utv.sendKeys(text);
		this.log("测试输出:《文本(" + text + ")》已追加!");
	}

	@Override
	public void clear2SetTextField(UiTextView utv, String text) {
		this.clearTextField(utv);
		utv.sendKeys(text);
		this.log("测试输出:《文本(" + text + ")》已替换!");
	}
	
	@Override
	public void clearTextField(UiTextView utv) {
		String val = utv.getValue();
		if(val != null && val.length() > 0){
			this.getWebElement(Const.TYPE_XPATH, utv.getLocator()).clear();
			this.log("测试输出:《文本(" + val + ")》已清除!");
		}
	}

	@Override
	public boolean isTextInPage(String text) {
		this.waitPageLoad(1);
		return this.getAndroidDriver().getPageSource().indexOf(text) != -1;
	}
	
	@Override
	public boolean compareTextInPage(String textA, String textB){
		int a = this.getAndroidDriver().getPageSource().indexOf(textA);
		int b = this.getAndroidDriver().getPageSource().indexOf(textB);
		if(a == -1 || b == -1){
			return false;
		}
		return a > b ? true : false;
	}
	
	@Override
	public void tapSpecifyDateElement(String dateStr, String message) {
		if(PageUtil.isElementPresent(getAndroidDriver(), dateStr, message)){
			this.getWebElement(Const.TYPE_NAME, dateStr).click();
			this.log("测试输出:《" + message + "》已点击!");
		}
	}
	
	@Override
	public void tapSpecifyDateElement(int num, String message) {
		String date = DateUtil.getSpecifyDate((num < 1)?1:num);
		if(PageUtil.isElementPresent(getAndroidDriver(), date, message)){
			this.getWebElement(Const.TYPE_NAME, date).click();
			this.log("测试输出:《" + message + "-" + date + "》已点击!");
		}
	}
	
	@Override
	public void tapCurrentDateElement(String message) {
		String date = DateUtil.getCurrentDate();
		if(PageUtil.isElementPresent(getAndroidDriver(), date, message)){
			this.getWebElement(Const.TYPE_NAME, date).click();
			this.log("测试输出:《" + message + "-" + date + "》已点击!");
		}
	}
	
	@Override
	public void tapRandomDateElement(int num, String message) {
		String date = DateUtil.getRandomDate((num < 1)?1:num);
		if(PageUtil.isElementPresent(getAndroidDriver(), date, message)){
			this.getWebElement(Const.TYPE_NAME, date).click();
			this.log("测试输出:《" + message + "-" + date + "》已点击!");
		}
	}
	
	@Override
	public String tapAutoDateElement(String message) {
		for (int i = 1; i <= 31; i++) {
			String date = DateUtil.getSpecifyDate(i);
			if(PageUtil.isElementPresent(getAndroidDriver(), date, date)){
				List<WebElement> list = this.getWebElements(Const.TYPE_NAME, date);
				if(list != null && !list.isEmpty()){
					if(list.get(list.size() - 1).isEnabled()){
						list.get(list.size() - 1).click();
						this.waitPageLoad(1);
						if(this.isTextInPage("订单填写")){
							this.log("测试输出:《" + message + "-" + date + "》已点击并且生效!");
							return DateUtil.getSpecifyDate(i, "MM-dd");
						}else{
							this.log("测试输出:《" + message + "-" + date + "》已点击但未生效!");
						}
					}
				}
			}
		}
		return "";
	}

	@Override
	public void log(String message){
		if(StringUtils.isNotBlank(message) && message.contains("测试开始")){
			startTime = System.currentTimeMillis();
			System.out.println(message);
			SeLionReporter.log(message, false);
		}else if(StringUtils.isNotBlank(message) && message.contains("测试结束")){
			startTime = 0;
			System.out.println(message);
			SeLionReporter.log(message, false);
		}else{
			String timeStr = DateUtil.subTime(System.currentTimeMillis() - startTime);
			System.out.println(message + "--[耗时:" + timeStr +"]");
			SeLionReporter.log(message + "--[耗时:" + timeStr +"]", false);
			startTime = System.currentTimeMillis();
		}
	}

	@Override
	public void log(String message, boolean bool) {
		System.out.println(message);
		SeLionReporter.log(message, bool);
	}

	@Override
	public void assertPage(String text, String message) {
		boolean bool = this.isTextInPage(text);
		log("测试输出:" + message + "[" + bool + "]", false);
		Assert.assertEquals(true, bool, message);
	}
	
	@Override
	public void assertElement(UiObject ub, String message) {
		boolean bool = this.getWebElements(Const.TYPE_XPATH, ub.getLocator()) != null;
		log("测试输出:" + message + "[" + bool + "]", false);
		Assert.assertEquals(true, bool, message);
	}
	
	@Override
	public int getIndexXpath(String xpath) {
		int index = 0;
		if("[".equals(xpath.substring(xpath.length() - 3, xpath.length() - 2))){
			index = Integer.parseInt(xpath.substring(xpath.length()-2, xpath.length()-1));
		}else if("[".equals(xpath.substring(xpath.length() - 4, xpath.length() - 3))){
			index = Integer.parseInt(xpath.substring(xpath.length()-3, xpath.length()-1));
		}
		return index;
	}
	
	@Override
	public String setIndexXpath(String xpath, int index) {
		String newCyrqXpath = "";
		if("[".equals(xpath.substring(xpath.length() - 3, xpath.length() - 2))){
			newCyrqXpath = xpath.substring(0, xpath.length() - 2) + index + "]";
		}else if("[".equals(xpath.substring(xpath.length() - 4, xpath.length() - 3))){
			newCyrqXpath = xpath.substring(0, xpath.length() - 3) + index + "]";
		}
		return newCyrqXpath;
	}
	
	@Override
	public WebElement getWebElement(String type, String text) {
		if(Const.TYPE_XPATH.equalsIgnoreCase(type)){
			return this.getAndroidDriver().findElementByXPath(text);
		}else if(Const.TYPE_ID.equalsIgnoreCase(type)){
			return this.getAndroidDriver().findElementById(text);
		}else if(Const.TYPE_NAME.equalsIgnoreCase(type)){
			return this.getAndroidDriver().findElementByName(text);
		}else{
			return null;
		}
	}
	
	@Override
	public List<WebElement> getWebElements(String type, String text) {
		if(Const.TYPE_XPATH.equalsIgnoreCase(type)){
			return this.getAndroidDriver().findElementsByXPath(text);
		}else if(Const.TYPE_ID.equalsIgnoreCase(type)){
			return this.getAndroidDriver().findElementsById(text);
		}else if(Const.TYPE_NAME.equalsIgnoreCase(type)){
			return this.getAndroidDriver().findElementsByName(text);
		}else{
			return null;
		}
	}
	
	@Override
	public String getNameByXpath(String xpath){
		String str = this.getWebElement(Const.TYPE_XPATH, xpath).getAttribute("name");
		return (str == null) ? "" : str;
	}
	
	@Override
	public Integer getWindowWidth() {
		return this.getAndroidDriver().manage().window().getSize().width;
	}

	@Override
	public Integer getWindowHeight() {
		return this.getAndroidDriver().manage().window().getSize().height;
	}
	
	@Override
	public void context(String name) {
		this.getAndroidDriver().context(name);
	}

	@Override
	public void closeApp() {
		this.getAndroidDriver().closeApp();
	}

	@Override
	public void launchApp() {
		this.getAndroidDriver().launchApp();
	}

	@Override
	public void resetApp() {
		this.getAndroidDriver().resetApp();
	}

	@Override
	public void quitApp() {
		this.getAndroidDriver().quit();
	}

}
