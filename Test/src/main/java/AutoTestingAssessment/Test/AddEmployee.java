package AutoTestingAssessment.Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee {
	WebDriver driver;
	
	@FindBy(id="firstName")
	WebElement firstNameInput ;
	
	@FindBy(id="middleName")
	WebElement middleNameInput;
	
	@FindBy(id="lastName")
	WebElement lastNameInput;
	
	@FindBy(id="employeeId")
	WebElement employeeIdInput;
	
	@FindBy(id="photofile")
	WebElement photoInput;
		
	@FindBy(id="chkLogin")
	WebElement checkLoginToggle;
	
	@FindBy(id="user_name")
	WebElement userNameInput;
	
	@FindBy(id="user_password")
	WebElement userPasswordInput;
	
	@FindBy(id="re_password")
	WebElement reUserPasswordInput ;
	
	@FindBy(id="btnSave")
	WebElement saveBtn;
	
	
	public AddEmployee(WebDriver driver){
		this.driver = driver;
	}
	
	public void addBasicDetails() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.visibilityOf(firstNameInput));
		//fill in details
		firstNameInput.sendKeys(Constant.FIRST_NAME);
		middleNameInput.sendKeys(Constant.MIDDLE_NAME);
		lastNameInput.sendKeys(Constant.LAST_NAME);
		employeeIdInput.sendKeys(Constant.EMPLOYEE_ID);

		photoInput.sendKeys(Constant.IMAGE_PATH);
	}
	
	public void chooseToCreateLogIn() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions builder = new Actions(driver);
		
		wait.until(ExpectedConditions.visibilityOf(checkLoginToggle));
		System.out.println(checkLoginToggle.getAttribute("value"));
		builder.moveToElement(checkLoginToggle).click().perform();
		System.out.println(checkLoginToggle.getAttribute("value"));
	}
	
	public void addLoginDetails() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions builder = new Actions(driver);
		
		String userName = Constant.NEW_USER_USERNAME + Math.random()*1000;
		
		wait.until(ExpectedConditions.visibilityOf(userNameInput));
		
		userNameInput.sendKeys(userName);
		userPasswordInput.sendKeys(Constant.NEW_USER_PASSWORD);
		reUserPasswordInput.sendKeys(Constant.NEW_USER_PASSWORD);
		
	}
	
	public void clickSave() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions builder = new Actions(driver);
		
		//submit form
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		builder.moveToElement(saveBtn).click().perform();
	}
}
