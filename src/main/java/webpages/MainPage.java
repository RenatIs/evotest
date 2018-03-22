package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page{

    public CategoryPage openCategory(WebDriver driver, String categoryName) {
        driver.findElement(By.xpath("//a[@title='Объявления " + categoryName + "']")).click();
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.init(driver);
        return categoryPage;
    }
}