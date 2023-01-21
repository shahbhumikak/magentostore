package magentostore.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script2Test {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String email = "anisha.shah@gmail.com";
		String password = "Anisha@123";
		//String confirmpassword = "Anubha@123";
		
		String wrongemail = "ansha.shah@gmail.com";
		String wrongpassword = "Anisha@125";
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(.,'Sign In')]")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("send2")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		String s;
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".greet.welcome"),"Welcome"));
		//String name = driver.findElement(By.cssSelector(".logged-in")).getText();
		
		String name = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		System.out.println(name);
		if(name.contains("Anisha"))
		{
				
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.cssSelector(".action.switch")).click();
		driver.findElement(By.cssSelector("li.authorization-link")).click();
		String logoutmessage = driver.findElement(By.cssSelector(".base")).getText();
		Assert.assertEquals(logoutmessage,"You are signed out");
		
		// login with Invalid email and password.Validate the error messages (Capture the screenshot)
		
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(.,'Sign In')]")).click();
		driver.findElement(By.id("email")).sendKeys(wrongemail);
		driver.findElement(By.id("pass")).sendKeys(wrongpassword);
		driver.findElement(By.id("send2")).click();
		
		String loginmsg = driver.findElement(By.cssSelector(".message-error.error.message")).getText();
		System.out.println(loginmsg);
		//Assert.assertEquals(loginmsg,"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//screenshots//"  + "loginerrormessage.png");
		//	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		
		FileUtils.copyFile(source, dest);
		
		

	}

}
