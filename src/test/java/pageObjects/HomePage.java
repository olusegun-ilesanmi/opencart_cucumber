package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
		
		
		//Elements locator
		
		By link_MyAccount = By.xpath("//span[normalize-space()='My Account']");
		By link_Register = By.xpath("//a[normalize-space()='Register']");
		By link_login = By.xpath("//a[normalize-space()='Login']");
		
		
		
		public void clickMyAccount() {
			driver.findElement(link_MyAccount).click();
		}
		
		public void clickRegister() {
			driver.findElement(link_Register).click();
		}
		
		public void clickLogin() {
			driver.findElement(link_login).click();
		}
	}

	

