package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	public LogInPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement email;
	
	public WebElement passwd;
	
	@FindBy(id="SubmitLogin")
	public WebElement loginButton;
	
	public void logIn(String user, String password) {
		
		email.sendKeys(user);
		passwd.sendKeys(password);
		loginButton.click();
		
		
		
	}
	
	
}
