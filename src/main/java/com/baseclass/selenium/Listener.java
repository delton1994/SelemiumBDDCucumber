package com.baseclass.selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("1. onTestStart of test cases and its details are : " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("2. onTestSuccess of test cases and its details are : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("3. onTestFailure of test cases and its details are : " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
 
		System.out.println("4. onTestSkipped of test cases and its details are : " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("5. onTestFailedButWithinSuccessPercentage of test cases and its details are : " + result.getName());
	}

	public void onStart(ITestContext context) {
		System.out.println("6. onStart of context: " + context.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("7. onFinish of context : " + context.getName());
	}
}