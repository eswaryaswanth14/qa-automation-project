package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtility {

	WebDriver driver;

	public ScreenshotUtility(WebDriver driver) {
		this.driver=driver;
	}
	public void takeScreenShot(String fileName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("ScreenShots/"+fileName+".png");
		Files.copy(source.toPath(), dest.toPath());
	}



}
