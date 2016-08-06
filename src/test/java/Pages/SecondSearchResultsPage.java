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
public class SecondSearchResultsPage extends SearchResultsPage {

    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(css = ".f.kv._SWb")
    private List<WebElement> searchResultsField;

    /**
     * Factory class to make using Page Objects simpler and easier.
     */
    public SecondSearchResultsPage() {
        PageFactory.initElements(driver, this);
        implicitWaitForElement(searchField);
    }

    /**
     * A method searchResultsFieldsSize counts web elements searchResultsField on the page.
     * Use @Override to find the same web elements on a new web page.
     */
    @Override
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
   @Override
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
}
