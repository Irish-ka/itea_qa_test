package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Page Object for SearchResults page.
 *
 * Defining WebElements by locators.
 */
public class SearchResultsPage extends AbstractPage {
    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy (css = ".f.kv._SWb")
    private List<WebElement> searchResultsField;
    @FindBy(xpath = ".//*[@id='nav']/tbody/tr/td[3]/a")
    private WebElement secondPageButton;

    /**
     * Factory class to make using Page Objects simpler and easier.
     */
    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
        implicitWaitForElement(searchField);
    }

    /**
     * A method searchResultsFieldsSize counts web elements searchResultsField on the page.
     *
     */
    public int searchResultsFieldsSize() {
        implicitWaitForListOfElement(searchResultsField);
        return searchResultsField.size();
    }

     private List<String> getTitlesList() {
        List<String> titleTextList = new ArrayList<String>();
         implicitWaitForListOfElement(searchResultsField);
         Iterator<WebElement> i = searchResultsField.iterator();
        while (i.hasNext()) {
            WebElement titleTextWebElement = i.next();
            String titleText = titleTextWebElement.getText();
            titleTextList.add(titleText);
        }
        return titleTextList;
    }

    /**@param searchTerm - search term consists of uppercase letters.
     * @param searchTerm1 - search term consists of lowercase letters.
     * A method verifies every searchResultsField contains search term.
     */
    public boolean isSearchTermContained(String searchTerm, String searchTerm1) {
        List<String> titleTextList = getTitlesList();
        boolean isSearchTermContained = false;
        for (int i=0; i<titleTextList.size(); i++) {
            if (titleTextList.get(i).contains(searchTerm));
            else if (titleTextList.get(i).contains(searchTerm1)){
                isSearchTermContained = true;
            }
        }
        return isSearchTermContained;
    }

    /**
     * A method switch search pages by clicking button "2".
     *
     */
    public SecondSearchResultsPage changeResultsPage() {
        implicitWaitForElement(secondPageButton);
        secondPageButton.click();
        return new SecondSearchResultsPage();
    }

}
