package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.datapointer.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTest extends BaseClass{
	private WebDriver driver;
	private IndexPage index;
	private SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String productName) throws Throwable {
		Log.startTestCase("productAvailabilityTest");
		index= new IndexPage(driver);
		searchResultPage=index.searchProduct(productName);
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}

}
