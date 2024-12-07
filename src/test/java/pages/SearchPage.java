package pages;

import data.SearchData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    private final By searchBar = By.cssSelector("#_autocompleteSearchMainHeader");
    private final By searchButton = By.cssSelector("#_doSearch > i");
    private final By searchResults = By.cssSelector("#wrapper > div.container-h.container-bg.-g-breadcrumbs-container > div > ol > li:nth-child(2) > a");
    private final By firstProductFavoriteButton = By.cssSelector("#category-page > div > div:nth-child(3) > div.product-listing.clearfix > div > div.product-box.center.col-md-4.col-xs-6.dataProductId.__GomagListingProductBox.-g-product-box-6063.-g-product-box-ajax-complete > div > div.figcaption.list-f > div.bottom-side-box > div.add-list.clearfix > a.btn.col.wish-btn.addToWishlist.-g-add-to-wishlist-listing-6063");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchForItem(String query) {
        WebElement searchBox = driver.findElement(searchBar);
        searchBox.clear();
        searchBox.sendKeys(query);
        driver.findElement(searchButton).click();
    }

    public boolean isSearchResultDisplayed() {
        return !driver.findElements(searchResults).isEmpty();
    }

    // Method to add the first product from search results to favorites
    public void addFirstProductToFavorites() {
        clickElement(firstProductFavoriteButton);
        System.out.println("Added the first product from search results to favorites.");
    }

    public void performSearchAndValidateResults() {
        for (String query : SearchData.SEARCH_QUERIES) {
            searchForItem(query);
            System.out.println("Searched for: " + query);
            Assertions.assertTrue(
                    isSearchResultDisplayed(),
                    "Search results should be displayed for: " + query
            );
        }
    }
}
