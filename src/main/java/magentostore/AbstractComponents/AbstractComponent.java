package magentostore.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import magentostore.pageobjects.CreateAnAccountPage;
import magentostore.pageobjects.SignInPage;


public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//div[@class='panel header']//a[contains(.,'Sign In')]")
	WebElement signinlink;
	
	@FindBy(xpath="//div[@class='panel header']//a[.='Create an Account']")
	WebElement createaccountlink;
	
	/*public SignInPage gotosigninPage()
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
	*/
	
	
	public void waitfortextToBePresentInElementLocated(By findBy, String s)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(findBy,s));
	}
	
	public void waitelementToBeClickable(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waittextToBe(By findBy, String s)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBe(findBy,s));
	}
	
	public void waitForElementToBeAvaialable() throws InterruptedException
	{
	 Thread.sleep(5000);
	}
	
	public void waitForinvisibilityOfElementLocated(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void waitForVisibilityOfElementLocated(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
}

