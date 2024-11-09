package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import Utils.TestUtils;

public class ProfilePage extends BasePage {

	public ProfilePage() {

		PageFactory.initElements(driver, this);
	}

	private @FindBy(xpath = "//div[@class=\"widgetHead\"]//span[@class=\"edit icon\"]") WebElement resume_headline_element;

	private @FindBy(xpath = "//textarea[@id='resumeHeadlineTxt']") WebElement resume_headline_text_area_element;

	private @FindBy(xpath = "//button[normalize-space()='Save']") WebElement save_button_element;

	private @FindBy(xpath = "//p[@class='msg' and text() = \"Resume Headline has been successfully saved.\"]") WebElement update_success_text;

	private WebElement getResumeHeadline() {

		TestUtils.waitUntilVisiblityOfElement(resume_headline_element, 10);
		return resume_headline_element;
	}

	private void clickOnResumeHeadline() {

		try {

			getResumeHeadline().click();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private WebElement getResumeHeadlineTextArea() {

		TestUtils.waitUntilVisiblityOfElement(resume_headline_text_area_element, 10);
		return resume_headline_text_area_element;
	}

	private void setResumeHeadlineTextArea(String headline) {

		WebElement textArea = getResumeHeadlineTextArea();
		textArea.clear();
		textArea.sendKeys(headline);
	}

	private WebElement getSaveButton() {

		TestUtils.waitUntilVisiblityOfElement(save_button_element, 10);
		return save_button_element;
	}

	private void clickOnSaveButton() {

		try {

			getSaveButton().click();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private WebElement getHeadlineUpdateMessage() {

		TestUtils.waitUntilVisiblityOfElement(update_success_text, 10);
		return update_success_text;
	}

	public String getHeadlineUpdateSuccessMessage() {

		return getHeadlineUpdateMessage().getText();
	}

	public void updateResumeHeadline(String resumeHeadline) {

		clickOnResumeHeadline();
		setResumeHeadlineTextArea(resumeHeadline);
		clickOnSaveButton();
	}
}
