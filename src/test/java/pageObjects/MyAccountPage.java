package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	By txt_Account_message = By.xpath("//h2[normalize-space()='My Account']");
	By link_logout = By.linkText("Logout");
	
	
	public boolean verifyMyAccountPageExists() {
		try 
		{
		    boolean messageHeading = driver.findElement(txt_Account_message).isDisplayed();
		    return messageHeading;
		}
		catch (Exception e) {
			return (false);
		} 
		
	}
	
	
	public void clickLogoutButton() {
		driver.findElement(link_logout).click();
	}
	
	

}
