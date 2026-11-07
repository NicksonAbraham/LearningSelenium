package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OrangeHrmTest {
	
	RemoteWebDriver driver;
	@Test(priority=1)
	public void LoginIntoApp() throws InterruptedException, MalformedURLException {
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", "oauth-abrahamnickson29-94457");
		sauceOptions.put("accessKey", "dc3e5b34-6aa9-49f5-83d6-3ef1f1122d1c");
		sauceOptions.put("build", "Test Automation");
		sauceOptions.put("name", "Sanity Test");
		browserOptions.setCapability("sauce:options", sauceOptions);
		
		System.setProperty("webdriver.chrome.driver","./drivers//chromedriver.exe");
		// start the session
		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	    driver = new RemoteWebDriver(url, browserOptions);
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		Thread.sleep(5000);
		
	}
	
	@Test(priority=2)
	public void searchLeave() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Navigate to Leave List
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");

	    // Wait for Employee Name field
	    WebElement employeeName = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//input[@placeholder='Type for hints...']")
	        )
	    );

	    // Enter employee name
	    employeeName.sendKeys("Nickson");

	}
    

	@Test(priority=3)
	public void logout() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement dropdown = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//i[contains(@class,'oxd-userdropdown-icon')]")
	        )
	    );
        dropdown.click();

	    wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//a[normalize-space()='Logout']")
	        )
	    ).click();
	}

	
	@Test(priority=4)
	public void closebowser() {
		driver.close();
		
		
	}
}

