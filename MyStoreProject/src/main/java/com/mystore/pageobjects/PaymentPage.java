package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	private WebDriver driver;
	private Action action;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public PaymentPage() {
		this.driver = driver;
		action = new Action(driver);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() throws Throwable {
		action.click(bankWireMethod);
		return new OrderSummaryPage(driver);
	}

}
