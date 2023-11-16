package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	private WebDriver driver;
	private Action action;
	
	public OrderConfirmationPage(WebDriver driver) {
		action = new Action(driver);
	}

	@FindBy(xpath = "//p/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmMessag;

	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateConfirmMessage() {
		String confirmMsg = confirmMessag.getText();
		return confirmMsg;
	}

}
