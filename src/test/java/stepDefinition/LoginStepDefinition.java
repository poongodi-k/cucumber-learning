package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;

public class LoginStepDefinition {
	WebDriver driver;
	LoginPage login ;
	
	@Given("user go to login page")
	public void userGoToLoginPage() throws InterruptedException {
		driver=DriverManager.getDriver();
		Thread.sleep(2000);
		System.out.println(ConfigReader.getValue("url"));
		driver.get(ConfigReader.getValue("url"));
		driver.manage().window().maximize();
		login = new LoginPage(driver);
	   
	}
	@Then("user enter the username")
	public void userEnterTheUsername() {
		login.sendUserName("student");
	}
	@Then("user enter the password")
	public void userEnterThePassword() {
		login.sendPassword("Password123");
	   
	}
	@Then("click submit button")
	public void clickSubmitButton() throws InterruptedException {
	    login.clickSubmitBtn();
	    Thread.sleep(5000);
	    driver.quit();
	}
	
	@Then("user enter the invalid username")
	public void userEnterTheInvalidUsername() {
	   login.sendUserName("ajai");
	}
	@Then("user enter the invalid password")
	public void userEnterTheInvalidPassword() {
	   login.sendPassword("ajai123");
	}
	@Then("user enter the name {string}")
	public void userEnterTheName(String username) {
		login.sendUserName(username);
	}
	@And("user enter the pwd {string}")
	public void userEnterThePwd(String password) {
		login.sendPassword(password);
	}

}
