package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	private WebDriver driver;
	private Action action;

	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
		action = new Action(driver);
	}
	
	public boolean isProductAvailable() {
		return action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		action.click(productResult);
		return new AddToCartPage(driver	);
	}
}
