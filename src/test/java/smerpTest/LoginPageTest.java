package smerpTest;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import smerpBase.Base;
import smerpPageObjects.HomePageObj;


public class LoginPageTest extends Base {
	


	protected LoginPageTest() throws IOException {
		//super();
		// TODO Auto-generated constructor stub
	}

	@Test (dependsOnMethods = "Login")
	public void LoginValidation() throws IOException, InterruptedException  {
		lgn.loginValidation();
	
	}
	
	@Test
	public void Login() throws IOException, InterruptedException  {
		
		HomePageObj home = lgn.login();
		Thread.sleep(2000);
		Assert.assertEquals(home.HomePgTitle(), "https://rahulshettyacademy.com/client/dashboard/dash");
	}

}
