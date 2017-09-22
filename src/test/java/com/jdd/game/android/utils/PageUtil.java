package com.jdd.game.android.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jdd.game.android.constants.Const;
import com.paypal.selion.configuration.Config;
import com.paypal.selion.platform.grid.SeLionAppiumAndroidDriver;
import com.paypal.selion.platform.mobile.android.UiObject;

public class PageUtil {
	
	public static void waitTillActivity(RemoteWebDriver driver) {
		driver.manage().timeouts().implicitlyWait(timeoutInSeconds(), TimeUnit.SECONDS); /** 设置识别对象的超时时间 **/
		//driver.manage().timeouts().pageLoadTimeout(timeoutInSeconds(), TimeUnit.SECONDS); /** 设置页面完全加载的超时时间 **/
	}
	
	public static void waitTillActivity2(RemoteWebDriver driver) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	/** 设置识别对象的超时时间 **/
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);	/** 设置执行脚本的超时时间 **/
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);	/** 设置页面完全加载的超时时间 **/
		//driver.manage().window().maximize();	/** PC最大化窗口 **/
	}

	public static boolean isElementPresent(SeLionAppiumAndroidDriver saad, UiObject ub, String message) {
		return (new WebDriverWait(saad, timeoutInSeconds()).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					List<?> list = saad.findElementsByXPath(ub.getLocator());
					if(list != null && !list.isEmpty()){
						return true;
					}
					return false;
				} catch(NoSuchElementException e) {
					return false;
				}
			}
			@Override
			public String toString() {
				return "《" + message + "》控件未找到! Locator:" + ub.getLocator();
			}
		}));
	}
	
	public static boolean isElementPresent(SeLionAppiumAndroidDriver saad, String name, String message) {
		return (new WebDriverWait(saad, timeoutInSeconds()).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
		        	List<?> list = saad.findElementsByName(name);
		        	if(list != null && !list.isEmpty()){
		        		return true;
		        	}
		        	return false;
		        } catch(NoSuchElementException e) {
		        	return false;
		        }
			}
			@Override
			public String toString() {
				return "《" + message + "》控件未找到! Name:" + name;
			}
		}));
	}
	
	private static long timeoutInSeconds(){
        return Long.valueOf(Config.getConfigProperty(Config.ConfigProperty.EXECUTION_TIMEOUT))/1000;
    }
	
	public static boolean isElementPresent(RemoteWebDriver driver, String type, String locator) {
		return (new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
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
		        	return false;
		        } catch(NoSuchElementException e) {
		        	return false;
		        }
			}
			@Override
			public String toString() {
				return "控件未找到! [" + type + "]Locator:" + locator;
			}
		}));
	}
	
}
