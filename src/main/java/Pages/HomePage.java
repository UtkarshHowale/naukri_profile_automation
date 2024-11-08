package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import Utils.TestUtils;

public class HomePage extends BasePage {

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login_Layer")
	WebElement loginButton_element;

	@FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
	WebElement username_element;

	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	WebElement password_element;

	@FindBy(css = "button[type='submit']")
	WebElement login_button_element;

	private WebElement getUsername() {

		TestUtils.waitUntilVisiblityOfElement(username_element, 10);
		return username_element;
	}

	private void setUsername(String username) {

		getUsername().sendKeys(username);
	}

	private WebElement getPassword() {

		TestUtils.waitUntilVisiblityOfElement(password_element, 10);
		return password_element;
	}

	private void setPassword(String password) {

		getPassword().sendKeys(password);
	}

	private void clickLoginButton() {

		try {

			TestUtils.waitUntilVisiblityOfElement(login_button_element, 10);
			login_button_element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void openLoginPanal() {

		try {

			TestUtils.waitUntilVisiblityOfElement(loginButton_element, 10);
			loginButton_element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public DashboardPage loginToNaukariProfile(String enterUsername, String enterPassword) {

		openLoginPanal();
		setUsername(enterUsername);
		setPassword(enterPassword);
		clickLoginButton();

		return new DashboardPage();
	}
}
