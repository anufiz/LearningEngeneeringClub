package Tests;

import InitFiles.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RozetkaCollectionClass extends TestInit {


    @Test
    public static void rozetkaSearch() {
        goToRozetka();

        List<WebElement> categoriesMain = findElementsByXpath("//a[contains(@class, 'menu-categories__link js-menu-categories__link')]");

        findElementByXpath("//button[contains(@id, 'fat-menu')]").click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> categoriesCatalog = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@class, 'menu-categories__link js-menu-categories__link')]")));

        assert categoriesMain.size() == categoriesCatalog.size() : "Количество категорий не совпадает";
    }
}
