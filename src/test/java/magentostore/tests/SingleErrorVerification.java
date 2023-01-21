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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleErrorVerification {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fname = "Anubha";
		String lname = "Pal";
		String email = "Seem.pal@gmail.com";
		String password = "Anubha@123";
		String confirmpassword = "Anubha@123";
		String confirmmessage ;
		String fnameerror, lnameerror, emailerror, passworderror, confirmpassworderror;
		String expectederror = "This is a required field.";
		String expectederror1 = "This is  required field.";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		
		//create an account
		/*driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)")).click();
		driver.findElement(By.id("firstname")).sendKeys(fname);
		driver.findElement(By.id("lastname")).sendKeys(lname);
		driver.findElement(By.id("is_subscribed")).click();
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("password-confirmation")).sendKeys(confirmpassword);
		driver.findElement(By.cssSelector("button.action.submit.primary")).click();
		confirmmessage = driver.findElement(By.cssSelector(".message-success.success.message")).getText();
		Assert.assertEquals(confirmmessage, "Thank you for registering with Fake Online Clothing Store."," Account Created");
		//System.out.println(confirmmessage);*/
		
		
		
		
		//error_verification
		driver.findElement(By.xpath("//div[@class='panel header']//a[.='Create an Account']")).click();
		driver.findElement(By.cssSelector("button.action.submit.primary")).click();
		fnameerror = driver.findElement(By.id("firstname-error")).getText();
		//Assert.assertEquals(actualerror, expectederror);
		 lnameerror = driver.findElement(By.id("lastname-error")).getText();
		 emailerror = driver.findElement(By.id("email_address-error")).getText();
		 passworderror= driver.findElement(By.id("password-error")).getText();
		 confirmpassworderror = driver.findElement(By.id("password-confirmation-error")).getText();
		//Assert.assertEquals(actualerror1, expectederror);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(fnameerror, expectederror);
		softAssert.assertEquals(lnameerror, expectederror);
		softAssert.assertEquals(emailerror, expectederror);
		softAssert.assertEquals(passworderror, expectederror);
		softAssert.assertEquals(confirmpassworderror, expectederror);
		softAssert.assertAll();

		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//screenshots//"  + "errormessage.png");
		//	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		
		FileUtils.copyFile(source, dest);
		
		
		
		
		
		/* Web elements id="firstname"
				id="lastname"
						name="is_subscribed"
						id="email_address"
								id="password"
										id="password-confirmation"
		
		id="firstname-error"
			id="lastname-error"
			id="email_address-error"
			id="password-error"
			id="password-confirmation-error"*/
		
		//Script2:
		
		/*1. Sign into the Account created.
		2. Validate the Successful signing with the name of the user at top right corner of the page.
		3. Logout and validate the message
		4. Try to login with Invalid email and password.
		5. Validate the error messages (Capture the screenshot)*/
		
		

		

	}

}
