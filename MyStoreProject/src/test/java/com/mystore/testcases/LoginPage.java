package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.datapointer.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class LoginPage extends BaseClass {
	private WebDriver driver;
	private IndexPage indexPage;
	private com.mystore.pageobjects.LoginPage loginPage;
	private HomePage homePage;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage(driver);
		Log.info("user is going to click on SignIn");
		loginPage = indexPage.ClickOnSignIn();
		Log.info("Enter Username and Password");
		// homePage=loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		homePage = loginPage.login(uname, pswd, homePage);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Sucess");
		Log.endTestCase("loginTest");
	}

}
