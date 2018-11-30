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
		//Loads the registration page into browser
		driver.get("D:\\BDD\\RegistrationForm.html");
		regPage = new RegistrationPageFactory(driver);
		System.out.println("Page Loaded in Browser");
	}

	@When("^user enters invalid user Id$")
	public void user_enters_invalid_user_Id() throws Throwable {
		//Passing empty user Id which is invalid
		regPage.setUserId("");
		regPage.clickSubmitButton();
	}

	@Then("^Display alert box 'User id should not be empty/ lngth be between (\\d+) to (\\d+)'$")
	public void display_alert_box_User_id_should_not_be_empty_lngth_be_between_to(int arg1, int arg2) throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		//user specified error message
		String expErrorMsg = "User Id should not be empty / length be between "+arg1+" to "+arg2;
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();	
	}

	@When("^user enters invalid password$")
	public void user_enters_invalid_password() throws Throwable {
		regPage.setUserId("161741");
		//Passing empty password which is invalid
		regPage.setPassword("");
		regPage.clickSubmitButton();
	}

	@Then("^Display alert box 'Password should not be empty/ length be between (\\d+) to (\\d+)'$")
	public void display_alert_box_Password_should_not_be_empty_length_be_between_to(int arg1, int arg2) throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		//user specified error message
		String expErrorMsg = "Password should not be empty / length be between "+arg1+" to "+arg2;
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
	@When("^user enters invalid username$")
	public void user_enters_invalid_username() throws Throwable {
		regPage.setUserId("161741");
		regPage.setPassword("SwethaPanga");
		//Passing invalid username to the registration form
		regPage.setUserName("123456");
		regPage.clickSubmitButton();

	}

	@Then("^Display alert box 'Username should not be empty and must have alphabet characters only'$")
	public void display_alert_box_Username_should_not_be_empty_and_must_have_alphabet_characters_only() throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		//user specified error message
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
		//Passing invalid address to the registration form
		regPage.setAddress("$#%^&*");
		regPage.clickSubmitButton();

	}

	@Then("^Display alert box 'User address must have alphanumeric characters only'$")
	public void display_alert_box_User_address_must_have_alphanumeric_characters_only() throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		//user specified error message
		String expErrorMsg = "User address must have alphanumeric characters only";
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();

	}
	@When("^Country is not selected$")
	public void country_is_not_selected() throws Throwable {
		regPage.setUserId("161741");
		regPage.setPassword("SwethaPanga");
		regPage.setUserName("SwethaPanga");
		regPage.setAddress("Hyderabad123");
		//Not selecting any country
		//regPage.setCountry("");
		regPage.clickSubmitButton();
	}

	@Then("^Display alert 'select your country from the list'$")
	public void display_alert_select_your_country_from_the_list() throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		//user specified error message
		String expErrorMsg = "Select your country from the list";
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();

	}
	@When("^user enters invalid zip code$")
	public void user_enters_invalid_zip_code() throws Throwable {
		regPage.setUserId("161741");
		regPage.setPassword("SwethaPanga");
		regPage.setUserName("SwethaPanga");
		regPage.setAddress("Hyderabad123");
		regPage.setCountry("India");
		//Passing invalid zipcode to the registration form
		regPage.setZipCode("abc");
		regPage.clickSubmitButton();

	}

	@Then("^Display alert 'Zip code must have numeric characters only'$")
	public void display_alert_Zip_code_must_have_numeric_characters_only() throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		//user specified error message
		String expErrorMsg = "ZIP code must have numeric characters only";
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();


	}

	@When("^Invalid email is entered$")
	public void invalid_email_is_entered() throws Throwable {
		regPage.setUserId("161741");
		regPage.setPassword("SwethaPanga");
		regPage.setUserName("SwethaPanga");
		regPage.setAddress("Hyderabad123");
		regPage.setCountry("India");
		regPage.setZipCode("502291");
		//Passing invalid email address to the registration form
		regPage.setEmail("capgemini");
		regPage.clickSubmitButton();

	}

	@Then("^Display alert 'You have entered an Invalid email address'$")
	public void display_alert_You_have_entered_an_Invalid_email_address() throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		//user specified error message
		String expErrorMsg = "You have entered an invalid email address!";
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();

	}

	@When("^gender not selected$")
	public void gender_not_selected() throws Throwable {
		regPage.setUserId("161741");
		regPage.setPassword("SwethaPanga");
		regPage.setUserName("SwethaPanga");
		regPage.setAddress("Hyderabad123");
		regPage.setCountry("India");
		regPage.setZipCode("502291");
		regPage.setEmail("capgemini@gmail.com");
		//Not selecting gender
		regPage.clickSubmitButton();

	}

	@Then("^Display alert 'please select gender'$")
	public void display_alert_please_select_gender() throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		//user specified error message
		String expErrorMsg = "Please Select gender";
		assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();

	}
	@When("^user enters all valid details$")
	public void user_enters_all_valid_details() throws Throwable {
		//All Valid details
		regPage.setUserId("161741");
		regPage.setPassword("SwethaPanga");
		regPage.setUserName("SwethaPanga");
		regPage.setAddress("Hyderabad123");
		regPage.setCountry("India");
		regPage.setZipCode("502291");
		regPage.setEmail("capgemini@gmail.com");
		regPage.setGender("female");
		regPage.clickSubmitButton();

	}

	@Then("^Display alert 'Your Registration with JobsWorld\\.com has successfully done'$")
	public void display_alert_Your_Registration_with_JobsWorld_com_has_successfully_done() throws Throwable {
		String actualErrorMsg = driver.switchTo().alert().getText();
		//Successfull registration form alert message
		String expErrorMsg = "Your Registration with JobsWorld.com has successfully done plz check your registred email addres to activate your profile";
		assertEquals(expErrorMsg, actualErrorMsg);

	}
}
