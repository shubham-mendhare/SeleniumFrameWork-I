package smerpPageObjects;

import java.awt.RenderingHints.Key;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import smerpBase.Base;

public class LoginPageObj extends Base {
	
//	WebDriver driver;
	
	
	public LoginPageObj(WebDriver driver) throws IOException {
	//	this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(text(),'*Email is required')]")
	WebElement errUsername;
	
	@FindBy(xpath="//div[contains(text(),'*Password is required')]")
	WebElement errPassword;
	
	@FindBy(css = "div[aria-label=\"Incorrect email or password.\"]")
	WebElement IncorrectPassOrUsername;
	
	
	
	
	public void loginValidation() throws InterruptedException {
		username.sendKeys("asdas@dfsafasd.com");
		loginBtn.click();
		Assert.assertEquals(errPassword.getText(), "*Password is required");
		
		Actions action = new Actions(driver);
		username.sendKeys(Keys.CONTROL+"A");
		action.keyDown(Keys.BACK_SPACE).build().perform();
		//username.clear();
		
		password.sendKeys("asdsaadsad");
		loginBtn.click();
		Assert.assertEquals(errUsername.getText(), "*Email is required");
		
		password.sendKeys(Keys.CONTROL+"A");
		action.keyDown(Keys.BACK_SPACE).build().perform();
		
	//	password.clear();
		
		username.sendKeys("asdas@dfsafasd.com");
		password.sendKeys("asdsaadsad");
		loginBtn.click();
		
		Assert.assertTrue(IncorrectPassOrUsername.isDisplayed());
		
		username.sendKeys(Keys.CONTROL+"A");
		action.keyDown(Keys.BACK_SPACE).build().perform();
		
		password.sendKeys(Keys.CONTROL+"A");
		action.keyDown(Keys.BACK_SPACE).build().perform();
		
		ult.waitVisibilityEle(username, 5).sendKeys("Shubhamfdfdsafdsafdsafdsafdsafsafds");
		ult.waitVisibilityEle(password, 5).sendKeys("sdadsfdsfdsfdsafdsafsafdsafdsafdsafdsafdsafafds");
				
	}
	
	public HomePageObj login() {
	
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		return new HomePageObj(driver);
	}
	

}
