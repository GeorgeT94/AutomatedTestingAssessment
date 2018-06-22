package AutoTestingAssessment.Test;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	ChromeDriver driver;
	static ExtentReports extent;
	static ExtentTest test;
	ExtentManager extentManager;
	
	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Testing\\chromedriver.exe");
		driver = new ChromeDriver();
		
		extent = new ExtentReports(Constant.EXTENT_REPORT_PATH, true);
		
		extentManager = new ExtentManager(driver, extent);
		extentManager.startTest("Verify Employee Sign up");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		DashBoard dashboard = PageFactory.initElements(driver, DashBoard.class);
		//Reading from excel
		Excel excel = new Excel();
		excel.read();
		
		dashboard.logIn(Constant.ADMIN_USER, Constant.ADMIN_PASSWORD);
		
		extentManager.atDashBoard();

		dashboard.addUserPage();

		extentManager.atEmployeePage();
	}
	
	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() throws Throwable {
		AddEmployee addEmployee = PageFactory.initElements(driver, AddEmployee.class);
		
		addEmployee.addBasicDetails();

	}
	
	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() throws Throwable {
		AddEmployee addEmployee = PageFactory.initElements(driver, AddEmployee.class);

	    addEmployee.chooseToCreateLogIn();
	}
	
	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() throws Throwable {
		AddEmployee addEmployee = PageFactory.initElements(driver, AddEmployee.class);

	    addEmployee.addLoginDetails();
	}
	
	@When("^I click the Save button$")
	public void i_click_the_Save_button() throws Throwable {
		AddEmployee addEmployee = PageFactory.initElements(driver, AddEmployee.class);

	    addEmployee.clickSave();
	}
	
	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() throws Throwable {
		extentManager.checkUserAdded();
	    extent.flush();
	    driver.quit();
}
}
