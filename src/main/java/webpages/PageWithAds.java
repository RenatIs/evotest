package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class PageWithAds extends Page {
    private List<Ad> ads = new ArrayList<Ad>();

    public List<Ad> getAds(WebDriver driver) {
        String id;
        String data;
        String price;
        int adsAmount = driver.findElements(By.xpath("//input[@type='checkbox']")).size();

        for (int i = 1; i <= adsAmount; i++) {
            Ad ad = new Ad();

            id = driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).getAttribute("id");
            id = id.substring(1, id.length());
            ad.setId(Integer.parseInt(id));

            data = driver.findElement(By.xpath("//a[contains(@id, '" + ad.getId() + "')]")).getText(); //b
            ad.setData(data);

            price = driver.findElement(By.xpath("//tr[contains(@id,'" + ad.getId() + "')]//a[contains(text(),'€')]")).getText(); //b
            ad.setPrice(price);

            ads.add(ad);
        }
        return ads;
    }
}
