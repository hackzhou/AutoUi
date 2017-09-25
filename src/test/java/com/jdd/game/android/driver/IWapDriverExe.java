package com.jdd.game.android.driver;

import java.util.List;
import org.openqa.selenium.WebElement;

public interface IWapDriverExe {
	
	public void back();
	
	public void forward();
	
	public void refresh();

	public String getCurrentUrl();
	
	public void waitPageLoad(long s);
	
	public void log(String message);
	
	public void log(String message, boolean bool);
	
	public void logOut(String message, boolean bool);
	
	public WebElement getWebElement(String type, String text);

	public List<WebElement> getWebElements(String type, String text);

	public void driverBrowser();
	
	public void open(String url);
	
	public void click(String locator, String log);

	public void click(String type, String locator, String log);
	
	public void foundClick(String locator, String log);

	public void foundClick(String type, String locator, String log);
	
	public void clearText(String locator, String log);

	public void clearText(String type, String locator, String log);
	
	public boolean isTextInPage(String text);
	
	public boolean result(String text);
	
	public boolean value(String locator, String text);

	public boolean value(String type, String locator, String text);
	
	public void sendKey(String locator, String text);

	public void sendKey(String type, String locator, String text);
	
	public String getElementValue(String locator, String log);

	public String getElementValue(String type, String locator, String log);
	
	public void scroll(String locator, String log);

	public void scroll(String type, String locator, String log);
	
	public void scrollTop(String direction);
	
	public void switchToWindow(String windowTitle);
	
	public void switchToFrame(String id);
	
	public void clickAlertSure();
	
	public void clickAlertDismiss();
	
	public void clickAndHold(String locator, String log);

	public void clickAndHold(String type, String locator, String log);
	
	public void selectByValue(String locator, String text);

	public void selectByValue(String type, String locator, String text);
	
	public void close();
	
	public void quit();
	
}
