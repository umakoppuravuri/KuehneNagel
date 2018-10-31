package com.kn.qa.tests;

import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.kn.qa.base.TestBase;
import com.kn.qa.pages.KnContactusPage;
import com.kn.qa.pages.KnLoginPage;
import com.kn.qa.util.TestUtil;

public class KnContactusPageTest extends TestBase{

	KnLoginPage loginPage;
	KnContactusPage contactsPage;
	TestUtil testutil = new TestUtil();

	String sheetName = "contactus";

	public KnContactusPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException, InterruptedException {

		Initialization();
		contactsPage = new KnContactusPage();
		loginPage = new KnLoginPage();
	}

	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=1, dataProvider="getCRMTestData")
	public void Contactus_SalesTeam(String ftName, String ltName, String email,String pcode,String city, String country, String company,String request){

		contactsPage.Contactus_Link();
		contactsPage.createNewContact(ftName, ltName, email, pcode, city, country, company, request);

	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}




}
