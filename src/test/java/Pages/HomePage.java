package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for Home page.
 *
 * Defining WebElements by locators.
 */

public class HomePage extends AbstractPage {
    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(name = "btnG")
    private WebElement searchButton;
    @FindBy (css = ".f.kv._SWb")
    private WebElement searchResultsField;

    /**
     * Factory class to make using Page Objects simpler and easier.
     */
    public HomePage() {
        driver.get("https://www.google.com.ua/");
        PageFactory.initElements(driver, this);
        implicitWaitForElement(searchField);
    }

    /**
     * Fill search form
     * @param searchtext - text, searching by user
     * @return
     */
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
