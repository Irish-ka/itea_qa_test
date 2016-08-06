package Tests;

import Pages.HomePage;
import Pages.SearchResultsPage;
import Pages.SecondSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Simple tests for verifying search results in Google with search term "ITEA".
 */
public class ITEASearchTest {

    final static String searchTerm = "ITEA";
    final static String searchTerm1 = "itea";
    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = homePage.fillSearchForm("ITEA");
    SecondSearchResultsPage secondSearchResultsPage = searchResultsPage.changeResultsPage();

    @Test
    public void ITEASearchTest() {
        Assert.assertNotNull(homePage.isSearchResultsFieldDisplayed(), "Search results list is not returned");
    }

    @Test
    public void ITEASearchResultsCountTest() {
        Assert.assertEquals(searchResultsPage.searchResultsFieldsSize(),8, "There are not 8 search results displayed on search results page");
    }

    @Test
    public void SearchTermTest() {
        Assert.assertTrue(searchResultsPage.isSearchTermContained(searchTerm, searchTerm1), "Every result item doesn't contains search term");
    }

    @Test
    public void ITEASecondSearchResultsCountTest() {
        Assert.assertEquals(secondSearchResultsPage.searchResultsFieldsSize(),10, "There are not 10 search results displayed on search results page");
    }

    @Test
    public void SecondSearchTermTest() {
        Assert.assertTrue(secondSearchResultsPage.isSearchTermContained(searchTerm, searchTerm1), "Every result item doesn't contains search term");
    }
}
