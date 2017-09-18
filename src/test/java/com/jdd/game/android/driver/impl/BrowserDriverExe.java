package com.jdd.game.android.driver.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IDriverExe;
import com.jdd.game.android.exception.AutoException;
import com.jdd.game.android.utils.DateUtil;
import com.jdd.game.android.utils.PageUtil;
import com.jdd.game.android.utils.SleepUtil;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.mobile.android.UiObject;
import com.paypal.selion.platform.mobile.android.UiTextView;
import com.paypal.selion.reports.runtime.SeLionReporter;

public class BrowserDriverExe implements IDriverExe {

	private RemoteWebDriver rwd = null;
	private long startTime = 0;
	
	public void setRwd(RemoteWebDriver rwd) {
		this.rwd = rwd;
	}

	public BrowserDriverExe(){
		super();
	}
	
	public RemoteWebDriver getBrowserDriver() {
		if(this.rwd == null){
			throw new AutoException("驱动异常:《请检查!》");
		}
		return (RemoteWebDriver) this.rwd;
	}
	
	public void driverBrowser(){
		setRwd(Grid.driver());
		PageUtil.waitTillActivity2(this.rwd);
	}
	
	@Override
	public void driverApp(){
	}

	@Override
	public void back() {
	}

	@Override
	public void forward() {
	}

	@Override
	public void refresh() {
	}

	@Override
	public void waitPageLoad(long s) {
		SleepUtil.sleep(s);
	}

	@Override
	public void swipePoint(int startx, int starty, int endx, int endy) {
	}

	@Override
	public void swipeDirection(String direction, int num) {
	}

	@Override
	public void swipeDirection(String direction, double per, int num) {
	}

	@Override
	public void tapPoint(int x, int y) {
	}

	@Override
	public void tapElement(UiObject ub, String message) {
	}

	@Override
	public void foundTapElement(UiObject ub, String message) {
	}

	@Override
	public void tapElementWebView(String xpath, String message) {
	}

	@Override
	public void tapElementByXpath(String xpath, String message) {
	}

	@Override
	public void tapElementByXpath(String xpath, Integer index, String message) {
	}

	@Override
	public void tapElementByID(String name, String message) {
	}

	@Override
	public void tapElementByName(String name, String message) {
	}

	@Override
	public void tapElementsByName(String name, String message) {
	}

	@Override
	public void appendTextField(UiTextView utv, String text) {
	}

	@Override
	public void clear2SetTextField(UiTextView utv, String text) {
	}

	@Override
	public void clearTextField(UiTextView utv) {
	}

	@Override
	public boolean isTextInPage(String text) {
		return false;
	}

	@Override
	public boolean compareTextInPage(String textA, String textB) {
		return false;
	}

	@Override
	public void tapSpecifyDateElement(String dateStr, String message) {
	}

	@Override
	public void tapSpecifyDateElement(int num, String message) {
	}

	@Override
	public void tapCurrentDateElement(String message) {
	}

	@Override
	public void tapRandomDateElement(int num, String message) {
	}

	@Override
	public String tapAutoDateElement(String message) {
		return null;
	}

