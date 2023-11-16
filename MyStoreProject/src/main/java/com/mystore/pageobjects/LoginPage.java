package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	private WebDriver driver;
	private Action action;
	
	@FindBy(id="email")
	WebElement userName;
	
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		this.driver = driver;
	}
	
	public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(driver, signInBtn);
		Thread.sleep(2000);
		homePage=new HomePage(driver);
		return homePage;
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(signInBtn);
		Thread.sleep(2000);
		addressPage=new AddressPage(driver);
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.type(emailForNewAccount, newEmail);
		action.click(createNewAccountBtn);
		return new AccountCreationPage(driver);
	}
}
