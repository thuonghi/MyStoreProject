package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	private static WebDriver driver;
	public static Properties prop;
	private Actions action;
	
	
	@BeforeTest
	
	public WebDriver getDriver() {
	    return driver;
	}

	
	//launch the application
	public static WebDriver launchApp(String browser) {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		
		if (browserName.contains("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.contains("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browserName.contains("IE")) {
			driver = new InternetExplorerDriver();
		}
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
		return driver;
	}	
}
