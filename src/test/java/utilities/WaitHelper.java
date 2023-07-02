package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
public WebDriver driver;
	
	public WaitHelper(WebDriver rdriver) {
		this.driver=rdriver;
		}

	public void WaitFOrElement(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait (driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
