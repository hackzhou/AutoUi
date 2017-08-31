package com.jdd.game.android.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.paypal.selion.configuration.Config;
import com.paypal.selion.platform.grid.SeLionAppiumAndroidDriver;
import com.paypal.selion.platform.mobile.android.UiObject;

public class PageUtil {
	
	public static void waitTillActivity(RemoteWebDriver driver) {
//		driver.manage().timeouts().pageLoadTimeout(timeoutInSeconds(), TimeUnit.SECONDS); /** 设置页面完全加载的超时时间 **/
		driver.manage().timeouts().implicitlyWait(timeoutInSeconds(), TimeUnit.SECONDS); /** 设置识别对象的超时时间 **/
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
	
}
