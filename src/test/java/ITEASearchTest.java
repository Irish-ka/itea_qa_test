import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * A test for verifying search results in Google.
 */
public class ITEASearchTest {

    final static String searchTerm = "ITEA";

    @Test
    public void ITEASearchTest() {
        HomePage homePage = new HomePage();
        SearchResultsPage searchResultsPage = homePage.fillSearchForm("ITEA");
        Assert.assertNotNull(homePage.isSearchResultsFieldDisplayed(), "Search results list is not returned");;
    }

    @Test
    public void ITEASearchResultsCountTest() {
        HomePage homePage = new HomePage();
        SearchResultsPage searchResultsPage = homePage.fillSearchForm("ITEA");
        Assert.assertEquals(searchResultsPage.searchResultsFieldsSize(), 8, "There are not 8 search results displayed on search results page");;
    }

}
