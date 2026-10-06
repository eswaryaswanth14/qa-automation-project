package pages;

import java.time.Duration;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtility;

public class LoginPage {


	WebDriver driver;
	WaitUtility waitUtility;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		waitUtility=new WaitUtility(driver);
	}

	private By userName=By.name("username");
	private By password=By.name("password");
	private By logIn=By.xpath("//button[@type='submit']");
	private By invalid=By.xpath("//p[text()='Invalid credentials']");
//	By invalid = By.xpath("//p[contains(normalize-space(), 'Invalid credentials')]");

	public void enterCredentails(String un,String pwd) {
		driver.findElement(userName).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
	}
	public HomePage clickLogin() {
		driver.findElement(logIn).click();
		return new HomePage(driver);
	}
	public String invalid() {
		return driver.findElement(invalid).getText();
	}
	public String invalidMethod() {
			waitUtility.waitForVisibility(invalid);
			return driver.findElement(invalid).getText();
		
	}
}
