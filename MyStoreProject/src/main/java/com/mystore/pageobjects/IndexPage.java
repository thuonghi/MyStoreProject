package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	private WebDriver driver;
	private Action action;
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@alt='My Shop']")
	WebElement logoMyStore;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchBtn;
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);
	}
	
	public LoginPage ClickOnSignIn() throws Throwable {
		action.click(signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return action.isDisplayed(driver, logoMyStore);
	}
	
	public String getMyStoreTittle() {
		String myStoreTitle = driver.getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		action.type(searchProductBox, productName);
		action.click(searchBtn);
		return new SearchResultPage();
		
	
	}
}
