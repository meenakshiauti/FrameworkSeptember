package com.UtilsLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ExtentReportListener extends ExtentReportSetup implements ITestListener {

	public void onStart(ITestContext context) {
		ExtentReportSetup.extentReportSetup();
		
	}
	
	public void onTestStart(ITestResult result) {
		
		extenttest=extent.createTest(result.getMethod().getMethodName());
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		extenttest.log(Status.PASS, "Test case is Pass::::"+result.getMethod().getMethodName());
		
		extenttest.addScreenCaptureFromPath(utilsClass.takesScreenshot("\\PassScreenShot\\"+result.getMethod().getMethodName()));
	}

	public void onTestFailure(ITestResult result) {
		
		extenttest.log(Status.FAIL, "Test case is Fail ::::"+result.getMethod().getMethodName());
		extenttest.addScreenCaptureFromPath(utilsClass.takesScreenshot("\\FailScreenShot\\"+result.getMethod().getMethodName()));
		
	}

	public void onTestSkipped(ITestResult result) {
		
		extenttest.log(Status.SKIP, "Test case is Skipped ::::"+result.getMethod().getMethodName());		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
