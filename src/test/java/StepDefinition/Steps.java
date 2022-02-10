package StepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.pom.example.PageAmazon;
import com.pom.example.PageGoogle;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {

	private WebDriver driver;
	private PageAmazon pageAmazon;
	static ExtentReports extent;
	static ExtentTest test;

	@Before
	public void initDriver() {
	extent = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
	test = extent.startTest("Steps");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	//driver.get("https://www.google.com");
	pageAmazon = new PageAmazon(driver);
	}
//	
//	Steps(Scenario scenario){
//		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		//pgGoogle = new PageGoogle(driver);	
//	}
	@Given("^User opens the browser$")
	public void user_opens_the_browser() throws Throwable {
//
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
	}

	@Given("^User opens Google$")
	public void user_opens_Google() throws Throwable {
		driver.get("https://www.google.com");

		System.out.println("executed :  https://www.google.com");

	}

	@Given("^User verifies Gmail link exists$")
	public void user_verifies_Gmail_link_exists() throws Throwable {

		By gmailLink = By.xpath("(//*[@class='gb_d'])[1]");
		String gmailLinkName = driver.findElement(gmailLink).getText();
		System.out.println("gmailLinkName value is : " + gmailLinkName);

	}

	@Given("^User verifies Images link exists$")
	public void user_verifies_Images_link_exists() throws Throwable {
		System.out.println("executed but not implemented");

	}

	@Given("^User verifies About link exists$")
	public void user_verifies_About_link_exists() throws Throwable {
		System.out.println("executed but not implemented");

	}

	@Given("^User verifies Store link exists$")
	public void user_verifies_Store_link_exists() throws Throwable {
		System.out.println("executed but not implemented");

	}

	@Then("^User prints all the above link values$")
	public void user_prints_all_the_above_link_values() throws Throwable {
		System.out.println("executed but not implemented");

	}

	@Given("^I want to write a step with name(\\d+)$")
	public void i_want_to_write_a_step_with_name(int arg1) throws Throwable {
		System.out.println("executed" + arg1);

	}

	@When("^I check for the (\\d+) in step$")
	public void i_check_for_the_in_step(int arg1) throws Throwable {
		System.out.println("executed" + arg1);

	}

	// below codes are CNN
	@Given("^User opens CNN$")
	public void user_opens_CNN() throws Throwable {
		driver.get("https://www.cnn.com");
	}

	// below codes are for Amazon
	@Given("^User opens Amazon$")
	public void user_opens_Amazon() throws Throwable {
		System.out.println("The method started user_opens_Amazon() ");
		if (pageAmazon.getWebTitle().contains("Amazon")) {
			test.log(LogStatus.PASS, "Amazon page is available");
			} else {
			test.log(LogStatus.FAIL, "Amazon page is not available");
			}
		driver.get("https://www.amazon.com/");
		System.out.println("Executed: Open Executed");
	}

	@Given("^User verifies Amazon title exists$")
	public void user_verifies_Amazon_title_exists() throws Throwable {
		if (pageAmazon.getWebTitle().contains("Amazon")) {
			test.log(LogStatus.PASS, "Amazon page is available");
			} else {
			test.log(LogStatus.FAIL, "Amazon page is not available");
			}
		System.out.println((pageAmazon.getWebTitle() != " ") ? "Excuted: Amazon Title" : " Amazon Title Failed");
	}

	@Given("^User verifies Cart link exists$")
	public void user_verifies_Cart_link_exists() throws Throwable {
		if (pageAmazon.checkCartLink().contains("Cart")) {
			test.log(LogStatus.PASS, "Amazon Cart Link is available");
			} else {
			test.log(LogStatus.FAIL, "Amazon Cart Link is not available");
			}
	    System.out.println((pageAmazon.checkCartLink() != " ") ? "Excuted: CartLink" : " Cart Failed");
	}

	@Given("^User verifies Address link exists$")
	public void user_verifies_Address_link_exists() throws Throwable {
		if (pageAmazon.checkAddressLink().contains("Select your address")) {
			test.log(LogStatus.PASS, "Address Link is available");
			} else {
			test.log(LogStatus.FAIL, "Address Link is not available");
			}
		System.out.println((pageAmazon.checkAddressLink() != " ") ? "Excuted: Address Link" : "Failed: Address Link");
	}

	@Given("^User verifies Description link exists$")
	public void user_verifies_Description_link_exists() throws Throwable {
		if (pageAmazon.getWebTitle().contains("Amazon")) {
			test.log(LogStatus.PASS, "Description Link is available");
			} else {
			test.log(LogStatus.FAIL, "Description Link is not available");
			}
		System.out.println((pageAmazon.checkDescLinkText() != " ") ? "Excuted Description Link" : "Failed Description Link");
	}

	@Given("^User verifies viewable nav links exists$")
	public void user_verifies_viewable_nav_links_exists() throws Throwable {
		List<WebElement> list = pageAmazon.checkNavEle();
		List<String> list2 = pageAmazon.getListEle(list);
		int count =0;
		System.out.println("Checking for 14 nav elements");
		
		for(String item: list2) {
		System.out.println((item!= " ") ? "Excuted listItem[" +count+"] Link" : "Failed listitem[" +count+"] Link");
		count++;
		}

	}

	@Then("^User prints all above links$")
	public void user_prints_all_above_links() throws Throwable {
		//System.out.println((pageAmazon.checkAddressLink())+ "\n" + );
	}

	@Given("^I am on the Amazon home page$")
	public void i_am_on_the_Amazon_home_page() throws Throwable {
		String amazonTitle = "Amazon.com. Spend less. Smile more.";
		System.out.println((pageAmazon.getWebTitle()==amazonTitle) ? "Excuted Amazon Title test" : "Failed Amazon Title test");

	}

	@When("^I check the list of viewable elements against a static list$")
	public void i_check_the_list_of_viewable_elements_against_a_static_list() throws Throwable {
		// ???

	}

	@Then("^I verify the status with <status>$")
	public void i_verify_the_status_with_status() throws Throwable {
		// ???

	}
	
	@After
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
