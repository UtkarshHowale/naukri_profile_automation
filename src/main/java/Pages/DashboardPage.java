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

	@FindBy(xpath = "//div[@class=\"info__heading\"]")
	WebElement info_heading_element;

	@FindBy(xpath = "//div[@class=\"view-profile-wrapper\"]//a[@href=\"/mnjuser/profile\"]")
	WebElement view_profile_button_element;

	public String getProfileTitleName() {

		TestUtils.waitUntilVisiblityOfElement(info_heading_element, 10);
		return info_heading_element.getText();
	}

	public ProfilePage navigateToProfilePage() {

		try {

			TestUtils.waitUntilVisiblityOfElement(view_profile_button_element, 10);
			view_profile_button_element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return new ProfilePage();
	}

}
