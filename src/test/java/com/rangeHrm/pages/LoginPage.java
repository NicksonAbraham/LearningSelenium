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

public class LoginPage {
	
	 
	Logger log= LogManager.getLogger(LoginPage.class); 

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    
   
   
    // Username
    @FindBy(name = "username")
    WebElement username;

    // Password
    @FindBy(name = "password")
    WebElement password;

    // Login Button
    @FindBy(css = "button[type='submit']")
    WebElement loginButton;
    
  

    // Login Method
    public void login(String uname, String pwd) {

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(uname);
        log.info("Username is entered in the textbox");
        ExtentReportUtils.addStep("Username is Entered");

        password.sendKeys(pwd);
        log.info("Password is entered in the textbox");
        ExtentReportUtils.addStep("Password value is entered");

        loginButton.click();
        log.info("Login btn is clicked");
        ExtentReportUtils.addStep("Login btn is clicked");
        

    }
}