package base;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;
	@BeforeMethod(alwaysRun = true)
	public void initializeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en-US");
		options.setExperimentalOption("prefs",
		        Map.of("intl.accept_languages", "en-US,en"));
		driver=new ChromeDriver();
		System.out.println("Browser initialized");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
