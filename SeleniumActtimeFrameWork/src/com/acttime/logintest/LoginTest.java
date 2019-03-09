
package com.acttime.logintest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acttime.genericlib.BaseClass;
import com.acttime.objectrepositorylib.HomePage;

public class LoginTest extends BaseClass{
	
	@Test
	public void verifyHomePAge() throws Throwable{
		String expHomePage = fLib.getExcelData("sheet1", 7, 2);
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expHomePage);
		
	}
	
	@Test
	public void verifyLogoInHomePAge(){
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		boolean status = hp.getLogoImg().isDisplayed();
		Assert.assertTrue(status);
	}


	
}
