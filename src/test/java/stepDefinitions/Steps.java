package stepDefinitions;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;


public class Steps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;
	
	List<HashMap<String, String>> datamap;
	
	ResourceBundle rb;
	Logger logger;
	String br;
	
	
	
	@Before  //jUnit annotation that executes before starting test
	public void setUp() 
	{
	
		logger = LogManager.getLogger(this.getClass());
		
		//getting the browser properties from configuration file
		rb = ResourceBundle.getBundle("config"); 
		br = rb.getString("browser");
		
	}
	
	@After //jUnit annotation that executes after running test
	public void tearDown(Scenario scenario) 
	{
		System.out.println("Scenario Status is: " + scenario.getStatus());
		
		if (scenario.isFailed()) 
		{
		    TakesScreenshot ts = (TakesScreenshot) driver;
		    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES); //capture the screenshot and save in Byte format
		    scenario.attach(screenshot, "image/png" , scenario.getName()); //attach the screenshot, save it as PNG and attach the scenario name
		}
				
		driver.quit();
	}
	
	
	
	@Given("user launches browser")
	public void launchBrowser() 
	{
	    if (br.equals("chrome")) {
	    	driver = new ChromeDriver();
	    }
	    else if (br.equals("edge")) {
	    	driver = new EdgeDriver();
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	
	
	
	@Given("opens the URL {string}")
	public void open_URL(String url) 
	{
	  
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	

	@When("user navigates to myAccount menu dropdown")
	public void user_navigates_to_my_account_menu_dropdown()
	{
		
		logger.info("***Starting Login test***");
	   
		hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myAccount link");
		
	}

	
	@When("clicks on login")
	public void clickLoginlink() 
	{
	  
		hp.clickLogin();
		logger.info("clicked on login link");
	}

	@When("enters valid email as {string} and password as {string}")
	public void setEmailAndPassword(String email, String password) 
	{
		lp = new LoginPage(driver);
		lp.enterEmail(email);
		logger.info("Entered valid email");
		lp.enterPassword(password);
		logger.info("Entered valid password");
	   
	}

	@When("clicks on Login button")
	public void clickLoginButton() {
		
		lp.clickLoginButton();
		logger.info("clicked on login button");
	
	}

	@Then("user navigates to myAccount page")
	public void navigateToMyAccount() {
	   
		mp = new MyAccountPage(driver);
		boolean targetPage = mp.verifyMyAccountPageExists();
		
		if (targetPage) {
			logger.info("User logged in succesfuly: Login Passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("User was unable to login: Login Failed");
			Assert.assertTrue(false);
		}
		
		
		logger.info("***Finished Login test***");
	} 
	
	//** Login Data drive test using excel sheet
	
	@Then("user navigates to myAccount page by passing Email and Password with excel row {string}")
	public void navigateToMyAccountByPassingDataFromExcel(String rows) 
	{
		
		//Read the excel file using the path and getting the sheet name
		datamap = DataReader.data(System.getProperty("user.dir") + "/testData/Opencart_Login_Test_Data.xlsx", "Logintestdata"); 
		
		int index = Integer.parseInt(rows)-1; //Start getting the rows from the first row
		
		//getting the login data from the excel file
		String username= datamap.get(index).get("Email");
		String pword = datamap.get(index).get("Password");
		String expectedResult = datamap.get(index).get("Result");
		
		lp = new LoginPage(driver);
		lp.enterEmail(username);
		lp.enterPassword(pword);
		lp.clickLoginButton();
		
		try
		{
			
		    MyAccountPage myacc = new MyAccountPage(driver);
		    boolean targetPage = myacc.verifyMyAccountPageExists();
		 
		
		    if (expectedResult.equals("Valid")) {
		    	
			
			    if (targetPage == true) {
				MyAccountPage mp = new MyAccountPage(driver);
				mp.clickLogoutButton();
				Assert.assertTrue(true);
			    }
			    else {
			    	
				    Assert.assertTrue(false);
			    }
		    }
		
	     	if (expectedResult.equals("Invalid")) {
	     	
			
		     	if (targetPage == true) {
				myacc.clickLogoutButton();
				Assert.assertTrue(false);
		    	}
		
	        	else {
	        		
	           		Assert.assertTrue(true);
	           		
	         	}
		
	        }
	    }
		catch (Exception e) {
			Assert.assertTrue(false);
		}
		//driver.close();

     }
	
}
  

