package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import Utils.TestUtils;

public class DashboardPage extends BasePage {

	public DashboardPage() {

		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//div[@class=\"info__heading\"]") WebElement info_heading_element;

	private @FindBy(xpath = "//div[@class=\"view-profile-wrapper\"]//a[@href=\"/mnjuser/profile\"]") WebElement view_profile_button_element;

	private WebElement getProfileTitle() {

		TestUtils.waitUntilVisiblityOfElement(info_heading_element, 10);
		return info_heading_element;
	}

	public String getProfileName() {

		return getProfileTitle().getText();
	}

	private WebElement getProfilePage() {

		TestUtils.waitUntilVisiblityOfElement(view_profile_button_element, 10);
		return view_profile_button_element;
	}

	public ProfilePage navigateToProfilePage() {

		try {

			getProfilePage().click();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return new ProfilePage();
	}

}
