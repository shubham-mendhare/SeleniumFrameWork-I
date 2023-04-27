package smerpBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import smerpPageObjects.HomePageObj;
import smerpPageObjects.LoginPageObj;
import smerpUtility.Utility;


public class Base 
{
 
	
	public Properties prop;
	public static WebDriver driver;
	public  LoginPageObj lgn ;
	public Utility ult;
	
	protected Base() throws IOException{
		prop=new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/smerpEnvVariable/GlobalVariabales.properties");
		prop.load(input);	
		ult=new Utility(driver);
	}
	
	public void intialization() throws IOException {
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		if(browser.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	@BeforeMethod
	public void init() throws IOException {
		Base bs = new Base();
		bs.intialization();
		lgn = new LoginPageObj(driver);
		
	}

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
