package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.TestUtils;

public class BasePage {

	public static WebDriver driver;
	public static ChromeOptions options;
	public static FileInputStream file;
	public static Properties prop;

	public BasePage() {

		try {

			file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Files\\config.properties");

			prop = new Properties();
			prop.load(file);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void intilizeConfiguration() {

		String browser = prop.getProperty("BrowserName");

		switch (browser.toLowerCase()) {

		case "chrome":

//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
//			driver = new ChromeDriver(options);

			driver = new ChromeDriver();
			break;

		case "firefox":

			driver = new FirefoxDriver();
			break;

		case "edge":

			driver = new EdgeDriver();
			break;

		default:

			System.out.println("Unsupported browser...!!!");
			break;
		}

		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.ImplicitlyWait_TimeOut));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PageLoad_Timeout));
		System.out.println("Browser lounched...!!");
	}

	public static void closeConfiguration() {

		driver.quit();
		System.out.println("Browser closed...!!");
		System.out.println("==================Test Completed Successfully=================");
	}
}
