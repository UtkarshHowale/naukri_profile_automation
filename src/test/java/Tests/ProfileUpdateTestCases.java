package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BasePage;
import Pages.DashboardPage;
import Pages.HomePage;
import Pages.ProfilePage;

public class ProfileUpdateTestCases extends BasePage {

	public ProfileUpdateTestCases() {

		super();
	}

	private HomePage homePage;
	private DashboardPage dashboardPage;
	private ProfilePage profilePage;

	@BeforeMethod
	public void setUpConfig() {

		intilizeConfiguration();
		homePage = new HomePage();
		dashboardPage = new DashboardPage();
		profilePage = new ProfilePage();

	}

	@AfterMethod
	public void tearDownConfig() {

		closeConfiguration();
	}

	@Test
	public void updateProfileTest() {

		System.out.println("Login into the naukari profile with entring username & password");
		dashboardPage = homePage.loginToNaukariProfile(prop.getProperty("Username"), prop.getProperty("Password"));
		System.out.println("Verfiy correct user is logged in.");
		System.out.println("Sucessfully logged in with the correct user.");
		assertEquals(dashboardPage.getProfileName(), prop.getProperty("ProfileName"),
				"Profile title not matching as expected...!!!");
		System.out.println("Navigate to the profile page.");
		profilePage = dashboardPage.navigateToProfilePage();
		System.out.println("Update the resume headline.");
		profilePage.updateResumeHeadline(prop.getProperty("ResumeHeadline"));
		System.out.println("Verify resume headline is updated.");
		assertEquals(profilePage.getHeadlineUpdateSuccessMessage(), prop.getProperty("HeadlineUpdateSuccessMessage"),
				"Resume headline is not updated...!!!");
		System.out.println("Resume headline is updated successfully");

	}
}
