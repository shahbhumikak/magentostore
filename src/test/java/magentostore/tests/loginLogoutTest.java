package magentostore.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import magentostore.TestComponents.BaseTest;
import magentostore.TestComponents.Retry;
import magentostore.pageobjects.CreateAnAccountPage;
import magentostore.pageobjects.LandingPage;
import magentostore.pageobjects.SignInPage;


public class loginLogoutTest extends BaseTest{
	
	//SignInPage signinPage = new SignInPage(driver);
	
	
	@Test(dataProvider="getData",groups= {"ValidLogin"})
	
	public void validLoginlogoutVerification(HashMap<String,String> input) throws IOException //public void validLoginlogoutVerification(String email, String password, String name) throws IOException
	{
		
		SignInPage signinPage = landingPage.gotosigninPage();
		signinPage.loginToAccount(input.get("email"),input.get("password"));
		String text = signinPage.Validatelogin();
		if(text.contains(input.get("name")))
		
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
		String logoutmessage = signinPage.Validatelogout();
		Assert.assertEquals(logoutmessage,"You are signed out");
	}
	
	@Test(groups= {"InvalidLogin"},retryAnalyzer=Retry.class)
	public void invalidLoginVerification() throws IOException
	{
		
		SignInPage signinPage = landingPage.gotosigninPage();
		signinPage.loginToAccount("nisha.shah@gmail.com", "Anisha@183");
		String signinerror = signinPage.getloginerrormessage();
		Assert.assertEquals(signinerror,"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
		//Assert.assertEquals(signinerror,"Incorrect CAPTCHA");
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//magentostore//data//LoginDetails.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
	}
	
	/* @DataProvider
	  public Object[][] getData()
	 {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "anisha.shah@gmail.com");
		map.put("password", "Anisha@123");
		map.put("name", "Anisha");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "nimisha.shah@gmail.com");
		map1.put("password", "Anisha@123");
		map1.put("name", "Nimisha");
	    return new Object[][]  {{map},{map1}};
	    	//{{"anisha.shah@gmail.com","Anisha@123", "Anisha"}, {"nimisha.shah@gmail.com","Anisha@123","Nimisha" } };
	    }*/
	    
  }
	

