package com.kn.qa.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kn.qa.base.TestBase;
import com.kn.qa.pages.KnContactusPage;
import com.kn.qa.pages.KnLoginPage;
import com.kn.qa.util.TestUtil;

public class KnContactcusTest extends TestBase {
	
	KnLoginPage loginPage;
	KnContactusPage contactsPage;
	TestUtil testutil = new TestUtil();
	
	public KnContactcusTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException{
		Initialization();
		loginPage = new KnLoginPage();	
	}

	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();
		
		driver.findElement(By.id("title_mr")).click();
		driver.findElement(By.id("first-name")).sendKeys("Uma");
		driver.findElement(By.id("last-name")).sendKeys("K");
		driver.findElement(By.id("email")).sendKeys("Umakslenium@gmail.com");
		driver.findElement(By.id("phone-country-code")).sendKeys("+46");
		driver.findElement(By.id("phone-number")).sendKeys("0734860808");
		driver.findElement(By.id("address")).sendKeys("Solna");
		driver.findElement(By.id("postal-code")).sendKeys("17158");
		driver.findElement(By.id("city")).sendKeys("Stockholm");
		
		driver.findElement(By.id("country")).sendKeys("Sweden");
		/*Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("Sweden");*/
		
		driver.findElement(By.id("company")).sendKeys("KN Company");
		
		driver.findElement(By.id("your-request")).sendKeys("Test");
		driver.findElement(By.name("contact_sales[step-2-next]")).click();
		
				
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	

}
