package com.pom.example;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.pom.example.PageAmazon;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAmazon {

	WebDriver driver;
	PageAmazon pgAmazon;
	
	public TestAmazon() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		pgAmazon = new PageAmazon(driver);
	}
	
	@Test(priority =1)
	public void testTitle() {
		Assert.assertEquals(pgAmazon.getWebTitle(), "Amazon.com. Spend less. Smile more.");
		
	}
	
	@Test(priority=2)
	public void testCartLink() {
		Assert.assertEquals(pgAmazon.checkCartLink(), "Cart");
	}
	
	@Test(priority=3)
	public void testAddressLink() {
		Assert.assertEquals(pgAmazon.checkAddressLink(), "Select your address");
	}
	
	@Test(priority=4)
	public void testDescLink() {
		Assert.assertEquals(pgAmazon.checkDescLinkText(),"Black is remarkable");
	}
	//Check with Sharath for effectiveness: would it be better t assertEquals with lists
	@Test(priority=5)
	public void testNavEle() {
		String chAgainst = ("Best Sellers\r\n"+ "Amazon Basics\r\n"+ "New Releases\r\n"+ "Customer Service\r\n"+ "Today's Deals\r\n"
				+ "Prime\r\n"+ "Books\r\n"+ "Music\r\n"+ "Amazon Home\r\n"+ "Registry\r\n"+ "Gift Cards\r\n"+ "Kindle Books\r\n"
				+ "Fashion\r\n"+ "Toys & Games \r\n" );
		List<WebElement> list = pgAmazon.checkNavEle();
		List<String> toCheck = pgAmazon.getListEle(list);
		
		Assert.assertEquals(toCheck, chAgainst, "NavBar items are incorrect.");
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}

}
