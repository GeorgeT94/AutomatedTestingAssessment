package AutoTestingAssessment.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentManager {
	ChromeDriver driver;
	static ExtentReports extent;
	static ExtentTest test;
	
	public ExtentManager(ChromeDriver driver, ExtentReports extent) {
		this.driver = driver;
		this.extent = extent;
	}
	
	public void startTest(String testName) {
		test = extent.startTest(testName);
	}
	
	public void atDashBoard() {
		try {
			assertTrue("You did not reach the log in page", driver.getCurrentUrl().equals(Constant.DASHBOARD));
			test.log(LogStatus.PASS, "User logged into Dashboard");
		}catch(AssertionError e) {
				test.log(LogStatus.FAIL, "Not on Dashboard");
				
				fail();
		}finally {
			test.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test);
		}
	}
	
	public void atEmployeePage() {
		try {
			assertTrue("You did not reach the add employee page", driver.getCurrentUrl().equals(Constant.ADD_EMPLOYEE));
			test.log(LogStatus.PASS, "Successfully reached the add employee page");
		}catch(AssertionError e) {
				test.log(LogStatus.FAIL, "Not on add employee page");
				
				fail();
		}finally {
			test.log(LogStatus.INFO, "Current URL: " + driver.
					getCurrentUrl());
			extent.endTest(test);
		}
	}
	
	public void checkUserAdded() {
		WebElement personalDetails = driver.findElement(By.className("personalDetails"));
		
		try {
			assertTrue("Employee was not added", personalDetails.isDisplayed());
			test.log(LogStatus.PASS, "Employee Added to database");
		}catch(AssertionError e) {
				test.log(LogStatus.FAIL, "Employee was not added");
				
				fail();
		}finally {
			test.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test);
		}
	}
	
	public void flush() {
		extent.flush();
	}
}
