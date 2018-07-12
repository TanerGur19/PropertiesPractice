package logInTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LogInPage;
import utilities.ConfigReader;

public class LogInTests {

	WebDriver driver;
	LogInPage logInPage;
	
	
	@BeforeClass //runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();

	}
	
	@Test
	public void logInUsingProperties() {
		
		driver.get(ConfigReader.getMyValue("url"));
		logInPage= new LogInPage(driver);
		logInPage.logIn(ConfigReader.getMyValue("userName"),ConfigReader.getMyValue("password"));
		logInPage.loginButton.click();
		
		String actual= driver.findElement(By.xpath("//div[@id='center_column']/div/ol/li")).getText();
		String expected= "Authentication failed.";
		
		
		Assert.assertEquals(actual, expected);
		
		
	}
	
}
