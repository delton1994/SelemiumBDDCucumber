package com.baseclass.selenium;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(com.baseclass.selenium.Listener.class)
public class ClassTests {
	
//	public static void main(String args[]) {
//		
//	}
	
	int sum = 0;
	int a = 5;
	int b = 7;

	
	@Test
	public void sum() {
		sum = a + b;
		System.out.println(sum);
	}

	@Test
	public void testSum() {
		System.out.println("Test case has been failed");
		Assert.assertEquals(12, sum);
	}
}