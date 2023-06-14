package pageObjects;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	
   WebDriver driver; //Instantiate WebDriver 
	
    //create constructor 
	BasePage(WebDriver driver) 
	{
		
		this.driver = driver;	
}
	
}
