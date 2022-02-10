package com.baseclass.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//import jdk.internal.jline.internal.Log;

public class SeleniumGoogleTests {

	static final Logger logger = LogManager.getLogger(SeleniumGoogleTests.class);
	

	@Test
	public void testGoogle() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		
		
		
		By imagesLink = By.xpath("(//*[@class='gb_d'])[2]");		
		driver.findElement(imagesLink).click();
		
		driver.navigate().back();
		
		By gmailLink = By.xpath("(//*[@class='gb_d'])[1]");	
		driver.findElement(gmailLink).click();
		
		driver.close();
		
		
		
		
		
		
		
		


		
	}
	
	@AfterTest
	public void tearDown() {
		
		logger.info("info");
		logger.error("error");
		logger.debug("debug");
		logger.fatal("fatal");
	}
	
	

}
