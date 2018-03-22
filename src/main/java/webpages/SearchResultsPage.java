package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends PageWithAds {
    @FindBy(xpath = "//form[@name='ffrm']/..//a[contains(@href, 'search')]")
    private WebElement extendedSearch;

    @FindBy(xpath = "//a[contains(@id, 'fav')]")
    private WebElement addToFavorButton;

    public void addAdsToFavor(WebDriver driver, List<Ad> ads) {
        for (Ad ad : ads) {
            driver.findElement(By.xpath("//input[contains(@id,'" + ad.getId() + "')]")).click();
        }
        addToFavorButton.click();
        driver.findElement(By.xpath("//a[contains(@id,'alert')]")).click();
    }

    public void sortBy(WebDriver driver, String sorter) {
        driver.findElement(By.xpath("//tr[@id='head_line']//a[contains(text(),'" + sorter + "')]")).click();
    }

    public void addFilter(WebDriver driver, String filter) {
        driver.findElement(By.xpath("//option[contains(@value, '" + filter + "')]")).click();
    }

    public SearchPage openExtendedSearch(WebDriver driver) {
        extendedSearch.click();
        SearchPage searchPage = new SearchPage();
        searchPage.init(driver);
        return searchPage;
    }
}
