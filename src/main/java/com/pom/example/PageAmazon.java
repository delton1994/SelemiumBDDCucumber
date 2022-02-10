package com.pom.example;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class PageAmazon {

	protected WebDriver driver;
	private By cartLink = By.xpath("(//*[@class='nav-line-2'])[3]");
	private By addressLink = By.xpath("//*[@id='glow-ingress-line2']");
	private By descLinkText = By.xpath("//*[@id='swm-link']");

	static final Logger logger = LogManager.getLogger(PageAmazon.class);

	public PageAmazon(WebDriver driver) {
		this.driver = driver;
//		if (!driver.getTitle().equals("amazon")) {
//			logger.info("Amazon home pass");
//			throw new IllegalStateException(
//					"This is not the homepage of logged in user, The correct homepage is " + driver.getCurrentUrl());
//		} else {
//			logger.error("Not able to open Amazon. Current application loaded is: " + driver.getCurrentUrl());
//		}
	}

	public PageAmazon manageprofile() {
		return new PageAmazon(driver);
	}

	public String checkCartLink() {
		return driver.findElement(cartLink).getText();

	}

	public String checkAddressLink() {
		return driver.findElement(addressLink).getText();
	}

	public String checkDescLinkText() {
		return driver.findElement(descLinkText).getText();
	}

	public String getWebTitle() {
		String title = driver.getTitle();
		
		logger.info("title = " + title);
		return title;
	}

	public List<WebElement> checkNavEle() {
		List<WebElement> navBarEle = new ArrayList<WebElement>();
		for (int j = 8; j < 22; j++) {
			navBarEle.add(driver.findElement(By.xpath("(//*[@tabindex='0'])[" + j + "]")));
		}
		return navBarEle;
	}

	public List<String> getListEle(List<WebElement> ele) {
		int count = ele.size();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			list.add(ele.get(i).getText() + " \n");
		}
		return list;
	}
}
