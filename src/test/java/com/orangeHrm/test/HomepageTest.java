package com.orangeHrm.test;


import org.testng.annotations.Test;

import com.rangeHrm.pages.Homepage;

public class HomepageTest extends BaseTest {

    Homepage hp;

    @Test(priority = 1)
    public void searchLeave() {

        String name="Nickson";

        hp = new Homepage(driver);

        hp.searchLeave(name);
    }

    @Test(priority = 2)
    public void logout() {

        hp.logout();
    }

    @Test(priority = 3)
    public void closeBrowser() {

        hp.closeBrowser();
    }
}