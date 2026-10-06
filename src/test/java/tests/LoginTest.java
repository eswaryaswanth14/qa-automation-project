package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelReader;

public class LoginTest extends BaseTest{

	LoginPage loginPage;
	HomePage homePage;

	@BeforeSuite
	public void beforeSuiteDemo() {
		System.out.println("Before Suite");
	}

	@BeforeTest
	public void test3() {
		System.out.println("Before Test");
	}

	@BeforeClass
	public void testing() {
		System.out.println("Before class");
	}

	@BeforeMethod(alwaysRun = true)
	public void initializePage() {
		loginPage=new LoginPage(driver);

	}

	@DataProvider(name="loginData")
	public Object[][] data() throws IOException{
		return ExcelReader.getExceldata();
		};



	@Test(groups="smoke")
	public void enteringCredentialsTest() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginPage.enterCredentails("Admin", "admin123");
		homePage=loginPage.clickLogin();
		boolean isFound=homePage.isDashboard();
		Assert.assertTrue(isFound,"Dashboard not displayed");
	}
	@Test(dataProvider="loginData",groups="smoke")
	public void invalidCredentails(String un,String pwd,String expectedResults) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		if(expectedResults.equals("Valid")) {
			loginPage.enterCredentails(un,pwd);
			homePage=loginPage.clickLogin();
			boolean isFound=homePage.isDashboard();
			Assert.assertTrue(isFound,"Valid Credentails");
		}
		else {
			loginPage.enterCredentails(un,pwd);
			loginPage.clickLogin();
//			System.out.println("Current Title:"+driver.getTitle());
//			System.out.println("Current UEL:"+driver.getCurrentUrl());
//			System.out.println("Page Source:"+driver.getPageSource().contains("Invalid credentials"));
			String text=loginPage.invalidMethod();
			Assert.assertEquals(text, "Invalid credentials");
		}




	}

	@AfterClass
	public void testing2() {
		System.out.println("After Class");
	}
	@AfterSuite
	public void afterSuiteDemo() {
		System.out.println("After Suite");
	}

//login feature changed
	}
	



