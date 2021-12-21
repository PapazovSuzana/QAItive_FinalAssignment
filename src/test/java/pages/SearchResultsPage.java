package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    String selectDestination = "//input[@class='c-autocomplete__input sb-searchbox__input sb-destination__input' and contains(@value, '$') ]";
    String selectStartDate = "//div[@data-placeholder='Datum prijavljivanja' and contains (text(), '$') ]";
    String selectEndDate = "//div[@data-placeholder='Datum odjavljivanja' and contains (text(), '$') ]";
    String numberOfAdults = "//span[@Class='adults-count' and contains (text(), '$')]";
    String numberOfKids = "//span[@Class='children-count' and contains (text(), '$')]";
    String numberOfRooms = "//span['data-room-count' and contains (text(), '$')]";
    String brekfastAndDinnerIncludedFulter = "//div[@data-filters-group='popular']//div[ contains(text(), '$')]";
    String selectHotel = "//a[@role = 'button' and contains(@href, '$')]";


    public void validateDestinationAndPeriodOfStaying(String destination, String startDate, String endDate) {
        driver.findElement(By.xpath(selectDestination.replace("$", destination))).isDisplayed();
        driver.findElement(By.xpath(selectStartDate.replace("$", startDate))).isDisplayed();
        driver.findElement(By.xpath(selectEndDate.replace("$", endDate))).isDisplayed();
    }

    public void validateNumberOfGuestsAndRooms(String adults, String children, String rooms) {
        driver.findElement(By.xpath(numberOfAdults.replace("$", adults))).isDisplayed();
        driver.findElement(By.xpath(numberOfKids.replace("$", children))).isDisplayed();
        driver.findElement(By.xpath(numberOfRooms.replace("$", rooms))).isDisplayed();
    }

    public void setFilter(String filter) {
        click(driver.findElement(By.xpath(brekfastAndDinnerIncludedFulter.replace("$", filter))));
    }

    public void chooseHotel(String hotel) {
        click(driver.findElement(By.xpath(selectHotel.replace("$", hotel))));
    }


}
