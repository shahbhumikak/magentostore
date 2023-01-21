package magentostore.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

import magentostore.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	//public CreateAnAccountPage cp;
	//public SignInPage signinPage; 
	public LandingPage landingPage;
	
	
	
	
	public WebDriver initializeDriver() throws IOException
	{
		//properties class
		Properties prop = new Properties(); 
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//magentostore//resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//prop.getProperty(browserName)
	
		
		if (browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")){
			options.addArguments("headless");
			}		
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen
		
		}
		else if(browserName.contains("firefox"))
		{  
			FirefoxOptions options2 = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			if(browserName.contains("headless")){
			options2.addArguments("headless");
			}		
			driver = new FirefoxDriver(options2);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen
		}
		else if(browserName.contains("edge"))
		{
			//Edge
			EdgeOptions options1 = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			if(browserName.contains("headless")){
			options1.addArguments("headless");
			}	
			driver = new EdgeDriver(options1);
			//driver.manage().window().setSize(new Dimension(1440,900));//full screen
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	
	{
		driver = initializeDriver();
		//cp = new CreateAnAccountPage(driver);
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	
	
	@AfterMethod(alwaysRun=true)
	public void teardown() throws IOException
	{
		driver.close();
	}	
	
	public void getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//screenshots//"  + testCaseName +".png");
		//	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		
		FileUtils.copyFile(source, dest);
		//return file;
	}
	
	public String getScreenshots(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//screenshots//"  + testCaseName +".png");
		//	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir") + "//screenshots//"  + testCaseName +".png";
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filapath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filapath),StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Datbind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	//{map, map}
	}  

}
