package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Page {
    private WebElement periodField;
    private WebElement regionField;

    @FindBy(xpath = "//input[@class='in1']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@class='in3'][1]")
    private WebElement minPriceField;

    @FindBy(xpath = "//input[@class='in3'][2]")
    private WebElement maxPriceField;

    @FindBy(xpath = "//input[@id='sbtn']")
    private WebElement searchBTN;


    public void setFilters(SearchParameters searchParameters, WebDriver driver) {

        if (searchParameters.getMinPrice() != null) {
            minPriceField.clear();
            minPriceField.sendKeys(searchParameters.getMinPrice());
        }
        if (searchParameters.getMaxPrice() != null) {
            maxPriceField.clear();
            maxPriceField.sendKeys(searchParameters.getMaxPrice());
        }
        if (searchParameters.getSearchRegion() != null) {
            regionField = driver.findElement(By.xpath("//select[@name='search_region']/option[@value='"
                    + searchParameters.getSearchRegion().toString().toLowerCase() +"']"));
            regionField.click();
        }
        if (searchParameters.getSearchPeriod() != null) {
            periodField = driver.findElement(By.xpath("//select[@name='pr']/option[contains(text(), '"
                    + searchParameters.getSearchPeriod().getPeriod() + "')]"));
            periodField.click();
        }
        if (searchParameters.getKeyphrase() != null) {
            searchField.clear();
            searchField.sendKeys(searchParameters.getKeyphrase());
        }
    }

    public SearchResultsPage search(WebDriver driver) {
        searchBTN.click();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.init(driver);
        return searchResultsPage;
    }
}
