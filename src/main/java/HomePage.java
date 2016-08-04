import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by ira on 04.08.16.
 */
public class HomePage extends AbstractPage {
    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(name = "btnG")
    private WebElement searchButton;
    @FindBy (css = ".f.kv._SWb")
    private WebElement searchResultsField;

    public HomePage() {
        driver.get("https://www.google.com.ua/");
        PageFactory.initElements(driver, this);
        implicitWaitForElement(searchField);
    }

    public SearchResultsPage fillSearchForm(String searchtext) {
        searchField.sendKeys(searchtext);
        searchButton.click();
        return new SearchResultsPage();
    }

    public boolean isSearchResultsFieldDisplayed() {
        implicitWaitForElement(searchResultsField);
        return searchResultsField.isDisplayed();
    }




}
