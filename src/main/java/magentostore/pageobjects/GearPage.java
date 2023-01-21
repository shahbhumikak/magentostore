package magentostore.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import magentostore.AbstractComponents.AbstractComponent;

public class GearPage extends AbstractComponent {

	WebDriver driver;
	
	public GearPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ui-id-6") 
	WebElement gear;
	
	@FindBy(linkText="Watches") 
	WebElement watches;
	
	@FindBy(xpath="//div[normalize-space()='Price']") 
	WebElement pricefilteroption;
	
	@FindBy(xpath="(//div[@class='filter-options-content'])[2]") 
	WebElement pricelielements;
	

	@FindBy(xpath="(//div[@class='filter-options-title'])[3]") 
	WebElement material;
	
	@FindBy(xpath="(//div[@class='filter-options-content'])[3]") 
	WebElement materialelement;
	
	@FindBy(xpath="//a[normalize-space()='Endurance Watch']") 
	WebElement endurancewatch;
	
	@FindBy(id="product-addtocart-button") 
	WebElement watchaddtocartbutton;
	
	By counternumber = By.cssSelector(".counter-number");
	
	List<WebElement> listItems;
	List<WebElement>  materialItems;
	String s = "2";
	
	
	
	
	public void gotogearandwatches()
	{
		gear.click();
		watches.click();
	}
	
	public void filterPrice()
	{
		pricefilteroption.click();
		//WebElement liElements = driver.findElement(By.xpath("(//div[@class='filter-options-content'])[2]"));
		
		listItems = pricelielements.findElements(By.tagName("a"));
		for (WebElement e : listItems) 
		{
            if(e.getText().contains("40.00")) 
            	{
            	e.click();
            	break;
            	}
		}
		
	}
	
	public void filterMaterial()
	{
		 
         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", material);
         material.click();
         
 		//WebElement matElements = driver.findElement(By.xpath("(//div[@class='filter-options-content'])[3]"));
 		
         materialItems = materialelement.findElements(By.tagName("a"));
 		
 		for (WebElement mat : materialItems) 
 		{
             if(mat.getText().contains("Rubber")) 
             	{
             	mat.click();
             	break;
             	}
 		}
 		
		
	}
	
	public void selectProductafterFilterandaddToCart()
	{
		waitelementToBeClickable(endurancewatch);
		endurancewatch.click();
		waitelementToBeClickable(watchaddtocartbutton);
		watchaddtocartbutton.click();
		waittextToBe(counternumber, s);
	}
	
	public void closecurrenttab(String parentId)
	{
		driver.close();
		driver.switchTo().window(parentId);
		//window(originalWindow);
		driver.navigate().refresh();
	}
	

}
