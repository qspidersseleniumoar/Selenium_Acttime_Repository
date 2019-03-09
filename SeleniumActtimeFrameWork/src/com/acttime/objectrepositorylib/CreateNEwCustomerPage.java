
package com.acttime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNEwCustomerPage {

	@FindBy(id="customerLightBox_nameField")
	private WebElement custmerNAmeEdt;
	
	@FindBy(id="customerLightBox_descriptionField")
	private WebElement custmerDescriptionEdt;
	
	@FindBy(id="customerLightBox_commitBtn")
	private WebElement createCustomerBtn;
	//overloading
	public void createCustomer(String customerName){
		custmerNAmeEdt.sendKeys(customerName);
		createCustomerBtn.click();
	}
	
	public void createCustomer(String customerName,String description){
		custmerNAmeEdt.sendKeys(customerName);
		custmerDescriptionEdt.sendKeys(description);
		createCustomerBtn.click();
	}
	
	
	
}
