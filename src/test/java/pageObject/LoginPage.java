package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	public WebElement inputEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	public WebElement inputPassword;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement btnLogin;

	public void enterEmail(String email) {
		inputEmail.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		inputPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

}
