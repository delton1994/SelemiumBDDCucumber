package com.baseclass.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTests {

	// private WebDriver driver;

	@Test(dataProvider = "testdata")
	public void testData(int a, int b, int c) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}

	@DataProvider(name = "testdata")
	public Object[][] getData() {

		return new Object[][] { { 1, 2, 3 }, { 4, 5, 6 } };

	}

	@AfterTest
	public void tearDown() {

	}

}
