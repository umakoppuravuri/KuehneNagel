package com.kn.qa.tests;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.kn.qa.base.TestBase;
import com.kn.qa.pages.KnLoginPage;


public class KnLoginPageTest extends TestBase{
	KnLoginPage loginPage;
	
	public KnLoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException{
		Initialization();
		loginPage = new KnLoginPage();	
	}

	@Test(priority=1)
	public void HomePage_TitleVerify_Test(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Kuehne + Nagel: Homepage");
		System.out.println("Page Title is " +  title);
	}

	@Test(priority=2)
	public void loginTest() throws InterruptedException{
		loginPage.login(prop.getProperty("Email"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
