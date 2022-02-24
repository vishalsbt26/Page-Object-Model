package com.hrm.qa.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {

	//PageFactory OR Object Repository
	@FindBy(id="welcome")
	WebElement welcomeMsg;

	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminPanel;
	
	@FindBy(id="menu_pim_viewMyDetails")
	WebElement myInfo;
	
	//Initializing the page objects
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean verifyLogin()
	{
		return welcomeMsg.getText().startsWith("Welcome");
	}
	
	public RegisterPage clickAdminPage() 
	{
		adminPanel.click();
		return new RegisterPage();
	}
	
	public UpdateMyInfoPage clickMyInfo()
	{
		myInfo.click();
		return new UpdateMyInfoPage();
	}
}
