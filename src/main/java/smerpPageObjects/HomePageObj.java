package smerpPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageObj {
	WebDriver driver;
	public HomePageObj(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String HomePgTitle() {
		
		return driver.getCurrentUrl();
		
	}

}
