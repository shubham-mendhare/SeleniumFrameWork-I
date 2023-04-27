package smerpUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Utility {
	WebDriver driver;
	
	public Utility(WebDriver driver) throws IOException {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public WebElement waitVisibilityEle(By by, int time) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
		.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public WebElement waitVisibilityEle(WebElement ele, int time) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
		.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public Boolean waitInvisibilityEle(By by, int time) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
		.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public Boolean waitInvisibilityEle(WebElement ele, int time) {
		return new WebDriverWait(driver, Duration.ofSeconds(time))
		.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	
}
