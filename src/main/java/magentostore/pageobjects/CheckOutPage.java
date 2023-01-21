package magentostore.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import magentostore.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".button.action.continue.primary")
	WebElement nextButton;
	
	@FindBy(css=".shipping-address-item.selected-item")
	List<WebElement> shippingaddress;
	
	@FindBy(name="street[0]")
	WebElement streetAdress;
	
	@FindBy(name="street[1]")
	WebElement streetAdress1;
	
	@FindBy(name="street[2]")
	WebElement streetAdress2;
	
	@FindBy(name="country_id")
	WebElement country_idStaticdropdown;
	
	@FindBy(name="region_id")
	WebElement region_idStaticdropdown;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="postcode")
	WebElement postcode;
	
	@FindBy(name="telephone")
	WebElement telephone;
	
	@FindBy(css="input[value='tablerate_bestway']")
	WebElement tableRate;
	
	int size;
	
	public void clickOnNextButton() throws InterruptedException
	{
		size = shippingaddress.size();
		if(size==0)
		{
		
			streetAdress.sendKeys("American Street");
			streetAdress1.sendKeys(Keys.TAB);
			streetAdress2.sendKeys(Keys.TAB);
			// select dropdown for country
			Select dropdown = new Select(country_idStaticdropdown);
			dropdown.selectByVisibleText("United States");
			//select dropdown for region or state
			Select drpdwn = new Select(region_idStaticdropdown);
			drpdwn.selectByVisibleText("Texas");
			city.sendKeys("Austin");
			postcode.sendKeys("12345");
			telephone.sendKeys("9876543210");
		}
		tableRate.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(nextButton).click(nextButton).perform();
		waitForElementToBeAvaialable();
	}
	
	

}
