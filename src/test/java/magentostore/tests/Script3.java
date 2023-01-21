package magentostore.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Division;

public class Script3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String productname ;
		String email = "manisha.shah@gmail.com";
		String password = "Anisha@123";
		String productsize = "L";
		String colorname = "Purple";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		String originalWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(.,'Sign In')]")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("send2")).click();
		
		driver.findElement(By.id("ui-id-3")).click();
		driver.findElement(By.xpath("//a[@title='Phoebe Zipper Sweatshirt']")).click();
		List<WebElement> sizes = driver.findElements(By.cssSelector(".swatch-option.text"));
		System.out.println(sizes.get(0).getText());
		sizes.iterator();
		//sizes.size();
		//sizes.forEach(.sizes.get(0))
		/*for(int i=0; i<sizes.size(); i++)
			{
				if(sizes.get(i).getText().equalsIgnoreCase(productsize))
						{
							sizes.get(i).click();
						}
			}*/
		for (WebElement size : sizes){
            if(size.getText().equalsIgnoreCase(productsize)) {
            	size.click();
            }}
		
		/*Stream<WebElement> siz = sizes.stream().filter(size -> size.getText().equals(productsize));
		siz.findFirst();*/
	
		
		driver.findElement(By.id("option-label-color-93-item-57")).click();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		Set<String> windows=driver.getWindowHandles();
		Iterator<String>it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();

		driver.findElement(By.id("ui-id-6")).click();
		driver.findElement(By.linkText("Watches")).click();
		
		driver.findElement(By.xpath("//div[normalize-space()='Price']")).click();
		WebElement liElements = driver.findElement(By.xpath("(//div[@class='filter-options-content'])[2]"));
		
		List<WebElement> listItems = liElements.findElements(By.tagName("a"));
		System.out.println(listItems.get(0).getText());
		for (WebElement e : listItems) 
		{
            if(e.getText().contains("40.00")) 
            	{
            	e.click();
            	break;
            	}
		}
            
           // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Material']")));
            
            WebElement material = driver.findElement(By.xpath("(//div[@class='filter-options-title'])[3]"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", material);
            material.click();
            
    		WebElement matElements = driver.findElement(By.xpath("(//div[@class='filter-options-content'])[3]"));
    		
    		List<WebElement> matItems = matElements.findElements(By.tagName("a"));
    		System.out.println(matItems.get(0).getText());
    		for (WebElement mat : matItems) 
    		{
                if(mat.getText().contains("Rubber")) 
                	{
                	mat.click();
                	break;
                	}
    		}
    
    		TakesScreenshot ts = (TakesScreenshot)driver;
    		File source = ts.getScreenshotAs(OutputType.FILE);
    		File dest = new File(System.getProperty("user.dir") + "//screenshots//"  + "filteration.png");
    		//	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
    		
    		FileUtils.copyFile(source, dest);
            //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Endurance Watch']")));
    		driver.findElement(By.xpath("//a[normalize-space()='Endurance Watch']")).click(); 
    		
    		wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
    		driver.findElement(By.id("product-addtocart-button")).click();
    		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
    		//wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".counter.qty._block-content-loading"))));
    		//wait1.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".counter.qty._block-content-loading"))));
    		wait1.until(ExpectedConditions.textToBe(By.cssSelector(".counter-number"), "2"));
    		
    		
    		driver.close();
    		driver.switchTo().window(parentId);
    		//window(originalWindow);
    		driver.navigate().refresh();
    		
    		WebElement mens = driver.findElement(By.id("ui-id-5"));
    		Actions actions = new Actions(driver);
    		actions.moveToElement(mens);
    		WebElement bottoms = driver.findElement(By.id("ui-id-18"));
    		actions.moveToElement(bottoms);
    		WebElement pants = driver.findElement(By.id("ui-id-23"));
    		actions.moveToElement(pants);
    		
    		actions.click().build().perform();
    		// Bottoms - ui-id-18
    		//pants - ui-id-23
    		
    		WebElement staticDropdown = driver.findElement(By.id("sorter"));
    		
    		Select dropdown = new Select(staticDropdown);
    		//dropdown.selectByIndex(2);
    		dropdown.selectByVisibleText("Price");
    		//dropdown.selectByValue("Price");
    		
    		WebElement product = driver.findElement(By.xpath("(//li[@class='item product product-item'])[1]"));
    		Actions action = new Actions(driver);
    		action.moveToElement(product).build().perform();
    		
    		driver.findElement(By.id("option-label-size-143-item-177")).click();
    		driver.findElement(By.id("option-label-color-93-item-53")).click();
    		
    		
    		WebElement cartbutton=driver.findElement(By.xpath("(//button[@class='action tocart primary'])[1]"));
    		action.moveToElement(cartbutton);
    		action.click().build().perform();
    		//size = option-label-size-143-item-177
    		//greencolor = option-label-color-93-item-53
    		//add to cart = (//button[@class='action tocart primary'])[1]
    		
    		driver.findElement(By.cssSelector(".action.showcart")).click();
    		// edit button : - .edit
    		
    		// WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
             //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//img[@alt='Loading...']")));
     		
    		Thread.sleep(5000);
    		
    		/*JavascriptExecutor js = (JavascriptExecutor) driver;
    		WebElement updatebox = driver.findElement(By.xpath("(//input[contains(@id,'cart-item-')])[1]"));
    		js.executeScript("arguments[0].setAttribute('data-item-qty','4')",updatebox );*/
    		
    		driver.findElement(By.xpath("(//input[contains(@id,'cart-item-')])[1]")).sendKeys(Keys.BACK_SPACE);
    		
    		//driver.findElement(By.xpath("(//input[contains(@id,'cart-item-')])[1]")).clear();
    		driver.findElement(By.xpath("(//input[contains(@id,'cart-item-')])[1]")).sendKeys("4");
    		driver.findElement(By.cssSelector(".update-cart-item")).click();
    		
    		//Thread.sleep(2000);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkout-loader")));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".amount.price-container")));
            String val = driver.findElement(By.cssSelector(".amount.price-container")).getText();
    		System.out.println(val);
    		Assert.assertEquals(val,"$220.00");
    		
    		driver.findElement(By.id("top-cart-btn-checkout")).click();
    		
    //cart value $220.00
    		
	}

	}
	

