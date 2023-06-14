package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	By input_txt_email = By.name("email");
	By input_txt_password = By.name("password");
	By btn_login = By.xpath("//input[@value='Login']");
	
	
	public void enterEmail(String email) {
		driver.findElement(input_txt_email).sendKeys(email);
	}
	
	public void enterPassword(String pw) {
		driver.findElement(input_txt_password).sendKeys(pw);
	}
	
	public void clickLoginButton() {
		driver.findElement(btn_login).click();
	}
	
	/*public String verifyAccountTilte() {
		String title = driver.getTitle();
		return title;
	} */

	
}
