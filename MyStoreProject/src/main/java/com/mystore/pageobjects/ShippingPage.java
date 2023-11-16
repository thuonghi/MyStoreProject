package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	private WebDriver driver;
	private Action action;
	
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		action= new Action(driver);
	}
	
	public void checkTheTerms() throws Throwable {
		action.click(terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		action.click(proceedToCheckOutBtn);
		return new PaymentPage();
	}
}
