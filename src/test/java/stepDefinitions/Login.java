package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	
	
	
	@Given("User navigates to Login Page")
	public void User_navigates_to_Login_Page() {
		
		driver=DriverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage=homePage.selectLoginOption();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Login")).click();
	 
 }
	
	@When("^User enters valid email address (.+) into email address field$")
	public void User_enters_valid_email_address_into_email_address_field(String emailText) {
		//loginPage=new LoginPage(driver);
		
		loginPage.enterEmailAddress(emailText);
		
		//driver.findElement(By.id("input-email")).sendKeys(emailText);
		
	}
	
	@And("^User has entered valid password (.+) into password field$")
	public void User_has_entered_valid_password_into_password_field(String passwordText) {
		loginPage.enterPassword(passwordText);
		//driver.findElement(By.id("input-password")).sendKeys(passwordText);
	   
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountPage=loginPage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	    
	}

	@Then("User should get successfully logged in")
	public void User_should_get_successfully_logged_in() {
		//AccountPage accountPage=new AccountPage(driver);
		
	    Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformation());
	}
	
	

	@When("User enters Invalid email address into email address field")
	public void User_enters_Invalid_email_address_into_email_address_field() {
		//loginPage=new LoginPage(driver);
		commonUtils=new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
		
	}

	@And("User has enters invalid password {string} into password field")
	public void User_has_enters_invalid_password_into_password_field(String invalidPasswordText) {
		loginPage.enterPassword(invalidPasswordText);
		//driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
	}

	

	@Then("User should get a proper warning message about credentials mismatch")
	public void User_should_get_a_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}
	
	

	@When("User dont enter any email address into email address field")
	public void user_dont_enter_any_email_address_into_email_address_field() {
		//loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress("");
		//driver.findElement(By.id("input-email")).sendKeys("");
	}

	@And("User dont enter any password into password field")
	public void user_dont_enter_any_password_into_password_field() {
		loginPage=new LoginPage(driver);
		loginPage.enterPassword("");
		driver.findElement(By.id("input-password")).sendKeys("");
	}
	
	
	
	
}
