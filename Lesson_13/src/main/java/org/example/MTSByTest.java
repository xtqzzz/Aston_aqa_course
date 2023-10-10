// Импортируем необходимые библиотеки
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MTSByTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test // тест проверки названия блока
    public void testBlockTitle() {
        String blockTitle = driver.findElement(By.xpath("//section[@class='pay']/div/h2")).getText();
        Assertions.assertEquals("Онлайн пополнение без комиссии", blockTitle);
    }

    @Test // тест на иконки
    public void testPaymentSystemsLogos() {
        int logosCount = driver.findElements(By.xpath("//div[@class='pay__partners']/ul")).size();
        Assertions.assertEquals(6, logosCount);
    }

    @Test // проверка ссылки
    public void testMoreInfoLink() {
        WebElement link = driver.findElement(By.xpath("//div[@class='pay__wrapper']/a"));
        link.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String newTabUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", newTabUrl);
    }

    @Test
    public void testContinueButton() {
        WebElement dropdown = driver.findElement(By.xpath("//button[@class='select__header']"));
        dropdown.click();
        WebElement communicationServices = driver.findElement(By.xpath("//p[@class='select__option'][1]"));
        communicationServices.click();
        WebElement phoneField = driver.findElement(By.cssSelector("//input[@id='connection-phone']"));
        phoneField.click();
        phoneField.sendKeys("297777777");
        WebElement continueButton = driver.findElement(By.xpath("//button[@class='button button__default'][1]"));
        continueButton.click();


    }
}