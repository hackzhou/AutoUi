package com.jdd.game.android.driver;

import java.io.File;
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
import com.jdd.game.android.driver.impl.AndroidDriverExe;
import com.jdd.game.android.exception.AutoException;
import com.paypal.selion.configuration.Config;
import com.paypal.selion.platform.grid.browsercapabilities.DefaultCapabilitiesBuilder;

public class AppDriver {
	
	private static ClassLoader loader = Thread.currentThread().getContextClassLoader();
	private static Properties prop = new Properties();
	private static IDriverExe androidDriverExe = null;

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
		String timeout = prop.getProperty("execution.timeout");
		if(StringUtils.isBlank(type)){
			throw new AutoException("配置文件属性[mobile.node.type]不能为空！");
		}else if(StringUtils.isBlank(host)){
			throw new AutoException("配置文件属性[selenium.host]不能为空！");
		}else if(StringUtils.isBlank(port)){
			throw new AutoException("配置文件属性[selenium.port]不能为空！");
		}else{
			if(!this.isAvailablePort(host, Integer.parseInt(port))){
				throw new AutoException("服务[http://" + host + ":" + port + "/wd/hub]未启动！");
			}
		}
		if(this.isExistFile(prop.getProperty("app.path"))){
			Config.setConfigProperty(Config.ConfigProperty.MOBILE_APP_PATH, new File(prop.getProperty("app.path")).getAbsolutePath());
		}else{
			if(StringUtils.isNotBlank(prop.getProperty("app.name"))){
				Config.setConfigProperty(Config.ConfigProperty.MOBILE_APP_NAME, prop.getProperty("app.name"));
			}else{
				throw new AutoException("App Path or Name does not exist.");
			}
		}
		Config.setConfigProperty(Config.ConfigProperty.EXECUTION_TIMEOUT, timeout);
		Config.setConfigProperty(Config.ConfigProperty.MOBILE_NODE_TYPE, type);
		Config.setConfigProperty(Config.ConfigProperty.SELENIUM_HOST, host);
		Config.setConfigProperty(Config.ConfigProperty.SELENIUM_PORT,port);
		StringBuilder className = new StringBuilder(AppDriver.class.getCanonicalName());
        className.append("$").append(AndroidCapabilities.class.getSimpleName());
        Config.setConfigProperty(Config.ConfigProperty.SELENIUM_CUSTOM_CAPABILITIES_PROVIDER, className.toString());
        androidDriverExe = new AndroidDriverExe();
	}
	
	@AfterClass
	public void stop(){
		if(androidDriverExe != null){
			androidDriverExe.quitApp();
		}
	}

	public static class AndroidCapabilities extends DefaultCapabilitiesBuilder {
		
	    @Override
	    public DesiredCapabilities getCapabilities(DesiredCapabilities capabilities) {
	    	capabilities.setCapability("automationName", prop.getProperty("mobile.node.type"));
	    	capabilities.setCapability("platformName", prop.getProperty("platform.name"));
	    	capabilities.setCapability("platformVersion", prop.getProperty("device.version"));
	    	capabilities.setCapability("deviceName", prop.getProperty("device.name"));
	        capabilities.setCapability("udid", prop.getProperty("device.udid"));
	        return capabilities;
	    }
	}
	
	private boolean isExistFile(String path){
		if(path == null || path.length() < 1){
			return false;
		}
		if((new File(path)).exists()){
			return true;
		}
		return false;
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
	
	protected static IDriverExe getAndroidDriverExe() {
		return androidDriverExe;
	}
	protected static IDriverExe runAndroidDriverExe() {
		if(androidDriverExe != null){
			androidDriverExe.driverApp();
		}
		return androidDriverExe;
	}

}

