package stepDefinitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataReader;

public class Steps {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	public String br;
	HomePage hp;
	LoginPage lp;
	MyAccountPage myacc;
	List<HashMap<String, String>> datamap;

	@Before
	public void setup() {

		rb = ResourceBundle.getBundle("config");
		br = rb.getString("browser");
		logger = LogManager.getLogger(this.getClass());

	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Scenario status ------>" + scenario.getStatus());
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			ts.getScreenshotAs(OutputType.BYTES);
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		driver.quit();

	}

	@Given("User Launch browser")
	public void user_launch_browser() {
		// WebDriverManager.chromedriver().setup();
		if (br.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			driver = new ChromeDriver(options);
		}

		else if (br.equals("edge"))
			driver = new EdgeDriver();

		else
			driver = new FirefoxDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// driver.get("http://localhost/opencart/upload/");

	}

	@Given("opens URL {string}")
	public void opens_url(String url) {
		driver.get(url);
	}

	@When("User navigate to MyAccount menu")
	public void user_navigate_to_my_account_menu() {
		hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account");
	}

	@When("click on Login")
	public void click_on_login() {
		hp.clickLoginLink();
		logger.info("Clicked on Login Link");

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp = new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(password);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		lp.clickLogin();

	}

	@Then("User navigates to MyAccount Page")
	public void user_navigates_to_my_account_page() {
		try {
			myacc = new MyAccountPage(driver);
			boolean target = myacc.myAccountPageExist();
			if (target)
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);
			// Assert.assertEquals(target, true);

		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}

	}

	@Then("User navigates to MyAccount Page by passing email and password with excel row {string}")
	public void user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_row(String rows) {

		datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\Opencart_LoginTestData.xlsx", "Sheet1");

		int index = Integer.parseInt(rows) - 1;
		String email = datamap.get(index).get("username");
		String pwd = datamap.get(index).get("password");
		String exp_res = datamap.get(index).get("res");

		lp = new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(pwd);

		lp.clickLogin();
		try {
			myacc = new MyAccountPage(driver);
			boolean targetpage = myacc.myAccountPageExist();
			if (exp_res.equals("Valid")) {
				if (targetpage == true) {
					MyAccountPage myaccpage = new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp_res.equals("Invalid")) {
				if (targetpage == true) {
					myacc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

}
