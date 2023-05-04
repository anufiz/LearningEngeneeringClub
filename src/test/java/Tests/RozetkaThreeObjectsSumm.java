package Tests;

import InitFiles.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaThreeObjectsSumm extends TestInit {

    @Test
    public void testThreeObjectsSumm() {
        // Вход на сайт.
        goToRozetka();

        // 1 товар.
        WebElement firstProduct = findElementByXpath("//ul[contains(@class, 'main-goods__grid')]//a[contains(@title, '0.7')]");
        firstProduct.click();
        WebElement firstProductPrice = findElementByXpath("//p[@class='product-price__big product-price__big-color-red']");
        String getTextFirstProduct = firstProductPrice.getText().replaceAll("[^0-9.,]+", "");
        battonBuy().click();
        battonCloseBuyMenu().click();

        // 2 товар.
        WebElement secondProduct = findElementByXpath("//a[contains(@class, 'lite-tile__title ng-star-inserted') and contains(@title, 'Лікер Jägermeister 0.5 л 35% (4067700015549)')]");
        secondProduct.click();
        WebElement secondProductPrice = findElementByXpath("//p[@class='product-price__big product-price__big-color-red']");
        String getTextSecondProduct = secondProductPrice.getText().replaceAll("[^0-9.,]+", "");
        battonBuy().click();
        battonCloseBuyMenu().click();

        // 3 товар.
        WebElement thirdProduct = findElementByXpath("//a[contains(@class, 'lite-tile__title ng-star-inserted') and contains(@title, 'Лікер Jägermeister 1 л 35%')]");
        thirdProduct.click();
        WebElement thirdProductPrice = findElementByXpath("//p[@class='product-price__big product-price__big-color-red']");
        String getTextThirdProduct = thirdProductPrice.getText().replaceAll("[^0-9.,]+", "");
        battonBuy().click();
        battonCloseBuyMenu().click();

        battonBasket().click();

        // Проверяем, что сумма правильно посчитана.
        String expectedSum = String.valueOf(Integer.parseInt(getTextFirstProduct) + Integer.parseInt(getTextSecondProduct) + Integer.parseInt(getTextThirdProduct));
        String actualSum = driver.findElement(By.xpath("//div[@class='cart-receipt__sum-price']/span")).getText().replaceAll("[^0-9.,]+", "");
        Assert.assertEquals(actualSum, expectedSum);
    }

}
