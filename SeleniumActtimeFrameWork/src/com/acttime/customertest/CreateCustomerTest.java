package com.acttime.customertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acttime.genericlib.BaseClass;
import com.acttime.objectrepositorylib.CreateNEwCustomerPage;
import com.acttime.objectrepositorylib.HomePage;
import com.acttime.objectrepositorylib.Login;
import com.acttime.objectrepositorylib.TaskList;

public class CreateCustomerTest extends BaseClass{
	
	@Test
	public void createCustomerTest() throws Throwable{
		//read data from Excel
	  String customerNAme = fLib.getExcelData("Sheet1", 1, 2);
	  
	  //step 2  :click on Task image
	  HomePage hp = PageFactory.initElements(driver, HomePage.class);
	  hp.navigateToTaskPage();
	  //step 3 : navigate create new Customer Page
	  TaskList tl = PageFactory.initElements(driver, TaskList.class);
	  tl.navigateToCreateNewCustomerPage();
	  //step 4 : create new Customner
	  CreateNEwCustomerPage cp = PageFactory.initElements(driver, CreateNEwCustomerPage.class);
	  cp.createCustomer(customerNAme);
	  //step 5: verify
	  String actCustomerNAme = tl.getCustomnerNameDetails().getText();
	  Assert.assertEquals(actCustomerNAme, customerNAme);
	  
	}
	
	@Test
	public void cerateCustomerWithDescrition() throws Throwable{
	  String customerNAme = fLib.getExcelData("Sheet1", 4, 2);
	  String customerDescr = fLib.getExcelData("Sheet1", 4, 3);
	  //step 2  :click on tast image
	  HomePage hp = PageFactory.initElements(driver, HomePage.class);
	  hp.navigateToTaskPage();
	  //step 3 : navigate create new Customer Page
	  TaskList tl = PageFactory.initElements(driver, TaskList.class);
	  tl.navigateToCreateNewCustomerPage();
	  //step 4 : create new Customner with Desc
	  CreateNEwCustomerPage cp = PageFactory.initElements(driver, CreateNEwCustomerPage.class);
       cp.createCustomer(customerNAme, customerDescr);
 	  //step 5: verify
 	  String actCustomerNAme = tl.getCustomnerNameDetails().getText();
 	  Assert.assertEquals(actCustomerNAme, customerNAme);
	  //step 5: verify
	}

}
