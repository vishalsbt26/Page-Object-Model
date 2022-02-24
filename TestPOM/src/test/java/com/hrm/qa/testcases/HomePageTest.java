package com.hrm.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	public HomePageTest() 
	{
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyLoginTest() 
	{
		boolean welcomeMessage = homePage.verifyLogin();
		assertTrue(welcomeMessage);
	}

	@Test(priority=2)
	public void clickAdminTest() 
	{
		homePage.clickAdminPage();
	}

	@Test(priority=3)
	public void clickMyInfoTest()
	{
		homePage.clickMyInfo();
	}

	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}
