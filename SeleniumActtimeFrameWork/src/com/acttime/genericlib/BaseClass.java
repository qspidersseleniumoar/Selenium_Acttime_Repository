package com.acttime.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.acttime.genericlib.FileLib;
import com.acttime.objectrepositorylib.HomePage;
import com.acttime.objectrepositorylib.Login;

public class BaseClass {
	public static WebDriver driver;
	public static FileLib fLib = new FileLib();
	
	
/*	 
	@Parameters("browser")
	 @BeforeTest
		public void configBT(String bNAme){
			if(bNAme.equals("firefox")){
				driver = new FirefoxDriver();
			}else if(bNAme.equals("chrome")){
				driver = new ChromeDriver();
			}else if(bNAme.equals("ie")){
				driver = new InternetExplorerDriver();
				
			}
		}*/
	
	@BeforeClass
	public void configBc() throws Throwable{
		String browsername = fLib.getPropertyKeyValue("browser");
		if(browsername.equals("firefox")){
			driver = new FirefoxDriver();
		}else if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		    driver = new ChromeDriver();
		}else if(browsername.equals("ie")){
		    driver = new InternetExplorerDriver();
		}
		    driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
	public void configBM() throws Throwable{
		String URL = fLib.getPropertyKeyValue("url");
		String USER = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       Login lp = PageFactory.initElements(driver, Login.class);
       lp.loginToApp(USER, PASSWORD);
       Thread.sleep(2000);
	}
	
	@AfterMethod
	public void configAm() throws Throwable{
		Thread.sleep(2000);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.logout();
	}
	
	@AfterClass
	public void configAc(){
		driver.close();
	}

}
