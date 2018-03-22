import enums.SearchPeriod;
import enums.SearchRegion;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webpages.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SomeTests {
    private WebDriver driver;
    private SearchParameters searchParameters;
    private final int RANDOM_AMOUNT = 3;

    @Test
    @Parameters({"categoryName", "keyPhrase", "minPrice", "maxPrice"})
    public void e2eTest(String categoryName, String keyPhrase, String minPrice, String maxPrice) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.ss.com/");
        MainPage mainPage = new MainPage();
        mainPage.init(driver);
        mainPage.changeLanguage();
        SearchPage searchPage = mainPage
                .openCategory(driver, categoryName)
                .openSearch(driver);

        searchParameters = SearchParameters.create()
                .withKeyPhrase(keyPhrase)
                .withSearchPeriod(SearchPeriod.FOR_MONTH);

        searchPage.setFilters(searchParameters, driver);
        SearchResultsPage searchResultsPage = searchPage.search(driver);
        Thread.sleep(1000);
        searchResultsPage.addFilter(driver, "sell");
        searchResultsPage.sortBy(driver, "Цена");
        searchPage = searchResultsPage.openExtendedSearch(driver);

        searchParameters
                .withMinPrice(minPrice)
                .withMaxPrice(maxPrice);

        searchPage.setFilters(searchParameters, driver);

        searchResultsPage = searchPage.search(driver);
        Thread.sleep(1000);

        List<Ad> expectedAds = randomAds(searchResultsPage.getAds(driver), RANDOM_AMOUNT);
        Collections.sort(expectedAds);

        searchResultsPage.addAdsToFavor(driver, expectedAds);
        Thread.sleep(1000);

        FavoritesPage favoritesPage = searchResultsPage.openFavorites(driver);

        List<Ad> actualAds = favoritesPage.getAds(driver);
        Collections.sort(actualAds);

        Assert.assertEquals(expectedAds, actualAds);
    }

    @BeforeTest
    public void doBeforeTest() {
        /*System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver();*/
        driver = new ChromeDriver();
    }

    @AfterTest
    public void doAfterTest() {
        driver.close();
    }

    public List<Ad> randomAds (List<Ad> allAds, int randomAmdunt) {
        List<Ad> randomAds = new ArrayList<Ad>();
        for (int i = 1; i <= RANDOM_AMOUNT; i++) {
            int randomNumber = (int) (allAds.size() - i) / i;
            randomAds.add(allAds.get(randomNumber));
        }
        return randomAds;
    }

/*1. Открыть браузер и развернуть на весь экран.
2. Зайти на ss.com
3. Поменять язык на русский.
4. Зайти в раздел Электротехника, в поиске ввести искомую фразу (напр. ‘Компьютер’) и выбрать разные параметры поиска.
5. Нажать кнопку Искать
6. Отсортировать результаты по цене и выбрать тип сделки ‘продажа’.
7. Зайти в расширенный поиск.
8. Задать параметр поиска по цене от 0 до 300.
9. Выбрать не менее 3 любых случайных объявлений.
10. Нажать “Добавить выбранные в закладки”.
11. Открыть "Закладки" и проверить, что объявления на странице совпадают с выбранными ранее
12. Закрыть браузер.*/
}
