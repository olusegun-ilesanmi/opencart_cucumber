package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	//Locators
	By input_first_name = By.name("firstname");
	By input_last_name = By.name("lastname");
	By input_email = By.name("email");
	By input_phonenumber = By.name("telephone");
	By input_password = By.name("password");
	By input_confirmpassword = By.name("confirm");
	By input_checkagreement = By.name("agree"); //terms and agreement
	By btn_submit = By.xpath("//input[@value='Continue']");
	By txt_msg_confirmation = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
	By link_btn_continue = By.xpath("//a[normalize-space()='Continue']");
	
	
	
	//Action methods
	public void setUserName(String fName, String lName) {
		driver.findElement(input_first_name).sendKeys(fName);
		driver.findElement(input_last_name).sendKeys(lName);
		
	}
	
	public void setUserEmail(String email) {
		driver.findElement(input_email).sendKeys(email);
		
	}
	public void setUserPhoneNumber(String pNumber) {
		driver.findElement(input_phonenumber).sendKeys(pNumber);
		
	}
	public void setUserPassword (String pWord) {
		driver.findElement(input_password).sendKeys(pWord);
	}
	public void confirmUserPassword (String confirmPWord) {
		driver.findElement(input_confirmpassword).sendKeys(confirmPWord);
	}
	
	public void verifyTerms() {
		
		driver.findElement(input_checkagreement).click();
		
	}
	
	public void clickLoginButton() {
		
		driver.findElement(btn_submit).click();
	}
	
	
	public String verifyMessage() {
		try {
		String message = driver.findElement(txt_msg_confirmation).getText();
		return message;	
		}
		catch (Exception e) {
			return e.getMessage();
		} 
	
	} 
	
	public void completeRegistration() {
		driver.findElement(link_btn_continue).click();
		} 

}
