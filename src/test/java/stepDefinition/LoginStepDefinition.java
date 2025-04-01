package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginStepDefinition {
	WebDriver driver;
	LoginPage login;

	@Given("user go to login page")
	public void userGoToLoginPage() throws InterruptedException {
		driver = Hooks.driver;
		driver.get(ConfigReader.getValue("url"));
		driver.manage().window().maximize();
		login = new LoginPage(driver, Hooks.wait);

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
		try {
			WebElement errorElmt = Hooks.wait
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("error"))));
			if (errorElmt.isDisplayed()) {
				Assert.fail("login page issue");
			}

		} catch (Exception e) {
			System.out.println("user login successfull");
			System.out.println(e.getMessage());
		}

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
