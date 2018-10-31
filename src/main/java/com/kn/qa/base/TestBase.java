package com.kn.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.kn.qa.util.TestUtil;
import com.kn.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("F:\\eclipse-workspace\\com.test.kn\\src\\main\\java\\com\\kn\\qa\\resources\\config.properties");
			prop.load(fis);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void  Initialization() throws MalformedURLException{

		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			driver= new ChromeDriver();
		}else if (browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckopath"));
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicity_Wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
