package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BookingHomePage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BookingHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-modal-id='language-selection']")
    WebElement languageIcon;
    String languageLinkXpath = "//div[@class='bui-group bui-group--large']/div[2]//div[contains(text(),'$')]/../..";
    @FindBy(css = "#ss")
    WebElement location;
    @FindBy(css = ".xp__dates.xp__group")
    WebElement dates;
    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    WebElement next;
    @FindBy(xpath = "//label[@id='xp__guests__toggle']")
    WebElement guests;
    @FindBy(xpath = "//button[@aria-label='Deca: povećajte broj']")
    WebElement raiseNumberOfChildrenButton;
    @FindBy(xpath = "//select[@aria-label='Uzrast deteta 1']")
    WebElement listOfAgeforFirstChild;
    @FindBy(xpath = "//select[@aria-label='Uzrast deteta 2']")
    WebElement listOfAgeforSecondChild;
    @FindBy(xpath = "//option[contains(text(), '4 godine')]")
    WebElement firstChildAge;
    @FindBy(xpath = "//select[@aria-label='Uzrast deteta 2']/option[contains(text(), '1 godina') and @value='1']")
    WebElement secondChildAge;
    @FindBy(xpath = "//button[@type='submit']/span[contains (text(),'Traži')]")
    WebElement searchButton;


    public void selectLanguage(String language) {
        click(languageIcon);
        click(driver.findElement(By.xpath(languageLinkXpath.replace("$", language))));
    }

    public void enterLocation(String locationValue) {
        typeText(location, locationValue);
    }


    /**
     * Selects start and end date
     *
     * @param startDate format DD month YYYY
     * @param endDate   format DD month YYYY
     */
    public void selectDates(String startDate, String endDate) {
        click(dates);

        while (true) {
            List<WebElement> startDateList = driver.findElements(By.xpath("//span[@aria-label='" + startDate + "']"));

            if (startDateList.size() == 0) {
                click(next);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + startDate + "']")));
                break;
            }
        }

        while (true) {
            List<WebElement> endDateList = driver.findElements(By.xpath("//span[@aria-label='" + endDate + "']"));

            if (endDateList.size() == 0) {
                click(next);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + endDate + "']")));
                break;
            }
        }
    }

    public void openGuestsToggle() {
        guests.click();
    }

    public void setNumberOfChildren() {
        raiseNumberOfChildrenButton.click();
        listOfAgeforFirstChild.click();
        firstChildAge.click();
        raiseNumberOfChildrenButton.click();
        listOfAgeforSecondChild.click();
        secondChildAge.click();
    }

    public void clickSubmitButton() {
        searchButton.click();

    }


}
