package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import pom.HomePage;

public class BaseTestClass {

	public WebDriver driver;

	// Invoke Browser
	public void invokeBrowser(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver(options);
			} else if (browserName.equalsIgnoreCase("Firefox")) {

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--disable-notifications");

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver(options);
			} else {
				System.out.println("no browser selected");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	// Open Website
	public HomePage openWebsite() {
		driver.get("https://www.makemytrip.com/");
		return PageFactory.initElements(driver, HomePage.class);
	}

	// Close Browser
	@AfterMethod
	public void close() {
		driver.quit();
	}

	// Screenshot function
	public void takeScreenshot() {

		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "\\Screenshot\\Screenshot.png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
