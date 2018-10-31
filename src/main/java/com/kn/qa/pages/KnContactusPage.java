package com.kn.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.kn.qa.base.TestBase;



public class KnContactusPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Contact us')]")
	WebElement Contactus_link;

	@FindBy(id="title_mr")
	WebElement Title;

	@FindBy(id="first-name")
	WebElement FirstName;

	@FindBy(id="last-name")
	WebElement LastName;

	@FindBy(id="email")
	WebElement Email;

	@FindBy(id="phone-country-code")
	WebElement PhoneCountrycode;

	@FindBy(id="phone-number")
	WebElement Phonenumber;

	@FindBy(id="address")
	WebElement Address;

	@FindBy(id="postal-code")
	WebElement Postalcode;

	@FindBy(id="city")
	WebElement City;

	@FindBy(id="country")
	WebElement Country;

	@FindBy(id="company")
	WebElement Company;

	@FindBy(id="industry-button")
	WebElement Industrybutton;

	@FindBy(id="your-request")
	WebElement yourrequest;

	@FindBy(id="accept-promotional-communication")
	WebElement acceptbutton;

	@FindBy(id="powermailcaptcha")
	WebElement powermailcaptcha;

	@FindBy(xpath="//input[@value='Next step']")
	WebElement Nextbutton;

	// Initializing the Page Objects:
	public KnContactusPage() {
		PageFactory.initElements(driver, this);
	}

	public void Contactus_Link() {
		Contactus_link.click();
	}
	public void createNewContact(String ftName, String ltName, String email,String pcode,String city, String country, String company,String request ){

		FirstName.sendKeys(ftName);
		LastName.sendKeys(ltName);
		Email.sendKeys(email);
		
		Postalcode.sendKeys(pcode);
		City.sendKeys(city);
		Country.sendKeys(country);
		Company.sendKeys(company);
		
		yourrequest.sendKeys(request);
		acceptbutton.click();

		Nextbutton.click();

	}

	
}
