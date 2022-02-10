package com.baseclass.basic.selenium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGoogleTestsLocatorsOrganizedADesiredCaps {

	private WebDriver driver;
	By imagesLink = By.xpath("(//*[@class='gb_d'])[2]");
	By gmailLink = By.xpath("(//*[@class='gb_d'])[1]");
	String urlOne = "https://www.google.com";
	String urlTwo = "https://www.amazon.com";
	
	List<String> storeNames;
	Map<String, String> storeMap;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.merge(caps);
		driver = new ChromeDriver(options);
	}

	@Test
	public void testGoogleHomePage() {
		storeNames = new ArrayList<String>();
		storeMap = new LinkedHashMap<String, String>();

		driver.get(urlOne);

		String imagesLinkName = driver.findElement(imagesLink).getText();
		driver.findElement(imagesLink).click();

		driver.navigate().back(); // use to navigate back to Google home page.

		String gmailLinkName = driver.findElement(gmailLink).getText();
		driver.findElement(gmailLink).click();
		
		
		
		/**
		 * Use List
		 */
		storeNames.add(imagesLinkName);
		storeNames.add(gmailLinkName);
		for (String printStroneNames : storeNames) {
			System.out.println("ArrayList WebElement Name is : " + printStroneNames);
		}
		
		

		/**
		 * Use Map
		 * 
		 */
		storeMap.put("imgLinkName", imagesLinkName);
		storeMap.put("gmailLnkName", gmailLinkName);
		for (Map.Entry<String, String> mapValue : storeMap.entrySet()) {
			System.out.println(
					"WebElement Name is : " + mapValue.getKey() + " &  WebElement Value is : " + mapValue.getValue());
		}

		// expand Test automation for other elements in the google page - About, Store,
		// Google Search
		// Button , I'm Feeling Lucky , Advertising, Business ... Settings.

		driver.navigate().to(urlTwo);

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
