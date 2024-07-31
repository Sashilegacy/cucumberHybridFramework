package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	
	
	
	
	@Given("User navigates to Register Account Page")
	public void User_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage=homePage.selecetRegisterOption();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
		
	}

	@When("User enter the below fields")
	public void User_enter_the_below_fields(DataTable dataTable)   {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		//registerPage=new RegisterPage(driver);
		
		
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		commonUtils=new CommonUtils();
		registerPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		
		registerPage.enterPassword(dataMap.get("password"));
		
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
		//Thread.sleep(3000);
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
	   // driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	   // driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	    //driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	   // driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}
	
	@When("User enter the below fields with duplicate email")
	public void User_enter_the_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		//registerPage=new RegisterPage(driver);
		
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailAddress(dataMap.get("email"));
		registerPage.enterTelephoneNumber(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
	    driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
	    driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	    driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	    driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));*/
	}

	@When("User selects Privacy Policy")
	public void User_selects_privacy_policy() {
		//registerPage=new RegisterPage(driver);
		
		registerPage.selectPrivacyPolicy();
		
		//driver.findElement(By.name("agree")).click();
	    
	}

	@When("User clicks on Continue button")
	public void User_clicks_on_continue_button() {
		//registerPage=new RegisterPage(driver);
		
		accountSuccessPage=registerPage.clickOnContinueButton();
		
		
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	   
	}

	@Then("User should get created successfully")
	public void User_should_get_created_successfully(){
		//accountSuccessPage=new AccountSuccessPage(driver);
		
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
		
	}

	@When("User selects Yes for Newsletter")
	public void User_selects_yes_for_newsletter()  {
		//registerPage=new RegisterPage(driver);
		
		
		registerPage.selectYesNewsLetterOption();
		
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	    
	}

	@Then("User should get a proper warning about duplicate email")
	public void User_should_get_a_proper_warning_about_duplicate_email() {
		//registerPage=new RegisterPage(driver);
		
		
	    Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into the fields")
	public void User_dont_enter_any_details_into_the_fields() {
	    //Intentionally Kept Blank
		
	}

	

	@Then("User should get a proper warning message for every mandatory fields")
	public void User_should_get_a_proper_warning_message_for_every_mandatory_fields() {
		//registerPage=new RegisterPage(driver);
		
	   Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
	   Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getfirstNameWarningMessageText());
	   Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarningMessageText());
	   Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarningMessageText());
	   Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarningMessageText());
	   Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarningMessageText());
	   
	}
	
	
	
	

}
