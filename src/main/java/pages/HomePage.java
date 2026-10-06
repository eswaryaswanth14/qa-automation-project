package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	 public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }
	
	private By dashboard=By.xpath("//h6[text()='Dashboard']");
	public boolean isDashboard() {
		return driver.findElement(dashboard).isDisplayed();
	}

}
