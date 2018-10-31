package com.kn.qa.pages;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kn.qa.base.TestBase;


public class KnLoginPage extends TestBase{

	//Page Factory - OR:

	@FindBy(xpath="//*[@aria-label=\"KN Login\"]")
	WebElement myKN_Button;

	@FindBy(id="username-field")
	WebElement Emailaddress;
	
	@FindBy(id="password-field")
	WebElement Password;

	@FindBy(id="login-button")
	WebElement Login;

	@FindBy(id="registration-link")
	WebElement signUpBtn;

	//Initializing the Page Objects:
	public KnLoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public void login(String un, String pwd) throws InterruptedException{

		myKN_Button.click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		Emailaddress.sendKeys(un);
		Password.sendKeys(pwd);

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Login);

	}

}
