package com.baseclass.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
//import jdk.internal.jline.internal.Log;

public class SeleniumSimpleWebDriverManager {
	static ExtentReports extent;
	static ExtentTest test;
	static WebDriver driver;

	static final Logger logger = LogManager.getLogger(SeleniumSimpleWebDriverManager.class);

	@BeforeClass
	public static void startTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		extent = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = extent.startTest("SeleniumSimpleWebDriverManager");
	}

	@Test
	public void testGoogle() {

		driver.get("https://www.google.com");

		if (driver.getTitle().equals("Google")) {
			test.log(LogStatus.PASS, "Google Search page is available");
		} else {
			test.log(LogStatus.FAIL, "Google Search page is available is not available");
		}

		clickOnGmailLink();
		navigateBack();
		clickOnImages();

	}

	private void clickOnGmailLink() {
		By gmailLink = By.xpath("(//*[@class='gb_d'])[1]");
		try {
			driver.findElement(gmailLink).click();
			test.log(LogStatus.PASS, "Clicked on gmailLink");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Clicked on gmailLink Failed");
		} finally {
			System.out.println("Click on gmailLink Test executed");
		}

	}

	private void navigateBack() {

		try {
			driver.navigate().back();
			test.log(LogStatus.PASS, "Browser Navigate back");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Browser Navigate back Failed");
		} finally {
			System.out.println("Browser Navigate back executed");
		}

	}

	private void clickOnImages() {
		By imagesLink = By.xpath("(//*[@class='gb_d'])[2]");

		try {
			driver.findElement(imagesLink).click();
			test.log(LogStatus.PASS, "Clicked on Images");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Clicked on Images Failed");
		} finally {
			System.out.println("Click on Images Test executed");
		}

	}

	@Test
	private void loggerTest() {
		logger.info("info");
		logger.error("error");
		logger.debug("debug");
		logger.fatal("fatal");

	}

	@AfterClass
	public void endReport() {
		try {
			driver.close();
			test.log(LogStatus.PASS, "Driver closed");
		} catch (Exception ex) {
			test.log(LogStatus.FAIL, "Driver close Failed");
		} finally {
			System.out.println("Driver close task is executed");
		}
		extent.endTest(test);
		extent.flush();
		extent.close();
	}

}
