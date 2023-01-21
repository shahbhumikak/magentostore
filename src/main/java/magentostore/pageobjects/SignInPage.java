package magentostore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import magentostore.AbstractComponents.AbstractComponent;


public class SignInPage extends AbstractComponent{
	
	WebDriver driver;
	//LandingPage landingPage = new LandingPage(driver);
	
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email") 
	WebElement username;
	
	@FindBy(id="pass") 
	WebElement password;
	
	@FindBy(id="send2") 
	WebElement submit;
	
	@FindBy(css=".logged-in") 
	WebElement signinname;
	
	@FindBy(css="li.authorization-link") 
	WebElement logoutlinkclick;
	
	@FindBy(css=".action.switch") 
	WebElement logoutdropdown;
	
	@FindBy(css=".base") 
	WebElement logoutmessage;
	
	@FindBy(css=".message-error.error.message") 
	WebElement invalidloginmessage;
	
	By userwelcomeBy = By.cssSelector(".greet.welcome");
	 
	String s = "Welcome";
	String name;
	String signoutmessage;
	String incorrectsignin;
	
	public void loginToAccount(String email, String passwordEle)
	{
		
		//landingPage.gotosigninPage();
		username.sendKeys(email);
		password.sendKeys(passwordEle);
		submit.click();
		
		
	}
	
	public String Validatelogin()
	{
		waitfortextToBePresentInElementLocated(userwelcomeBy,s);
		name = signinname.getText();
		return name;
	}
	
	public String Validatelogout()
	{
		logoutdropdown.click();
		logoutlinkclick.click();
		signoutmessage = logoutmessage.getText();
		return signoutmessage;
	}
	
	public String getloginerrormessage()
	{
		incorrectsignin = invalidloginmessage.getText();
		return incorrectsignin;
	}
	
	
	
	
	
	
	

}
