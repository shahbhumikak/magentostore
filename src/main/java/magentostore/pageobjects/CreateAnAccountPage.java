package magentostore.pageobjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import magentostore.AbstractComponents.AbstractComponent;

public class CreateAnAccountPage extends AbstractComponent{
	
	WebDriver driver;
	//LandingPage landingPage = new LandingPage(driver);

	/*public String confirmation;
	public String fname = "Anubha";
	public String lname = "Pal";
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(1000);
	public String email = "abc.pal" + randomInt +"@gmail.com";
	public String passwordEle = "Abc@1234";
	public String confirmpwd = "Abc@1234";*/
	
	
	public CreateAnAccountPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement firstname = driver.findElement(By.id("firstname"));
	//PageFactory 
	
	@FindBy(id="firstname") 
	WebElement firstname;
	
	@FindBy(id="lastname") 
	WebElement lastname;
	
	@FindBy(id="is_subscribed") 
	WebElement is_subscribed;
	
	@FindBy(id="email_address") 
	WebElement email_address;
	
	@FindBy(id="password") 
	WebElement password;
	
	@FindBy(id="password-confirmation") 
	WebElement confirmpassword;
	
	@FindBy(css="button.action.submit.primary") 
	WebElement submit;
	
	/*@FindBy(css="header[class='page-header'] li:nth-child(3) a:nth-child(1)") 
	WebElement createaccountlink;*/
	
	//@FindBy(xpath="//div[@class='panel header']//a[.='Create an Account']")
	//WebElement createaccountlink;
	
	//Error message Elements:
	@FindBy(id="firstname-error")
	WebElement firstnameerror;
	
	@FindBy(id="lastname-error")
	WebElement lastnameerror;
	
	@FindBy(id="email_address-error")
	WebElement emailerror;
	
	@FindBy(id="password-error")
	WebElement passworderror;
	
	@FindBy(id="password-confirmation-error")
	WebElement confirmpassworderror;
	
	@FindBy(css=".message-success.success.message")
	WebElement confirmmessage;
	
	//Action methods
	
	public String createAccount(String fname, String lname, String email, String passwordEle, String confirmpwd)
	{
		//landingPage.goToCreateAccountPage();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email_address.sendKeys(email);
		password.sendKeys(passwordEle);
		confirmpassword.sendKeys(confirmpwd);
		submit.click();	
		String confirmation = confirmmessage.getText();
		return confirmation;
		
	}
	
	public String[] errorMessage()
	{
		//landingPage.goToCreateAccountPage();
		submit.click();
		String[] error= new String[5];
		error[0]=firstnameerror.getText();
		error[1]=lastnameerror.getText();
		error[2]=emailerror.getText();
		error[3]=passworderror.getText();
		error[4]=confirmpassworderror.getText();
		return error;
		
		
	}
	
	
	
	
	

}
