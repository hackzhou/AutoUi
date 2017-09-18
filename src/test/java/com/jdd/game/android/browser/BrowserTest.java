package com.jdd.game.android.browser;

import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.grid.Grid;

public class BrowserTest {

	@Test
	@MobileTest(appName = "browser", device = "android:4.4.2", deviceType = "Android")
	public void testWithBrowser() {
		RemoteWebDriver driver = Grid.driver();
		assertNotNull(driver);
		driver.get("http://www.baidu.com");
		sleep(5);
		driver.quit();
	}
	
	public static void sleep(int s){
		try {
			Thread.sleep(1000 * s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
