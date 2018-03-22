package webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    @FindBy(className = "menu_lang")
    private WebElement lang;

    @FindBy(xpath = "//b[@class='menu_main']//a[contains(@href, 'favor')]")
    private WebElement favorites;

    @FindBy(xpath = "//b[@class='menu_main']//a[contains(@href, 'search')]")
    private WebElement search;

    public void changeLanguage () {
        lang.click();
    }

    public FavoritesPage openFavorites (WebDriver driver) {
            ((JavascriptExecutor)driver).executeScript("window.scroll(0,0)");
            favorites.click();
        FavoritesPage favoritesPagePage = new FavoritesPage();
        favoritesPagePage.init(driver);
        return favoritesPagePage;
    }

    public SearchPage openSearch (WebDriver driver) {
        search.click();
        SearchPage searchPage = new SearchPage();
        searchPage.init(driver);
        return searchPage;
    }

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