	@Override
	public void log(String message) {
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
	public void logOut(String message, boolean bool) {
		log("测试输出:《" + message + "》", bool);
	}

	@Override
	public void assertElement(UiObject ub, String message) {
	}

	@Override
	public void assertPage(String text) {
	}

	@Override
	public void assertPage(String text, String message) {
	}

	@Override
	public int getIndexXpath(String xpath) {
		return 0;
	}

	@Override
	public String setIndexXpath(String xpath, int i) {
		return null;
	}

	@Override
	public WebElement getWebElement(String type, String text) {
		return null;
	}

	@Override
	public List<WebElement> getWebElements(String type, String text) {
		return null;
	}

	@Override
	public String getNameByXpath(String xpath) {
		return null;
	}

	@Override
	public Integer getWindowWidth() {
		return null;
	}

	@Override
	public Integer getWindowHeight() {
		return null;
	}

	@Override
	public void context(String name) {
	}

	@Override
	public void keyboardClick(int key) {
	}

	@Override
	public void closeApp() {
	}

	@Override
	public void launchApp() {
	}

	@Override
	public void resetApp() {
	}

	@Override
	public void quitApp() {
	}
	
	/**
	 * PC
	 */
	@Override
	public void open(String url) {
		this.getBrowserDriver().get(url);
		this.log("测试输出:《" + url + "》已打开!");
	}
	
	@Override
	public void click(String type, String locator) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
				driver.findElement(By.id(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				driver.findElement(By.name(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				driver.findElement(By.className(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				driver.findElement(By.xpath(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				driver.findElement(By.cssSelector(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				driver.findElement(By.linkText(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				driver.findElement(By.tagName(locator)).click();
			}
			this.log("已点击[" + locator + "]");
		}else{
			this.log("未找到[" + locator + "]");
		}
	}

	@Override
	public void foundClick(String type, String locator) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(isElementExist(type, locator)){
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
				driver.findElement(By.id(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				driver.findElement(By.name(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				driver.findElement(By.className(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				driver.findElement(By.xpath(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				driver.findElement(By.cssSelector(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				driver.findElement(By.linkText(locator)).click();
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				driver.findElement(By.tagName(locator)).click();
			}
			this.log("已点击[" + locator + "]");
		}else{
			this.log("未找到[" + locator + "]");
		}
	}

	@Override
	public void clearText(String type, String locator) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
				driver.findElement(By.id(locator)).clear();
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				driver.findElement(By.name(locator)).clear();
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				driver.findElement(By.className(locator)).clear();
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				driver.findElement(By.xpath(locator)).clear();
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				driver.findElement(By.cssSelector(locator)).clear();
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				driver.findElement(By.linkText(locator)).clear();
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				driver.findElement(By.tagName(locator)).clear();
			}
			this.log("清除值[" + locator + "]");
		}
	}

	@Override
	public boolean result(String text) {
		RemoteWebDriver driver = this.getBrowserDriver();
		driver.navigate().refresh();
		boolean bool = (driver.getPageSource().indexOf(text) != -1);
		this.log("结果验证[" + text + ":" + bool + "],Title[" + driver.getTitle() + "]");
		return bool;
	}

	@Override
	public boolean value(String type, String locator, String text) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = null;
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
				e = driver.findElement(By.id(locator));
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				e = driver.findElement(By.name(locator));
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				e = driver.findElement(By.className(locator));
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				e = driver.findElement(By.xpath(locator));
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				e = driver.findElement(By.cssSelector(locator));
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				e = driver.findElement(By.linkText(locator));
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				e = driver.findElement(By.tagName(locator));
			}
			if (e != null && (text.equals(e.getText()) || text.equals(e.getAttribute("value")))) {
				this.log("值验证[" + text + ":true]");
				return true;
			}
			this.log("值验证[" + text + ":false]");
		}
		return false;
	}

	@Override
	public void sendKey(String type, String locator, String text) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = null;
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
				e = driver.findElement(By.id(locator));
				((JavascriptExecutor) driver).executeScript("document.getElementById(\"" + locator +  "\").removeAttribute(\"readOnly\")");
				((JavascriptExecutor) driver).executeScript("document.getElementById(\"" + locator +  "\").value=\"\"");
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				e = driver.findElement(By.name(locator));
				((JavascriptExecutor) driver).executeScript("document.getElementsByName(\"" + locator +  "\").removeAttribute(\"readOnly\")");
				((JavascriptExecutor) driver).executeScript("document.getElementsByName(\"" + locator +  "\").value=\"\"");
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				e = driver.findElement(By.className(locator));
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				e = driver.findElement(By.xpath(locator));
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				e = driver.findElement(By.cssSelector(locator));
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				e = driver.findElement(By.linkText(locator));
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				e = driver.findElement(By.tagName(locator));
				((JavascriptExecutor) driver).executeScript("document.getElementsByTagName(\"" + locator +  "\").removeAttribute(\"readOnly\")");
				((JavascriptExecutor) driver).executeScript("document.getElementsByTagName(\"" + locator +  "\").value=\"\"");
			}
			if(e != null){
				e.click();
				String str = e.getText();
				if (StringUtils.isNotBlank(str)) {
					str = e.getAttribute("value");
				}
				if (StringUtils.isNotBlank(str)) {
					e.clear();
				}
				e.sendKeys(text);
				this.log("设置值[" + text + "]");
			}
		}
	}

	@Override
	public String getElementValue(String type, String locator) {
		RemoteWebDriver driver = this.getBrowserDriver();
		String result = null;
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = null;
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
				e = driver.findElement(By.id(locator));
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				e = driver.findElement(By.name(locator));
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				e = driver.findElement(By.className(locator));
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				e = driver.findElement(By.xpath(locator));
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				e = driver.findElement(By.cssSelector(locator));
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				e = driver.findElement(By.linkText(locator));
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				e = driver.findElement(By.tagName(locator));
			}
			if(e != null){
				result = e.getText();
				if(result == null){
					result = e.getAttribute("value");
				}
			}
		}
		return result;
	}

	@Override
	public void browserClick(String keyName) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(Const.BROWSER_FORWARD.equals(keyName)){
			driver.navigate().forward();
		}else if(Const.BROWSER_BACK.equals(keyName)){
			driver.navigate().back();
		}else if(Const.BROWSER_REFRESH.equals(keyName)){
			driver.navigate().refresh();
		}
	}

	@Override
	public void scroll(String type, String locator) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = null;
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
				e = driver.findElement(By.id(locator));
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				e = driver.findElement(By.name(locator));
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				e = driver.findElement(By.className(locator));
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				e = driver.findElement(By.xpath(locator));
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				e = driver.findElement(By.cssSelector(locator));
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				e = driver.findElement(By.linkText(locator));
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				e = driver.findElement(By.tagName(locator));
			}
			if(e != null){
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", e);
			}
		}
	}

	@Override
	public void scrollTop(String direction) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(Const.PC_SCROLLTOP_TOP.equals(direction)){
			((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=0");
		}else if(Const.PC_SCROLLTOP_BOTTOM.equals(direction)){
			((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=10000");
		}
	}

	@Override
	public void switchToWindow(String windowTitle) {
		try {
			RemoteWebDriver driver = this.getBrowserDriver();
	        String currentHandle = driver.getWindowHandle();
	        Set<String> handles = driver.getWindowHandles();
	        for (String s : handles) {
	            if (s.equals(currentHandle)){
	            	continue;
	            } else {
	                driver.switchTo().window(s);
	                if (driver.getTitle().contains(windowTitle)) {
	                    break;
	                } else {
	                	continue;
	                }
	            }
	        }
	    } catch (NoSuchWindowException e) {
	    	e.printStackTrace();
	    }
	}

	@Override
	public void switchToFrame(String id) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(driver.getPageSource().contains(id)){
			driver.switchTo().frame(id);
		}
	}

	@Override
	public void clickAlertSure() {
		RemoteWebDriver driver = this.getBrowserDriver();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Override
	public void clickAlertDismiss() {
		RemoteWebDriver driver = this.getBrowserDriver();
		Alert alert = driver.switchTo().alert();
        alert.dismiss();
	}

	@Override
	public void clickAndHold(String type, String locator) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = null;
			Actions action = new Actions(driver);
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
				e = driver.findElement(By.id(locator));
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				e = driver.findElement(By.name(locator));
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				e = driver.findElement(By.className(locator));
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				e = driver.findElement(By.xpath(locator));
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				e = driver.findElement(By.cssSelector(locator));
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				e = driver.findElement(By.linkText(locator));
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				e = driver.findElement(By.tagName(locator));
			}
			if(e != null){
				action.moveToElement(e).perform();
			}
		}
	}

	@Override
	public void selectByValue(String type, String locator, String text) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = null;
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
				e = driver.findElement(By.id(locator));
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				e = driver.findElement(By.name(locator));
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				e = driver.findElement(By.className(locator));
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				e = driver.findElement(By.xpath(locator));
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				e = driver.findElement(By.cssSelector(locator));
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				e = driver.findElement(By.linkText(locator));
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				e = driver.findElement(By.tagName(locator));
			}
			if(e != null){
				if("select".equalsIgnoreCase(e.getTagName().trim())){
					Select select = new Select(e);
					select.selectByValue(text);
				}else{
					e.sendKeys(text);
				}
			}
		}
	}
	
	private boolean isElementExist(String type, String locator){
		RemoteWebDriver driver = this.getBrowserDriver();
		int index = 0;
		while (index < 1) {
			List<?> list = null;
			if (Const.LOCATIONTYPE_PC_ID.equals(type)) {
        		list = driver.findElements(By.id(locator));
			}else if (Const.LOCATIONTYPE_PC_NAME.equals(type)) {
				list = driver.findElements(By.name(locator));
			}else if (Const.LOCATIONTYPE_PC_CLASS.equals(type)) {
				list = driver.findElements(By.className(locator));
			}else if (Const.LOCATIONTYPE_PC_XPATH.equals(type)) {
				list = driver.findElements(By.xpath(locator));
			}else if (Const.LOCATIONTYPE_PC_CSS.equals(type)) {
				list = driver.findElements(By.cssSelector(locator));
			}else if (Const.LOCATIONTYPE_PC_LINK.equals(type)) {
				list = driver.findElements(By.linkText(locator));
			}else if (Const.LOCATIONTYPE_PC_TAG.equals(type)) {
				list = driver.findElements(By.tagName(locator));
			}
        	if(list != null && !list.isEmpty()){
        		return true;
        	}
			index++;
		}
		return false;
	}
	
}
