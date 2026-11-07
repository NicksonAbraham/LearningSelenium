package com.orangeHrm.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.rangeHrm.pages.LoginPage;
import com.utility.ExcelUtility;
import com.utility.ProperitiesUtility;

public class LoginTest extends BaseTest {
	
	@Test
	public void loginWithValidUserNameAndValidPassword() throws InvalidFormatException, IOException {
		
		LoginPage loginpage=new LoginPage(driver);
		//loginpage.login(ExcelUtility.getTestData(1, 0), ExcelUtility.getTestData(1, 1));
		loginpage.login(ProperitiesUtility.getData("username"),ProperitiesUtility.getData("password"));
	}

}
