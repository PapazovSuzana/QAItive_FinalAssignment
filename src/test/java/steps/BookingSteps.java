package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingHomePage;
import pages.HotelPage;
import pages.SearchResultsPage;
import tests.BaseTest;

import java.io.IOException;

public class BookingSteps extends BaseTest {


    @Before
    public void initCucumber() {
        init("Chrome", Integer.parseInt("5"));
    }

    @After
    public void tearDown() throws IOException {
        reportScreenshot("Test", "TestAllure");
        quitDriver();
    }


    @Given("I am on booking home page")
    public void iAmOnBookingHomePage() {
        driver.get("https://www.booking.com/");
    }

    @When("I change language to {string}")
    public void iChangeLanguageTo(String language) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.selectLanguage(language);
    }

    @And("I add destination {string}")
    public void iAddDestination(String location) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.enterLocation(location);
    }

    @And("I add start and end date {string} {string}")
    public void iAddStartAndEndDate(String start, String end) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.selectDates(start, end);
    }

    @And("I set two children with {string} and {string} year old")
    public void iSetTwoChildrenWithAndYearOld(String arg0, String arg1) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.openGuestsToggle();
        bookingHomePage.setNumberOfChildren();

    }

    @And("I click Submit button")
    public void iClickSubmitButton() {
        BookingHomePage bookingHomePage = new BookingHomePage(driver, wdWait);
        bookingHomePage.clickSubmitButton();
    }

    @And("I validate Search results {string} {string} {string}")
    public void iValidateSearchResults(String destination, String startDate, String endDate) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wdWait);
        searchResultsPage.validateDestinationAndPeriodOfStaying(destination, startDate, endDate);
        System.out.println("destination is " + destination + " and start date is   " + startDate + " and end date is " + endDate + ".");


    }

    @And("I validate {string} adults and {string} children and {string} room is chosen")
    public void iValidateAdultsAndChildrenAndRoomIsChosen(String adults, String children, String rooms) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wdWait);
        searchResultsPage.validateNumberOfGuestsAndRooms(adults, children, rooms);
    }

    @And("I choose filter by {string}")
    public void iChooseFilterBy(String filter) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wdWait);
        searchResultsPage.setFilter(filter);
    }

    @Then("I choose {string} hotel")
    public void iChooseHotel(String hotel) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wdWait);
        searchResultsPage.chooseHotel(hotel);
    }

    @And("validate that {string} hotel is opened")
    public void validateThatHotelIsOpened(String hotel) {
        HotelPage hotelPage = new HotelPage(driver, wdWait);
        hotelPage.validateOpenedHotel(hotel);
    }
}
