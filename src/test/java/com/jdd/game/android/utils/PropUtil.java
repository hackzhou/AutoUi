package com.jdd.game.android.utils;

import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropUtil {
	private static final String PATH_PROP = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "device.properties";
	private static Properties prop = new Properties();
	
	public static void main(String[] args) {
		System.out.println("device.udid=" + getValue("device.udid"));
		System.out.println("device.name=" + getValue("device.name"));
		System.out.println("device.version=" + getValue("device.version"));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("device.udid", "123456789");
		map.put("device.name", "abcdefgh");
		map.put("device.version", "4.4.4");
		setValue(map);
		
		System.out.println("==============");
		System.out.println("device.udid=" + getValue("device.udid"));
		System.out.println("device.name=" + getValue("device.name"));
		System.out.println("device.version=" + getValue("device.version"));
	}
	
	public static String getValue(String key){
		InputStream input = null;
		try {
			input = new BufferedInputStream (new FileInputStream(PATH_PROP));
			prop.load(input);
			return prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(input != null){
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void setValue(Map<String, String> map){
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(PATH_PROP, false);
			if(map != null && !map.isEmpty()){
				for (Map.Entry<String, String> entry : map.entrySet()){
					prop.setProperty(entry.getKey(), entry.getValue());
				}
			}
            prop.store(output, "device management");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(output != null){
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
