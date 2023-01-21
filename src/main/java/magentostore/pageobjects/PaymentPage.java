package magentostore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import magentostore.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr[@class='totals sub']//td[@class='amount']")
	WebElement subtotal;
	
	@FindBy(xpath="//button[@title='Place Order']")
	WebElement placeorderbutton;
	
	String ordersummaryvalue;
	
	public String validateSubTotal()
	{
		ordersummaryvalue = subtotal.getText();
		return ordersummaryvalue;
	}
	
	public ConfirmationPage clickonplaceorder() throws InterruptedException
	{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(placeorderbutton).click(placeorderbutton).perform();
		waitForElementToBeAvaialable();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
}
