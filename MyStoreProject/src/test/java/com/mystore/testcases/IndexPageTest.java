package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass {
	private WebDriver driver;
	private IndexPage indexPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}

	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		Log.startTestCase("verifyLogo");
		indexPage = new IndexPage(driver);
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}

	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle = indexPage.getMyStoreTittle();
		Assert.assertEquals(actTitle, "My Store1");
		Log.endTestCase("verifyTitle");
	}
}
