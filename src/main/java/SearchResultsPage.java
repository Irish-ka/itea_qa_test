import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ira on 04.08.16.
 */
public class SearchResultsPage extends AbstractPage {
    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy (css = ".f.kv._SWb")
    private List<WebElement> searchResultsField;
    @FindBy(xpath = ".//*[@id='nav']/tbody/tr/td[3]/a")
    private WebElement secondPageButton;


    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
        implicitWaitForElement(searchField);
    }

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

    public SecondSearchResultsPage changeResultsPage() {
        implicitWaitForElement(secondPageButton);
        secondPageButton.click();
        return new SecondSearchResultsPage();
    }

}
