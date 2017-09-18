package com.jdd.game.android.driver;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.jdd.game.android.driver.impl.BrowserDriverExe;
import com.jdd.game.android.exception.AutoException;
import com.paypal.selion.configuration.Config;
import com.paypal.selion.platform.grid.browsercapabilities.DefaultCapabilitiesBuilder;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserDriver {
	
	private static ClassLoader loader = Thread.currentThread().getContextClassLoader();
	private static Properties prop = new Properties();
	private static IDriverExe browserDriverExe = null;

	static {
		InputStream input = loader.getResourceAsStream("appium.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@BeforeClass
	public void setup() {
		String host = prop.getProperty("selenium.host");
		String port = prop.getProperty("selenium.port");
		String type = prop.getProperty("mobile.node.type");
		String timeout = prop.getProperty("timeout.execution");
		String platform = prop.getProperty("platform.name");
		String browser = prop.getProperty("browser.name");
		if(StringUtils.isBlank(type)){
			throw new AutoException("配置文件属性[mobile.node.type]不能为空！");
		}else if(StringUtils.isBlank(platform)){
			throw new AutoException("配置文件属性[platform.name]不能为空！");
		}else if(StringUtils.isBlank(host)){
			throw new AutoException("配置文件属性[selenium.host]不能为空！");
		}else if(StringUtils.isBlank(port)){
			throw new AutoException("配置文件属性[selenium.port]不能为空！");
		}else{
			if(!this.isAvailablePort(host, Integer.parseInt(port))){
				throw new AutoException("服务[http://" + host + ":" + port + "/wd/hub]未启动！");
			}
		}
		if(StringUtils.isBlank(browser)){
			Config.setConfigProperty(Config.ConfigProperty.MOBILE_APP_NAME, "browser");
		}else{
			Config.setConfigProperty(Config.ConfigProperty.MOBILE_APP_NAME, browser);
		}
		Config.setConfigProperty(Config.ConfigProperty.EXECUTION_TIMEOUT, timeout);
		Config.setConfigProperty(Config.ConfigProperty.MOBILE_NODE_TYPE, type);
		Config.setConfigProperty(Config.ConfigProperty.MOBILE_DEVICE, platform);
		Config.setConfigProperty(Config.ConfigProperty.SELENIUM_HOST, host);
		Config.setConfigProperty(Config.ConfigProperty.SELENIUM_PORT, port);
		StringBuilder className = new StringBuilder(BrowserDriver.class.getCanonicalName());
        className.append("$").append(AndroidCapabilities.class.getSimpleName());
        Config.setConfigProperty(Config.ConfigProperty.SELENIUM_CUSTOM_CAPABILITIES_PROVIDER, className.toString());
        browserDriverExe = new BrowserDriverExe();
	}
	
	@AfterClass
	public void stop(){
		if(browserDriverExe != null){
			browserDriverExe = null;
		}
	}

	public static class AndroidCapabilities extends DefaultCapabilitiesBuilder {
	    @Override
	    public DesiredCapabilities getCapabilities(DesiredCapabilities capabilities) {
	    	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("mobile.node.type"));
	    	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, prop.getProperty("browser.name"));
	    	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platform.name"));
	    	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("device.version"));
	    	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("device.name"));
	    	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, prop.getProperty("timeout.command"));
	        capabilities.setCapability(MobileCapabilityType.UDID, prop.getProperty("device.udid"));
	        //capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
	        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
	        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	        capabilities.setCapability("autoWebviewTimeout", prop.getProperty("timeout.webview"));
	        capabilities.setCapability("unicodeKeyboard", true);
	        return capabilities;
	    }
	}
	
	private boolean isAvailablePort(String host, int port){
		Socket socket = new Socket();
        try {
        	socket.connect(new InetSocketAddress(host, port));
        	return true;
        } catch (UnknownHostException e) {
        	throw new AutoException("服务器访问地址不通[Host=" + host + "][Port=" + port + "]");
		} catch (IOException e) {
			return false;
        } finally {
        	try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
	
	protected static IDriverExe getBrowserDriverExe() {
		return browserDriverExe;
	}
	protected static IDriverExe runBrowserDriverExe() {
		if(browserDriverExe != null){
			browserDriverExe.driverBrowser();
		}
		return browserDriverExe;
	}

}

