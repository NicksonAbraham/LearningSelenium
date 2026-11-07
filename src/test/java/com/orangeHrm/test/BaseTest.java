package com.orangeHrm.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.report.ExtentReportUtils;

public class BaseTest {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void initDriver() {
		
		ExtentReportUtils.setUpReport();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}

}
