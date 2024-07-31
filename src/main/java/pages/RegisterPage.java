package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
		
		
	}
	
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	public void enterFirstName(String firstNameText) {
		elementUtils.typeTextIntoElement(firstNameField, firstNameText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//firstNameField.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//emailField.sendKeys(emailText);
	}
	
	
	public void enterTelephoneNumber(String telephoneNumber) {
		elementUtils.typeTextIntoElement(telephoneField, telephoneNumber, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//telephoneField.sendKeys(telephoneNumber);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String passwordText) {
		elementUtils.typeTextIntoElement(confirmPasswordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//confirmPasswordField.sendKeys(passwordText);
	}
	
	public void selectPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//privacyPolicyOption.click();
		
	}
	
	
	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsLetterOption() {
		elementUtils.clickOnElement(yesNewsLetterOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//yesNewsLetterOption.click();
	}
	
	
	public String getWarningMessageText() {
		return elementUtils.getTextFromWebElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return warningMessage.getText();
	}
	
	public String getfirstNameWarningMessageText() {
		return elementUtils.getTextFromWebElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return firstNameWarning.getText();
	}
	
	
	
	public String getLastNameWarningMessageText() {
		return elementUtils.getTextFromWebElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return lastNameWarning.getText();
	}
	
	
	public String getEmailWarningMessageText() {
		return elementUtils.getTextFromWebElement(emailWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
				
		//return emailWarning.getText();
	}
	
	
	public String getTelephoneWarningMessageText() {
		return elementUtils.getTextFromWebElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return telephoneWarning.getText();
	}
	
	
	public String getPasswordWarningMessageText() {
		return elementUtils.getTextFromWebElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return passwordWarning.getText();
	}
	
	
	

}
