package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTestClass;

public class HomePage extends BaseTestClass {

	// Constructor to invoke driver
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[1]/label")
	public WebElement from;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")
	public WebElement fromInput;

	@FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin']/div/div/div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']/ul/li")
	public WebElement fromOption;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[2]/label")
	public WebElement to;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")
	public WebElement toInput;

	@FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin']/div/div/div[@class='react-autosuggest__section-container react-autosuggest__section-container--first']/ul/li")
	public WebElement toOption;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/label")
	public WebElement dateField;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")
	public WebElement next;

	@FindBy(xpath = "//div[@class='DayPicker']//div[@class='DayPicker-Months']/div[2]/div[@class='DayPicker-Body']/div[2]/div[6]")
	public WebElement date;

	@FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/p/a")
	public WebElement searchButton;

	// Enter Origin Place
	public void enterOrigin(String origin) {
		try {
			from.click();
			fromInput.sendKeys(origin);
			Thread.sleep(3000);
			fromOption.click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Enter Destination Place
	public void enterDestination(String destination) {
		try {
			to.click();
			toInput.sendKeys(destination);
			Thread.sleep(3000);
			toOption.click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Selecting Date
	public void dateSelect() {
		try {
			dateField.click();
			next.click();
			date.click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Clicking Search Button
	public FlightResult clickSearchButton() {
		searchButton.click();
		return PageFactory.initElements(driver, FlightResult.class);
	}

}
