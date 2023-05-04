package InitFiles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestInit {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quit(){
        quiteDriver();
    }

    public void quiteDriver(){
        driver.quit();
    }

    public void sleep(int second){
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public String getAttribute(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public static WebElement findElementByXpath(String locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(15000));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public static List<WebElement> findElementsByXpath(String locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(15000));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public static void goToRozetka(){
        driver.get("https://rozetka.com.ua");
    }

    public WebElement battonBuy(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(15000));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'buy-button button button--with-icon button--green button--medium buy-button--tile ng-star-inserted')]")));
    }

    public WebElement battonBasket(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(15000));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='header__button ng-star-inserted header__button--active']")));
    }

    public WebElement battonCloseBuyMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(15000));
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.modal__close")));
    }

    public void switchNewTab(){
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
    }

    public void switchOnTab(int index){
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(index));
    }

}
