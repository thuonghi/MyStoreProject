package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	private WebDriver driver;
	private Action action;
	
	@FindBy(id ="product_price_1_1_0")
	WebElement unitPrice;
	
	@FindBy(id="total_product_price_1_1_0")
	WebElement totalPrice;
	
	@FindBy(xpath="//*[@id=\"[2]/a[1]/spancenter_column\"]/p")
	WebElement proceddToCheckOut;
	
	public OrderPage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);
	}
	
	public double getUnitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit = unitPrice1.replace("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=unitPrice.getText();
		String tot = totalPrice1.replace("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() throws Throwable {
		action.click(proceddToCheckOut);
		return new LoginPage();
	}
}
