package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {
	private WebDriver driver;
	private Action action;
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;

	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);

	}

	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		action.click(confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
