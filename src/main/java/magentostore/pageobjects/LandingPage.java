package magentostore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import magentostore.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//div[@class='panel header']//a[contains(.,'Sign In')]")
	WebElement signinlink;
	
	@FindBy(xpath="//div[@class='panel header']//a[.='Create an Account']")
	WebElement createaccountlink;
	
	public SignInPage gotosigninPage()
	{
		signinlink.click();
		SignInPage signInPage = new SignInPage(driver);
		return signInPage;
	}
	
	public CreateAnAccountPage goToCreateAccountPage()
	{
		createaccountlink.click();
		CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
		return createAnAccountPage;
	}
	
	public void goTo()
	{
		driver.get("https://magento.softwaretestingboard.com/");
	}
	}
	
	

