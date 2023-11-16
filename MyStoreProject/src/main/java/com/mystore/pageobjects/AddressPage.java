package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	private WebDriver driver;
	private Action action;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;

	public AddressPage(WebDriver driver) {
		this.driver = driver;	
		action = new Action(driver);
	}

	public ShippingPage clickOnCheckOut() throws Throwable {
		action.click(proceedToCheckOut);
		return new ShippingPage(driver);
	}
}
