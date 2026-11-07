package com.rangeHrm.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.report.ExtentReportUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Homepage {
	Logger log=LogManager.getLogger(Homepage.class);

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public Homepage(WebDriver driver) {
    	
    	
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Search Leave - Employee Name
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;

    // Profile Dropdown
    @FindBy(xpath = "//i[contains(@class,'oxd-userdropdown-icon')]")
    WebElement dropdown;

    // Logout Button
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;


    // Search Leave Method
    public void searchLeave(String name) {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");

        wait.until(ExpectedConditions.visibilityOf(employeeName));

        employeeName.sendKeys(name);
        log.info("Employee name is given");
        ExtentReportUtils.addStep("Employee name is Entered");
    }


    // Logout Method
    public void logout() {

        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        log.info("Logout is clicked");
        ExtentReportUtils.addStep("Logout link is clicked");
    }


    // Close Browser Method
    public void closeBrowser() {

        driver.quit();
    }

}