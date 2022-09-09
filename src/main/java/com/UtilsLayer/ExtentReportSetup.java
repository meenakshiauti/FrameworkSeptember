package com.UtilsLayer;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.BaseLayer.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetup extends BaseClass {
	
	public static ExtentSparkReporter sparksReport;
	public static ExtentReports extent;
	public static ExtentTest extenttest;
	public static ExtentReports extentReportSetup()
	{
		
		String date=new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		
		sparksReport=new ExtentSparkReporter
				(System.getProperty("user.dir")+"\\Reports\\extenReports"+date+".html");
		
		extent= new ExtentReports();
		sparksReport.config().setTheme(Theme.DARK);
		//sparksReport.config().setDocumentTitle("");
		sparksReport.config().setReportName("");
		extent.attachReporter(sparksReport);
		return extent;
		
	}

}
