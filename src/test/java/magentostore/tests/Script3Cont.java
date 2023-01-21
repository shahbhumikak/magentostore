package magentostore.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script3Cont {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productname ;
		String email = "manisha.shah@gmail.com";
		String password = "Anisha@123";
		String productsize = "L";
		String colorname = "Purple";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		String originalWindow = driver.getWindowHandle();
		Actions actions = new Actions(driver);
		
		
		
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(.,'Sign In')]")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("send2")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".action.showcart")).click();
		
		
		
		String val = driver.findElement(By.cssSelector(".amount.price-container")).getText();
		System.out.println(val);
		Assert.assertEquals(val,"$220.00");
		
		driver.findElement(By.id("top-cart-btn-checkout")).click();//check-out button click
		
		//Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.action.continue.primary")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button.action.continue.primary")));
		WebElement nextbtn = driver.findElement(By.cssSelector(".button.action.continue.primary"));//next btn
		
		int size = driver.findElements(By.cssSelector(".shipping-address-item.selected-item")).size();
		//Boolean elementdisplaystatus=driver.findElement(By.cssSelector(".shipping-address-item.selected-item")).isDisplayed();
		//System.out.println(elementdisplaystatus);
		//if(!elementdisplaystatus)
		if(size==0)
		{
		//driver.findElement(By.name("firstname")).sendKeys(args);
		//driver.findElement(By.name("lastname")).sendKeys(args);
		driver.findElement(By.name("street[0]")).sendKeys("American Street");
		driver.findElement(By.name("street[1]")).sendKeys(Keys.TAB);
		driver.findElement(By.name("street[2]")).sendKeys(Keys.TAB);
		
		// select dropdown for country
		WebElement staticDropdown = driver.findElement(By.name("country_id"));
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByVisibleText("United States");
		
		
		//select dropdown for region or state
		WebElement selectdrpdwn = driver.findElement(By.name("region_id"));
		Select drpdwn = new Select(selectdrpdwn);
		
		drpdwn.selectByVisibleText("Texas");
		
		
		
		driver.findElement(By.name("city")).sendKeys("Austin");
		driver.findElement(By.name("postcode")).sendKeys("12345");
		
		
		driver.findElement(By.name("telephone")).sendKeys("9876543210");
		
		//driver.findElement(By.cssSelector("input[value='tablerate_bestway']")).click();
		//driver.findElement(By.cssSelector(".button.action.continue.primary")).click();//next btn
		
		//actions.moveToElement(nextbtn).click(nextbtn).perform();
		}
		/*else
		{
			WebElement nextbtn = driver.findElement(By.cssSelector(".button.action.continue.primary"));//next btn
			Actions actions = new Actions(driver);
			actions.moveToElement(nextbtn).click().build().perform();
		}*/
		//WebElement nextbtn = driver.findElement(By.cssSelector(".button.action.continue.primary"));//next btn
		driver.findElement(By.cssSelector("input[value='tablerate_bestway']")).click();
		actions.moveToElement(nextbtn).click(nextbtn).perform();
		
		
		// driver.findElement(By.cssSelector(".button.action.continue.primary")).click();//next btn 
		
		//table value assertion-do
		
		Thread.sleep(5000);
		//img[@alt='Loading...']
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("body[class*='ajax-loading']")));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='totals sub']//td[@class='amount']")));
		
		String Ordersummaryvalue = driver.findElement(By.xpath("//tr[@class='totals sub']//td[@class='amount']")).getText();
		Assert.assertEquals(Ordersummaryvalue,"$220.00");
		
		WebElement placeorder = driver.findElement(By.xpath("//button[@title='Place Order']"));//place order button....
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(placeorder).click(placeorder).perform();
		//Thank you for your purchase!

		Thread.sleep(5000);
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("body[class*='ajax-loading']")));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-ui-id='page-title-wrapper']")));
        
		String purchasemessage= driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']")).getText();
		Assert.assertEquals(purchasemessage, "Thank you for your purchase!");
		WebElement ordernumber = driver.findElement(By.className("order-number"));
		Boolean match = ordernumber.isDisplayed();

		Assert.assertTrue(match);
		
		String orderno = ordernumber.getText();
		ordernumber.click();
		String cnfrmorder = driver.findElement(By.className("base")).getText();
		if(cnfrmorder.contains(orderno))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
			
			
		
		

	}

}
