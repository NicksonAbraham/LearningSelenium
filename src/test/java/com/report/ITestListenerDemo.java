package com.report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerDemo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportUtils.createTest(result.getMethod().getMethodName());

	}



	@Override
	public void onFinish(ITestContext context) {
		ExtentReportUtils.flushReport();
	}

	

}

