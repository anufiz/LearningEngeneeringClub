package Learn;


import InitFiles.TestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Learn extends TestInit {

    @Test
    public void testCars(){
        String expectedResult = "За заданими параметрами не знайдено жодної моделі";

        goToRozetka();
        WebElement searchField = findElementByXpath("//input");
        searchField.sendKeys("asdfasdhfasdhflkasdfkjladsfjk\n");
        //убрати сліпи та замінити їх вейтерами
        sleep(3);
        //змнити пошук по ікс пасу без тексту!
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='За заданими параметрами не знайдено жодної моделі']")).getText(), expectedResult);
        sleep(15);

    }

}
