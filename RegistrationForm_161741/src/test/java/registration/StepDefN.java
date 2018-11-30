package registration;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cg.model.RegistrationPageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefN {
	WebDriver driver;
	RegistrationPageFactory regPage;
	@Given("^user is on Registration Form$")
	public void user_is_on_Registration_Form() throws Throwable {
		driver = new FirefoxDriver();
		driver.get("D:\\BDD\\RegistrationForm.html");
		regPage = new RegistrationPageFactory(driver);
		System.out.println("Page Loaded in Browser");
	}

	@When("^user enters invalid user Id$")
	public void user_enters_invalid_user_Id() throws Throwable {
		regPage.setUserId("");
		regPage.clickLoginButton();
	}

	@Then("^Display alert box 'User id should not be empty/ lngth be between (\\d+) to (\\d+)'$")
	public void display_alert_box_User_id_should_not_be_empty_lngth_be_between_to(int arg1, int arg2) throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		String expErrorMsg = "User Id should not be empty / length be between "+arg1+" to "+arg2;
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();	
		}
	
	@When("^user enters invalid password$")
	public void user_enters_invalid_password() throws Throwable {
		regPage.setUserId("161741");
		regPage.setPassword("");
		regPage.clickLoginButton();
	}

	@Then("^Display alert box 'Password should not be empty/ length be between (\\d+) to (\\d+)'$")
	public void display_alert_box_Password_should_not_be_empty_length_be_between_to(int arg1, int arg2) throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		String expErrorMsg = "Password should not be empty / length be between "+arg1+" to "+arg2;
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
	@When("^user enters invalid username$")
	public void user_enters_invalid_username() throws Throwable {
		regPage.setUserId("161741");
		regPage.setPassword("SwethaPanga");
		regPage.setUserName("123456");
		regPage.clickLoginButton();

	}

	@Then("^Display alert box 'Username should not be empty and must have alphabet characters only'$")
	public void display_alert_box_Username_should_not_be_empty_and_must_have_alphabet_characters_only() throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		String expErrorMsg = "Name should not be empty and must have alphabet characters only";
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();

	}
	@When("^user enters invalid address$")
	public void user_enters_invalid_address() throws Throwable {
		regPage.setUserId("161741");
		regPage.setPassword("SwethaPanga");
		regPage.setUserName("SwethaPanga");
		regPage.setAddress("$#%^&*");
		regPage.clickLoginButton();

	}

	@Then("^Display alert box 'User address must have alphanumeric characters only'$")
	public void display_alert_box_User_address_must_have_alphanumeric_characters_only() throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		String expErrorMsg = "User address must have alphanumeric characters only";
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();

	}


}
