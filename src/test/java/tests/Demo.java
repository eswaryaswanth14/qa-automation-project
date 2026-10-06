package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import utils.ScreenshotUtility;
import base.BaseTest;

import org.testng.annotations.Parameters;
import utils.ConfigReader;

public class Demo extends BaseTest {
	


	//	@Test
	//	public void login() {
	//		System.out.println("login method");
	//		
	//	}
	//	@Test(dependsOnMethods="login")
	//	public void homePage() {
	//		System.out.println("homePage");
	//	}
	//	@DataProvider(name="loginData")
	//	public Object[][] data(){
	//		return new Object[][] {
	//			{"admin","admin123","Invalid"},{"Admin","admin123","valid"},
	//			{"admin","Admin","Invalid"}
	//
	//		};
	//
	//	}
	//	
	//	@Test(dataProvider="loginData")
	//	public void login(String un,String pwd,String expectedResult) {
	//		System.out.println(un+"-->"+pwd);

	
	
	@Parameters("browser")
	@Test
	public void demoTest(String browser) throws IOException {
		ConfigReader cr=new ConfigReader();
		String url=cr.loadConfig();
		driver.get(url);
		ScreenshotUtility screenShot=new ScreenshotUtility(driver);
		screenShot.takeScreenShot("demo_test");
	}
	
	@Test
	public void test() {
		Assert.fail("Failed due to assertion");
	}
}


