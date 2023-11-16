package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	    private WebDriver driver;
		private Action action;

		@FindBy(xpath="span[(text()='Add my first address']")
		WebElement addAddress;
		
		@FindBy(xpath="span[(text()='Order history and details']")
		WebElement orderHistory;
		
		public HomePage(WebDriver driver) {
			this.driver = driver;
			action = new Action(driver);
		}
		
		public boolean validateAddAddress() {
			return action.isDisplayed(driver, addAddress);
		}
		
		public void validateOrderHistory() {
			action.isDisplayed(driver, orderHistory);
		}
		
		public String getCurrURL() throws Throwable {
			String homePageURL=action.getCurrentURL(driver);
			return homePageURL;
		}
}
