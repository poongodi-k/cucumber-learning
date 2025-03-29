package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
	WebDriver driver;
	static WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement usernameField;
	@FindBy(id = "password")
	private WebElement passwordField;
	@FindBy(id = "submit")
	private WebElement submitButton;

	public WebElement getUsernameField() {
		return usernameField;
	}
	
	public WebElement getPasswordField() {
		return passwordField;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void sendUserName(String name) {
		 wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys(name);
	}
	public void sendPassword(String password) {
		 wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.sendKeys(password);
	}
	public void clickSubmitBtn() {
		 wait.until(ExpectedConditions.visibilityOf(submitButton));
		submitButton.click();
	}
	
}
