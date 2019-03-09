package com.acttime.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverCommonLib extends BaseClass{
	
	public void waitForPageToLoad(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void select(WebElement elemnet, String options){
		Select sel = new Select(elemnet);
		sel.selectByVisibleText(options);
	}

}
