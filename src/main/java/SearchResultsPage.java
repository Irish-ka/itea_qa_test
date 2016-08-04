import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by ira on 04.08.16.
 */
public class SearchResultsPage extends AbstractPage {
    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy (css = ".f.kv._SWb")
    private List<WebElement> searchResultsField;

    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
        implicitWaitForElement(searchField);
    }

    public int searchResultsFieldsSize() {
        implicitWaitForListOfElement(searchResultsField);
        return searchResultsField.size();
    }


}
