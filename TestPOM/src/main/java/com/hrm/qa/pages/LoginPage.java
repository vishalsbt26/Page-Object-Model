package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class LoginPage extends TestBase 
{
	//Define Page Factory OR Object Repository
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="divLogo")
	WebElement hrmLogo;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	//Constructor
	//this means its pointing to current class objects that we define above
	//How to initialize PageFactory: by using PageFactory.initElements
	
	//Initializing the objects:
	public LoginPage() 
	{
		PageFactory.initElements(driver,this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean vaildateLogo() {
		return hrmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
