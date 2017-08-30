package com.jdd.game.android.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.paypal.selion.internal.reports.runtimereport.JsonRuntimeReporterHelper;

public class MyReporter implements IReporter {
	
	private static final String TYPETEST = "test";
	private static final String TYPECONFIG = "config";

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		/** 自定义文件输出路径 **/
		String path = outputDirectory+"/historyReporter/test/" + System.currentTimeMillis() + File.separator;
		//String path = outputDirectory+"/historyReporter/" + File.separator;
		
		boolean bool = false;
		if(!existsDir(path)){
			if(createDir(path)){
				bool = true;
				System.out.println("文件夹已创建: " + path);
			}else{
				bool = false;
				System.out.println("文件夹创建失败: " + path);
			}
		}else{
			bool = true;
			System.out.println("文件夹已存在: " + path);
		}
		
		if(bool){
			JsonRuntimeReporterHelper jrrh = null;
			List<ITestResult> list = null;
			List<ITestResult> listConfig = null;
			if(suites != null && !suites.isEmpty()){
				for (ISuite suite : suites) {
					jrrh = new JsonRuntimeReporterHelper();
					list = new ArrayList<ITestResult>();
					listConfig = new ArrayList<ITestResult>();
		            Map<String, ISuiteResult> suiteResults = suite.getResults();
		            if(suiteResults != null && !suiteResults.isEmpty()){
		            	for (ISuiteResult suiteResult : suiteResults.values()) {
			                ITestContext testContext = suiteResult.getTestContext();
			                list.addAll(this.listTestResult(testContext.getPassedTests()));
			                list.addAll(this.listTestResult(testContext.getFailedTests()));
			                list.addAll(this.listTestResult(testContext.getSkippedTests()));
			                listConfig.addAll(this.listTestResult(testContext.getPassedConfigurations()));
			                listConfig.addAll(this.listTestResult(testContext.getFailedConfigurations()));
			                listConfig.addAll(this.listTestResult(testContext.getSkippedConfigurations()));
			            }
		            }
		            insertMethod(list, jrrh, TYPETEST);
		            insertMethod(listConfig, jrrh, TYPECONFIG);
		        }
				jrrh.writeJSON(path, false);
				if(!deleteFile(path + "index.html")){
					System.out.println(path + "index.html - 删除失败!");
				}
			}
		}
	}
	
	/**
	 * 将Test和Config的执行结果ITestResult同步到JsonRuntimeReporterHelper
	 * @param list
	 * @param jrrh
	 * @param type
	 */
	private void insertMethod(List<ITestResult> list, JsonRuntimeReporterHelper jrrh, String type){
		if(list != null && !list.isEmpty()){
        	for (ITestResult result : list) {
            	
            	String fullClassName = result.getTestClass().getName();
                String className = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);

                String packageName = "default";
                if (fullClassName.contains(".")) {
                    packageName = fullClassName.substring(0, fullClassName.lastIndexOf('.'));
                }
                if(TYPETEST.equals(type)){
                	jrrh.insertTestMethod(result.getTestContext().getSuite().getName(), result.getTestContext().getCurrentXmlTest().getName(), packageName, className, result);
                	
                }else if(TYPECONFIG.equals(type)){
                	jrrh.insertConfigMethod(result.getTestContext().getSuite().getName(), result.getTestContext().getCurrentXmlTest().getName(), packageName, className, result);
	                
                }
            }
        }
	}

	/**
	 * ITestResult类型结果集
	 * @param resultMap
	 * @return
	 */
	private ArrayList<ITestResult> listTestResult(IResultMap resultMap){
        Set<ITestResult> results = resultMap.getAllResults();
        return new ArrayList<ITestResult>(results);
    }
	
	/**
	 * 删除文件
	 * @param sPath
	 * @return
	 */
	private boolean deleteFile(String sPath) {
		File file = new File(sPath);
	    if (file.isFile() && file.exists()) {
	        file.delete();
	        return true;
	    }
	    return false;
	}
	
	/**
	 * 判断文件夹是否存在
	 * @param destDirName
	 * @return
	 */
	private boolean existsDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            return true;
        } else {
        	return false;
        }
    }
	
	/**
	 * 创建文件夹
	 * @param destDirName
	 * @return
	 */
	private boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        if (dir.mkdirs()) {
            return true;
        } else {
            return false;
        }
    }
}