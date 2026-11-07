package com.orangeHrm.test;

import java.util.Scanner;

import org.testng.annotations.Test;

import com.rangeHrm.pages.Homepage;

public class HomepageTest extends BaseTest {

    Homepage hp;

    @Test(priority = 1)
    public void searchLeave() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee Name:");

        String name = sc.nextLine();

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