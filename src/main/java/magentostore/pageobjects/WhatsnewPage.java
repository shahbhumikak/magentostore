package magentostore.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import magentostore.AbstractComponents.AbstractComponent;

public class WhatsnewPage extends AbstractComponent {

	WebDriver driver;
	
	public WhatsnewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ui-id-3") 
	WebElement whatsnewlink;
	
	@FindBy(xpath="//a[@title='Phoebe Zipper Sweatshirt']") 
	WebElement productsweatshirt;
	
	@FindBy(css=".swatch-option.text") 
	List<WebElement> sizelist;
	
	@FindBy(id="option-label-color-93-item-57") 
	WebElement productcolor;
	
	@FindBy(xpath="//button[@title='Add to Cart']") 
	WebElement addtocartbutton;
	
	@FindBy(id="ui-id-5") 
	WebElement mens;
	
	@FindBy(id="ui-id-18") 
	WebElement bottoms;
	
	@FindBy(id="ui-id-23") 
	WebElement pants;
	
	
	
	
	By counternumber = By.cssSelector(".counter-number");
	
	List<WebElement> sizes;
	Set<String> windows;
	Iterator<String> it;
	String parentId;
	String childId;
	
	public void selectNewProductandAddtoCart(String productsize)
	{
		whatsnewlink.click();
		productsweatshirt.click();
		
		for (WebElement size : sizelist)
		{
            if(size.getText().equalsIgnoreCase(productsize))
            {
            	size.click();
            }
            
		}
		productcolor.click();
		addtocartbutton.click();
         
	}
	
	public String newTab()
	{
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		windows=driver.getWindowHandles();
		it = windows.iterator();
		parentId = it.next();
		childId = it.next();
		
		return parentId;
		
	}
	
	
	
	public MensPage navigateToMenBottomsPants()
	{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(mens);
		
		actions.moveToElement(bottoms);
		
		actions.moveToElement(pants);
		
		actions.click().build().perform();
		MensPage mensPage = new MensPage(driver);
		return mensPage;
		
	}
	
	

	
}
