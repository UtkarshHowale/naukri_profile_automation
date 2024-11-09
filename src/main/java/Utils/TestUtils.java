package Utils;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BasePage;

public class TestUtils extends BasePage {

	public static long PageLoad_Timeout = 10;
	public static long ImplicitlyWait_TimeOut = 10;
	public static WebDriverWait wait;

	public static void waitUntilVisiblityOfElement(WebElement element, long time) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitFewSeconds(long time) {

		try {

			Thread.sleep(time);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static String takeScreenShot() throws Exception {
		File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Path = System.getProperty("user.dir") + "/ScreenShot/" + System.currentTimeMillis() + ".png";

		FileUtils.copyFile(screenshotAs, new File(Path));

		return Path;
	}
}
