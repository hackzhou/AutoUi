package com.jdd.game.android.driver;

import java.util.List;
import org.openqa.selenium.WebElement;
import com.paypal.selion.platform.mobile.android.UiObject;
import com.paypal.selion.platform.mobile.android.UiTextView;

public interface IAppDriverExe {
	
	/**
	 * 驱动打开运行App
	 */
	public void driverApp();
	
	/**
	 * 页面后退
	 */
	public void back();
	
	/**
	 * 页面前进
	 */
	public void forward();
	
	/**
	 * 页面刷新
	 */
	public void refresh();
	
	/**
	 * 等待页面加载
	 * @param s (等待时间:秒)
	 */
	public void waitPageLoad(long s);
	
	/**
	 * 日志输出 (不截图)
	 * @param message (消息文本)
	 */
	public void log(String message);
	
	/**
	 * 日志输出(内部使用)
	 * @param message (消息文本)
	 * @param bool (是否截图)
	 */
	public void log(String message, boolean bool);
	
	/**
	 * 日志输出(外部使用)
	 * @param message (消息文本)
	 * @param bool (是否截图)
	 */
	public void logOut(String message, boolean bool);
	
	/**
	 * 取得元素
	 * @param type (xpath or name)
	 * @param text (验证文本)
	 * @return
	 */
	public WebElement getWebElement(String type, String text);
	
	/**
	 * 取得元素集
	 * @param type (xpath or name)
	 * @param text (验证文本)
	 * @return
	 */
	public List<WebElement> getWebElements(String type, String text);

	/**
	 * 取得坐标滑动
	 * @param startx (开始坐标X轴)
	 * @param starty (开始坐标Y轴)
	 * @param endx (结束坐标X轴)
	 * @param endy (结束坐标Y轴)
	 */
	public void swipePoint(int startx, int starty, int endx, int endy);
	
	/**
	 * 屏幕上下左右滑动
	 * @param direction (up (上), down (下), left (左), right (右))
	 * @param num (滑动次数)
	 */
	public void swipeDirection(String direction, int num);
	
	/**
	 * 屏幕上下左右滑动
	 * @param direction (up (上), down (下), left (左), right (右))
	 * @param per (滑动比例)
	 * @param num (滑动次数)
	 */
	public void swipeDirection(String direction, double per, int num);
	
	/**
	 * 取得坐标点击
	 * @param x (点击坐标X轴)
	 * @param y (点击坐标Y轴)
	 */
	public void tapPoint(int x, int y);
	
	/**
	 * 取得元素点击
	 * @param ub (UiObject控件)
	 * @param message (打印消息文本)
	 */
	public void tapElement(UiObject ub, String message);
	
	/**
	 * 发现元素并点击
	 * @param ub (UiObject控件)
	 * @param message (打印消息文本)
	 */
	public void foundTapElement(UiObject ub, String message);
	
	/**
	 * 取得元素点击(WebView)
	 * @param xpath (xpath)
	 * @param message (打印消息文本)
	 */
	public void tapElementWebView(String xpath, String message);
	
	/**
	 * 通过xpath取得元素点击
	 * @param xpath (xpath)
	 * @param message (打印消息文本)
	 */
	public void tapElementByXpath(String xpath, String message);
	
	/**
	 * 通过xpath取得元素点击
	 * @param xpath (xpath)
	 * @param index (序号从0开始)
	 * @param message (打印消息文本)
	 */
	public void tapElementByXpath(String xpath, Integer index, String message);
	
	/**
	 * 通过name取得元素点击
	 * @param name (name)
	 * @param message (打印消息文本)
	 */
	public void tapElementByID(String name, String message);
	
	/**
	 * 通过name取得元素点击
	 * @param name (name)
	 * @param message (打印消息文本)
	 */
	public void tapElementByName(String name, String message);
	
	/**
	 * 通过name取得所有元素点击
	 * @param name (name)
	 * @param message (打印消息文本)
	 */
	public void tapElementsByName(String name, String message);
	
	/**
	 * 取得文本框并追加文本
	 * @param utv (UiTextView控件)
	 * @param text (追加文本)
	 */
	public void appendTextField(UiTextView utv, String text);
	
	/**
	 * 取得文本框先清除文本再填充文本
	 * @param utv (UiTextView控件)
	 * @param text (填充文本)
	 */
	public void clear2SetTextField(UiTextView utv, String text);
	
	/**
	 * 清除文本
	 * @param utv (UiTextView控件)
	 */
	public void clearTextField(UiTextView utv);
	
	/**
	 * 验证文本是否存在于页面上
	 * @param text (验证文本)
	 * @return
	 */
	public boolean isTextInPage(String text);
	
	/**
	 * 在页面上验证文本A是否在文本B后面
	 * @param textA (验证文本)
	 * @param textB (验证文本)
	 * @return
	 */
	public boolean compareTextInPage(String textA, String textB);
	
	/**
	 * 点击指定日期控件 (当天以及以后)
	 * @param dateStr (指定日期)
	 * @param message
	 */
	public void tapSpecifyDateElement(String dateStr, String message);
	
	/**
	 * 点击指定日期控件 (当天以及以后)
	 * @param num (1 明天,2 后天...)
	 * @param message
	 */
	public void tapSpecifyDateElement(int num, String message);
	
	/**
	 * 点击当天日期控件 (当天)
	 * @param message (打印消息文本)
	 */
	public void tapCurrentDateElement(String message);
	
	/**
	 * 点击随机日期控件 (当天以及以后)
	 * @param num (选择从当前日期加一天到加num天后日期之间的随机日期)
	 * @param message (打印消息文本)
	 */
	public void tapRandomDateElement(int num, String message);
	
	/**
	 * 自动智能日期选择 (从明天日期开始点击,如果日期禁用的话,加一天再点击,以此类推)
	 * @param message (打印消息文本)
	 * @return
	 */
	public String tapAutoDateElement(String message);
	
	/**
	 * 断言控件是否存在当前页面
	 * @param ub (UiObject控件)
	 * @param message (消息文本)
	 */
	public void assertElement(UiObject ub, String message);
	
	/**
	 * 断言验证文本是否在当前页面
	 * @param text (验证文本)
	 */
	public void assertPage(String text);
	
	/**
	 * 断言验证文本是否在当前页面
	 * @param text (验证文本)
	 * @param message (消息文本)
	 */
	public void assertPage(String text, String message);
	
	/**
	 * 取得Xpath末尾"[n]"中n值
	 * @param xpath  (xpath)
	 * @return
	 */
	public int getIndexXpath(String xpath);
	
	/**
	 * 设置Xpath末尾"[n]"中n值
	 * @param xpath  (xpath)
	 * @param i (增值)
	 * @return
	 */
	public String setIndexXpath(String xpath, int i);
	
	/**
	 * 通过xpath取得WebElement的name
	 * @param xpath (xpath)
	 * @return
	 */
	public String getNameByXpath(String xpath);
	
	/**
	 * 获取设备的宽
	 */
	public Integer getWindowWidth();
	
	/**
	 * 获取设备的高
	 */
	public Integer getWindowHeight();
	
	/**
	 * 设置context
	 * @param name (NATIVE_APP、WEBVIEW)
	 */
	public void context(String name);
	
	/**
	 * 键盘点击操作
	 * @param key 值
	 */
	public void keyboardClick(int key);
	
	/**
	 * 关闭APP
	 */
	public void closeApp();
	
	/**
	 * 启动APP
	 */
	public void launchApp();
	
	/**
	 * 重启APP
	 */
	public void resetApp();
	
	/**
	 * 退出APP
	 */
	public void quitApp();

}
