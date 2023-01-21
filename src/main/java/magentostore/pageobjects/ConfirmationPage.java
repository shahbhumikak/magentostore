package magentostore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import magentostore.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@data-ui-id='page-title-wrapper']")
	WebElement purchaseConfirmation;
	
	@FindBy(className="order-number")
	WebElement ordernumber;
	
	String purchasemessage;
	Boolean match;
	String orderno;
	
	public String confirmationMessage()
	{
		purchasemessage= purchaseConfirmation.getText();
		return purchasemessage;
	}
	
	public Boolean confirmorder()
	{
	
		match = ordernumber.isDisplayed();
		return match;
	}
	
	public String getOrderNumber()
	{
		orderno = ordernumber.getText();
		ordernumber.click();
		return orderno;
	}
	

	
	

}
