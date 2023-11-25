package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@name='telephone']")
	public WebElement telephone;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@name='confirm']")
	public WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	public WebElement policyCheckBox;

	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement btnContinue;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	public WebElement myAccountPage;

	public void enterFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	public void enterTelephone(String telephone) {
		this.telephone.sendKeys(telephone);
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		this.confirmPassword.sendKeys(confirmPassword);
	}

	public void clickCheckbox() {
		policyCheckBox.click();
	}

	public void clickBtnContinue() {
		btnContinue.click();
	}

	public String successfullResgistration() {
		try {
			return myAccountPage.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
