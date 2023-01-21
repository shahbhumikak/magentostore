package magentostore.tests;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import magentostore.TestComponents.BaseTest;
import magentostore.pageobjects.CreateAnAccountPage;
import magentostore.pageobjects.LandingPage;

public class AccountCreationTest extends BaseTest{
	
	//CreateAnAccountPage cp = new CreateAnAccountPage(driver);
	
	public String fname = "Anubha";
	public String lname = "Pal";
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(1000);
	public String email = "abc.pal" + randomInt +"@gmail.com";
	public String passwordEle = "Abc@1234";
	public String confirmpwd = "Abc@1234";
	String expectederror = "This is a required field.";
	String expectederror1 = "This is  required field.";

	@Test
	public void AccountCreation() throws IOException
	{
		
		CreateAnAccountPage cp = landingPage.goToCreateAccountPage();
		String confirmationmessage = cp.createAccount(fname, lname, email, passwordEle, confirmpwd);
		Assert.assertEquals(confirmationmessage, "Thank you for registering with Fake Online Clothing Store."," Account Created");
		
	}
	
	@Test
	public void RequiredFieldVerification() throws IOException
	{
		
		CreateAnAccountPage cp = landingPage.goToCreateAccountPage();
		String[] error = cp.errorMessage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(error[0], expectederror);
		softAssert.assertEquals(error[1], expectederror);
		//softAssert.assertEquals(error[1], expectederror1);
		softAssert.assertEquals(error[2], expectederror);
		softAssert.assertEquals(error[3], expectederror);
		softAssert.assertEquals(error[4], expectederror);
		softAssert.assertAll();
		getScreenshot("RequiredFieldVerification", driver);
	}

}
