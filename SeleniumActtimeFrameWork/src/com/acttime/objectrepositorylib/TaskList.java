package com.acttime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskList {
	

	
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustomerBtn;
	
	@FindBy(xpath="//div[@class='navigationLinks']/following-sibling::div[1]")
	private WebElement customnerNameDetails;
	
	
	public WebElement getCustomnerNameDetails() {
		return customnerNameDetails;
	}


	public void navigateToCreateNewCustomerPage(){
		addNewBtn.click();
		newCustomerBtn.click();
	}

}
