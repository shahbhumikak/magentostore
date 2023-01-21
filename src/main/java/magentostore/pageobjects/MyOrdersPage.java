package magentostore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import magentostore.AbstractComponents.AbstractComponent;

public class MyOrdersPage extends AbstractComponent {

WebDriver driver;
	
	public MyOrdersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="base")
	WebElement orderId;
	
	String orderbillId;
	
	public String getOrderId()
	{
		orderbillId = orderId.getText();
		return orderbillId;
	}
}
