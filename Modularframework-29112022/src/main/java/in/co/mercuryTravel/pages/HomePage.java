package in.co.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonlibs.utils.waitutils;

public class HomePage extends BasePage {
//links of homepage
	@FindBy(linkText = "International Holidays")
	private WebElement InternationalHolidayLink;
	
	@FindBy(linkText = "Indian Holidays")
	private WebElement IndianHolidayLink;
	
	@FindBy(linkText = "Luxury Rails")
	private WebElement LuxuryrailLink;
	
	@FindBy(linkText = "Preferred Holidays")
	private WebElement preferedHolidaysLink;
	
	@FindBy(linkText = "Mice")
	private WebElement MiceLink;
	
	@FindBy(linkText = "Flights")
	private WebElement FlightslLink;
	
	@FindBy(linkText = "Customer Login")
	private WebElement CustomerLoginLink;
	
	@FindBy(linkText = "User Login")
	private WebElement UserLoginLink;
	
	@FindBy(linkText = "Register")
	private WebElement RegisterPage;
//Loginpage	
	@FindBy(id = "sign_user_email")
	private WebElement UserId;
	
	@FindBy(id = "sign_user_password")
	private WebElement UserPassword;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement Login;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/form/ul[1]/li")
	private WebElement Invalidmessage;
	
	@FindBy(partialLinkText = "Welcome")
	private WebElement message;
		
//Register
	@FindBy(id = "acc_first_name")
	private WebElement FirstName;
	
	@FindBy(id = "acc_last_name")
	private WebElement LastName;
	
	@FindBy(id = "acc_user_email")
	private WebElement UserEmail;
	
	@FindBy(id = "acc_user_password")
	private WebElement SetPassword;
	
	@FindBy(id = "acc_user_passconf")
	private WebElement ConfirmPassword;
		
	
	@FindBy(id = "acc_mobile_no")
	private WebElement MobileNo;
	
	public HomePage(WebDriver driver)
	{
	super(driver);
		
	PageFactory.initElements(driver, this);	
		
	}
	public void UserLogin(String username,String password)
	throws Exception{
		mousecontrol.moveToElement(CustomerLoginLink);
		
		mousecontrol.moveToElementAndClick(UserLoginLink);
		
		elementcontrol.setText(UserId, username);
		
		waitutils.waitForSeconds(2);
		
		elementcontrol.setText(UserPassword, password);
		
		waitutils.waitForSeconds(2);

		elementcontrol.clickElement(Login);	
		
		waitutils.waitForSeconds(5);
		
	}
	public String getmessage()throws Exception{
	
	return elementcontrol.getText(message);
	
	
	}
}
