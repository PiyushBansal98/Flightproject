package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseTestClass;
import utilities.Excelutil_POI;

public class FlightResult extends BaseTestClass {

	// Constructor to invoke driver
	public FlightResult(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id=\"sorting-togglers\"]/div[5]/span/span[1]")
	public WebElement priceOrder;

	// Frist Flight
	@FindBy(xpath = "//div[@class='fli-intl-lhs pull-left' and @id='left-side--wrapper']/div[3]/div/div[1]//div[@class='pull-left airline-info']/div[2]//span")
	public WebElement flightname;

	@FindBy(xpath = "//div[@class='fli-intl-lhs pull-left' and @id='left-side--wrapper']/div[3]/div/div[1]//div[@class='fli-list-body-section']//div[@class='dept-options-section clearfix']/div[3]//span")
	public WebElement price;

	// Get Top Five Flights Details
	public void getTopFiveFlight() throws Exception {
		priceOrder.click();

		List<String> flightName = new ArrayList<String>();
		for (int i = 1; i < 6; i++) {
			flightName.add(driver
					.findElement(By
							.xpath("//div[@class='fli-intl-lhs pull-left' and @id='left-side--wrapper']/div[3]/div/div["
									+ i + "]//div[@class='pull-left airline-info']/div[2]//span"))
					.getText()
					+ " : "
					+ driver.findElement(By.xpath(
							"//div[@class='fli-intl-lhs pull-left' and @id='left-side--wrapper']/div[3]/div/div[" + i
									+ "]//div[@class='fli-list-body-section']//div[@class='dept-options-section clearfix']/div[3]//span"))
							.getText());
		}

		for (int i = 0; i < 5; i++) {
			Excelutil_POI.setCellData(flightName.get(i), i + 6, 0);
			System.out.println(flightName.get(i));

		}

	}

}
