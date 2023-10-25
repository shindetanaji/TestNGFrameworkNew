package com.qc.testng.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import com.qc.testng.utils.TestUtil;

public class BaseIntegration {

	WebDriver driver;
	WebElement email, pass, signin, logout;
	WebElement rLink, rName, rMobile, rEmail, rPass, rSubmit;
	TestUtil test = new TestUtil();
	Properties prop;
	String tName;
	
	
	public void doSetup() throws IOException {
		prop = test.readProp();
		if(prop.getProperty("browser").equals("Chrome")) {
			driver = new ChromeDriver();
		}else if(prop.getProperty("browser").equals("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("siteURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@DataProvider
	public Object[][] loginTestData() throws IOException{
		return test.readTestData("loginData");
	}
	
	@DataProvider
	public Object[][] registerTestData() throws IOException{
		return test.readTestData("registerData");
	}
	
}
