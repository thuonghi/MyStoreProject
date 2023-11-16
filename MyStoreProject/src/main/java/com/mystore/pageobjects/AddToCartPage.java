package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	private WebDriver driver;
	private Action action;
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;

	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//div[1]/h2")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//div[4]/a")
	WebElement proceedToCheckOutBtn;
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		action = new Action(driver);
	}
	
	public void enterQuantity(String size) {
		action.type(addToCartBtn, size);
	}
	
	public void selectSize(String size1) {
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() {
		action.click(addToCartBtn);
	}
	public boolean validateAddToCart() {
		return action.isDisplayed(driver, addToCartMessage);
	}
	
	public OrderPage clickOnCheckOut() {
		action.JSClick(driver, proceedToCheckOutBtn);
		return new OrderPage(driver);
	}
}
