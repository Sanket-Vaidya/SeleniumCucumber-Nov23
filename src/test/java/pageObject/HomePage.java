package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement myAccount;

	@FindBy(xpath = "//a[text()='Register']")
	public WebElement register;

	@FindBy(xpath = "//a[text()='Login']")
	public WebElement loginLink;

	public void clickMyAccount() {
		myAccount.click();
	}

	public void clickRegister() {
		register.click();
	}

	public void clickLoginLink() {
		loginLink.click();
	}

}
