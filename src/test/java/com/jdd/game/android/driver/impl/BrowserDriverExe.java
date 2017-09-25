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
import org.testng.Assert;

import com.jdd.game.android.constants.Const;
import com.jdd.game.android.driver.IWapDriverExe;
import com.jdd.game.android.exception.AutoException;
import com.jdd.game.android.utils.DateUtil;
import com.jdd.game.android.utils.PageUtil;
import com.jdd.game.android.utils.SleepUtil;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.reports.runtime.SeLionReporter;

public class BrowserDriverExe implements IWapDriverExe {

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
			throw new AutoException("驱动异常:《请检查！》");
		}
		return (RemoteWebDriver) this.rwd;
	}
	
	public void driverBrowser(){
		setRwd(Grid.driver());
		PageUtil.waitTillActivity2(this.rwd);
	}
	
	@Override
	public void back() {
		this.getBrowserDriver().navigate().back();
	}

	@Override
	public void forward() {
		this.getBrowserDriver().navigate().forward();
	}

	@Override
	public void refresh() {
		this.getBrowserDriver().navigate().refresh();
	}
	
	@Override
	public String getCurrentUrl() {
		return this.getBrowserDriver().getCurrentUrl();
	}

	@Override
	public void waitPageLoad(long s) {
		SleepUtil.sleep(s * 1000);
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
	public WebElement getWebElement(String type, String locator) {
		RemoteWebDriver driver = this.getBrowserDriver();
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
		return e;
	}

	@Override
	public List<WebElement> getWebElements(String type, String locator) {
		RemoteWebDriver driver = this.getBrowserDriver();
		List<WebElement> list = null;
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
		return list;
	}

	@Override
	public void open(String url) {
		this.getBrowserDriver().get(url);
		this.waitPageLoad(2);
		this.log("测试输出:《" + url + "》已打开！");
	}
	
	@Override
	public void click(String locator, String log) {
		this.click(Const.LOCATIONTYPE_PC_XPATH, locator, log);
	}
	
	@Override
	public void click(String type, String locator, String log) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			this.waitPageLoad(1);
			getWebElement(type, locator).click();
			this.log("测试输出:《" + log + "》已点击！");
		}else{
			this.log("测试输出:《" + log + "》未找到！");
		}
	}
	
	@Override
	public void foundClick(String locator, String log) {
		this.foundClick(Const.LOCATIONTYPE_PC_XPATH, locator, log);
	}

	@Override
	public void foundClick(String type, String locator, String log) {
		if(isElementExist(type, locator)){
			this.waitPageLoad(1);
			getWebElement(type, locator).click();
			this.log("测试输出:《" + log + "》已点击！");
		}else{
			this.log("测试输出:《" + log + "》未找到！");
		}
	}
	
	@Override
	public void clearText(String locator, String log) {
		this.clearText(Const.LOCATIONTYPE_PC_XPATH, locator, log);
	}

	@Override
	public void clearText(String type, String locator, String log) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			this.waitPageLoad(1);
			getWebElement(type, locator).clear();
			this.log("测试输出:《" + log + "》清除值！");
		}
	}
	
	@Override
	public boolean isTextInPage(String text) {
		return (this.getBrowserDriver().getPageSource().indexOf(text) != -1);
	}

	@Override
	public boolean result(String text) {
		RemoteWebDriver driver = this.getBrowserDriver();
		this.waitPageLoad(1);
		boolean bool = (driver.getPageSource().indexOf(text) != -1);
		this.log("测试输出:《" + text + "[" + bool + "]》结果验证");
		Assert.assertEquals(true, bool, text);
		return bool;
	}
	
	@Override
	public boolean value(String locator, String text) {
		boolean bool = this.value(Const.LOCATIONTYPE_PC_XPATH, locator, text);
		Assert.assertEquals(true, bool, text);
		return bool;
	}

	@Override
	public boolean value(String type, String locator, String text) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			this.waitPageLoad(1);
			WebElement e = getWebElement(type, locator);
			if (e != null && (text.equals(e.getText()) || text.equals(e.getAttribute("value")))) {
				this.log("测试输出:《" + text + "[true]》值验证");
				return true;
			}
			this.log("测试输出:《" + text + "[false]》值验证");
		}
		return false;
	}
	
	@Override
	public void sendKey(String locator, String text) {
		this.sendKey(Const.LOCATIONTYPE_PC_XPATH, locator, text);
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
				this.log("测试输出:《" + text + "》设置值");
			}
		}
	}
	
	@Override
	public String getElementValue(String locator, String log) {
		return this.getElementValue(Const.LOCATIONTYPE_PC_XPATH, locator, log);
	}

	@Override
	public String getElementValue(String type, String locator, String log) {
		RemoteWebDriver driver = this.getBrowserDriver();
		String result = null;
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = getWebElement(type, locator);
			if(e != null){
				result = e.getText();
				if(result == null){
					result = e.getAttribute("value");
				}
				this.log("测试输出:《" + log + "[" + result + "]》获取值");
			}
		}
		return result;
	}
	
	@Override
	public void scroll(String locator, String log) {
		this.scroll(Const.LOCATIONTYPE_PC_XPATH, locator, log);
	}

	@Override
	public void scroll(String type, String locator, String log) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = getWebElement(type, locator);
			if(e != null){
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", e);
				this.log("测试输出:《" + log + "》滑动");
			}
		}
	}

	@Override
	public void scrollTop(String direction) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(Const.PC_SCROLLTOP_TOP.equals(direction)){
			((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=0");
			this.log("测试输出:《顶端》滑动");
		}else if(Const.PC_SCROLLTOP_BOTTOM.equals(direction)){
			((JavascriptExecutor) driver).executeScript("document.documentElement.scrollTop=10000");
			this.log("测试输出:《底端》滑动");
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
		this.log("测试输出:《弹框-允许》已点击");
	}

	@Override
	public void clickAlertDismiss() {
		RemoteWebDriver driver = this.getBrowserDriver();
		Alert alert = driver.switchTo().alert();
        alert.dismiss();
        this.log("测试输出:《弹框-取消》已点击");
	}
	
	@Override
	public void clickAndHold(String locator, String log) {
		this.clickAndHold(Const.LOCATIONTYPE_PC_XPATH, locator, log);
	}

	@Override
	public void clickAndHold(String type, String locator, String log) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = getWebElement(type, locator);
			Actions action = new Actions(driver);
			if(e != null){
				action.moveToElement(e).perform();
				this.log("测试输出:《" + log + "》光标移动");
			}
		}
	}
	
	@Override
	public void selectByValue(String locator, String log) {
		this.selectByValue(Const.LOCATIONTYPE_PC_XPATH, locator, log);
	}

	@Override
	public void selectByValue(String type, String locator, String text) {
		RemoteWebDriver driver = this.getBrowserDriver();
		if(PageUtil.isElementPresent(driver, type, locator)){
			WebElement e = getWebElement(type, locator);
			if(e != null){
				if("select".equalsIgnoreCase(e.getTagName().trim())){
					Select select = new Select(e);
					select.selectByValue(text);
				}else{
					e.sendKeys(text);
				}
				this.log("测试输出:《" + text + "》选择值");
			}
		}
	}
	
	@Override
	public void close() {
		this.getBrowserDriver().close();
	}

	@Override
	public void quit() {
		this.getBrowserDriver().quit();
	}
	
	private boolean isElementExist(String type, String locator){
		int index = 0;
		while (index < 1) {
			List<?> list = getWebElements(type, locator);
        	if(list != null && !list.isEmpty()){
        		return true;
        	}
			index++;
		}
		return false;
	}
	
}
