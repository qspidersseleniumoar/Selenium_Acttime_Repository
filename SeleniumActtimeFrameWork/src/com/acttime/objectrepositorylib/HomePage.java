package com.acttime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {
	
	@FindBy(xpath="//div[text()='TASKS']")
	private WebElement taskImg;
	
	@FindBy(xpath="//div[text()='USERS']")
	private WebElement userImg;
	
	@FindBy(xpath="//a[@id='logoutLink']")
	private WebElement logoutLnk;
	
	@FindBy(xpath="//img[contains(@src,'logo.png')]")
	private WebElement logoImg;
	
	
	
	public WebElement getLogoImg() {
		return logoImg;
	}
	public void navigateToTaskPage(){
		taskImg.click();
	}
	public void navigateToUSersPage(){
		userImg.click();
	}
	public void logout(){
		logoutLnk.click();
	}

}
