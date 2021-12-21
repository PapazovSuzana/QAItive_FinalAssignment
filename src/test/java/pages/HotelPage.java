package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public HotelPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    String hotelName = "//div[@data-testid='title' and contains(text(),'$')]";

    public void validateOpenedHotel(String hotel) {
        driver.findElement(By.xpath(hotelName.replace("$", hotel))).isDisplayed();


    }
}
