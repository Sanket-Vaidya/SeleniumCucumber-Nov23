package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	public WebElement MyAccount;

	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	public WebElement logout;

	public boolean myAccountPageExist() {
		try {
			return (MyAccount.isDisplayed());
		} catch (Exception e) {

			return false;

		}
	}

	public void clickLogout() {
		logout.click();
	}

}
