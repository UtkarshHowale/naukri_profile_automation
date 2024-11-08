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

	@FindBy(xpath = "//div[@class=\"widgetHead\"]//span[@class=\"edit icon\"]")
	WebElement resume_headline_element;

	@FindBy(xpath = "//textarea[@id='resumeHeadlineTxt']")
	WebElement resume_headline_text_area_element;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save_button_element;

	@FindBy(xpath = "//p[@class='msg' and text() = \"Resume Headline has been successfully saved.\"]")
	WebElement update_success_text;

	private void clickOnResumeHeadline() {

		try {

			TestUtils.waitUntilVisiblityOfElement(resume_headline_element, 10);
			resume_headline_element.click();

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

	private void clickOnSaveButton() {

		try {

			TestUtils.waitUntilVisiblityOfElement(save_button_element, 10);
			save_button_element.click();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getHeadlineUpdateSuccessMessage() {

		TestUtils.waitUntilVisiblityOfElement(update_success_text, 10);
		return update_success_text.getText();
	}

	public void updateResumeHeadline(String resumeHeadline) {

		clickOnResumeHeadline();
		setResumeHeadlineTextArea(resumeHeadline);
		clickOnSaveButton();
	}
}
