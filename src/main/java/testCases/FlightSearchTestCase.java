package testCases;

import org.testng.annotations.Test;

import base.BaseTestClass;
import pom.FlightResult;
import pom.HomePage;
import utilities.Excelutil_POI;

public class FlightSearchTestCase extends BaseTestClass {

	HomePage homePage;
	FlightResult flightResult;

	@Test
	public void findingFlights() throws Exception {

		Excelutil_POI.setExcelFile("C:\\Users\\Ujjwal Jain\\Documents\\Java Program Maven\\FlightProject\\TestData\\MakeMyTrip.xlsx","Sheet1");

		invokeBrowser("chrome");
		homePage = openWebsite();
		homePage.enterDestination(Excelutil_POI.getCellData(1, 1));
		homePage.enterOrigin(Excelutil_POI.getCellData(1, 0));
		homePage.dateSelect();
		flightResult = homePage.clickSearchButton();
		flightResult.getTopFiveFlight();
		takeScreenshot();
	}

}