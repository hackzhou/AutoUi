package com.jdd.game.android.report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.jdd.game.android.exception.AutoException;
import com.jdd.game.android.utils.FileUtil;
import com.paypal.selion.internal.reports.runtimereport.JsonRuntimeReporterHelper;

public class MyReporter implements IReporter {
	
	private static final String TYPE_TEST		= "test";
	private static final String TYPE_CONFIG		= "config";
	private static final String PATH_OUT		= File.separator + "historyReporter" + File.separator + "test" + File.separator + "%s" + File.separator;;
	private static final String INDEX_BACK_OLD	= "../";
	private static final String INDEX_BACK_NEW	= "../../../";

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		/** 自定义文件输出路径 **/
		String path = outputDirectory + String.format(PATH_OUT, timeDir());
		
		FileUtil fu = new FileUtil();
		if(!fu.existsDir(path)){
			if(!fu.createDir(path)){
				throw new AutoException("报告文件夹创建失败[" + path + "]");
			}
		}
		
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
	            insertMethod(list, jrrh, TYPE_TEST);
	            insertMethod(listConfig, jrrh, TYPE_CONFIG);
	        }
			jrrh.writeJSON(path, false);
//			if(!deleteFile(path + "index.html")){
//				System.out.println(path + "index.html - 删除失败!");
//			}
			String text = fu.readFile(path + "index.html");
			if(text != null && !text.isEmpty()){
				fu.writeFile(path + "index.html", text.replace(INDEX_BACK_OLD, INDEX_BACK_NEW));
				System.out.println("报告已创建: " + path + "index.html");
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
                if(TYPE_TEST.equals(type)){
                	jrrh.insertTestMethod(result.getTestContext().getSuite().getName(), result.getTestContext().getCurrentXmlTest().getName(), packageName, className, result);
                }else if(TYPE_CONFIG.equals(type)){
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
	
	private String timeDir(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}
}