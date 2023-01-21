package magentostore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import magentostore.AbstractComponents.AbstractComponent;

public class MensPage extends AbstractComponent {

WebDriver driver;
	
	public MensPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="sorter") 
	WebElement sort;
	
	@FindBy(xpath="(//li[@class='item product product-item'])[1]") 
	WebElement product;
	
	@FindBy(id="option-label-size-143-item-177")
			WebElement size;
	
	@FindBy(id="option-label-color-93-item-53")
	WebElement greencolor;
	
	@FindBy(xpath="(//button[@class='action tocart primary'])[1]")
	WebElement mensaddtocart;
	
	
	@FindBy(css=".action.showcart")
	WebElement movetocart;
	
	@FindBy(xpath="(//input[contains(@id,'cart-item-')])[1]")
	WebElement clearquantitybox;
	
	@FindBy(xpath="(//input[contains(@id,'cart-item-')])[1]")
	WebElement enterquantity;
	
	@FindBy(css=".update-cart-item")
	WebElement updatequantitybutton;
	
	@FindBy(css=".amount.price-container")
	WebElement totalAmount;
	
	@FindBy(id="top-cart-btn-checkout")
	WebElement proccedcheckoutbutton;
	
	By checkoutpinwheel = By.id("checkout-loader");
	By totalamount = By.cssSelector(".amount.price-container");
	By nextbutton = By.cssSelector(".button.action.continue.primary");
	
	String total;
    		
	
	public void sortByPriceAscending()
	{
		sort.click();
		Select dropdown = new Select(sort);
		dropdown.selectByVisibleText("Price");
	}
	
	public void addFirstItemtoCart()
	{
		Actions action = new Actions(driver);
		action.moveToElement(product).build().perform();
		size.click();
		greencolor.click();
			
		action.moveToElement(mensaddtocart);
		action.click().build().perform();
	}
	
	public void navigateToCart() throws InterruptedException
	{
		movetocart.click();
		waitForElementToBeAvaialable();
	}
	
	public void updateMensItemsQuantity()
	{
		clearquantitybox.sendKeys(Keys.BACK_SPACE);
		
		
		enterquantity.sendKeys("4");
		updatequantitybutton.click();
		waitForinvisibilityOfElementLocated(checkoutpinwheel);
		waitForVisibilityOfElementLocated(totalamount);
	}
	
	public String getTotalCartValue()
	{
		total = totalAmount.getText();
		return total;
	}
	
	public CheckOutPage clickProceedtoCheckout()
	{
		proccedcheckoutbutton.click();
		waitForinvisibilityOfElementLocated(checkoutpinwheel);
		waitForVisibilityOfElementLocated(nextbutton);
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
	
	
	
}
