import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MTSTest {

    private WebDriver driver;
    private WebDriverWait wait;
    driver().manager().window()

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
        String blockTitle = driver.findElement(By.xpath(".pay__wrapper h2")).getText();
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", blockTitle);
        System.out.println(blockTitle);
    }

    @Test // тест на иконки
    public void testPaymentSystemsLogos() {
        List<String> listOfPayments = new ArrayList<>();
        List<WebElement> listOfElements = driver.findElements(By.xpath("div .pay__partners ul li"));
        for (int i=0; i<listOfElements.size(); i++){
            listOfPayments.add(listOfElements.get(i).getAttribute("alt"));
        }
        assertThat(listOfPayments).withFailMessage("Платежные партнеры не совпадают")
                .containsAll(List.of("Visa","Verified By Visa","MasterCard","MasterCard Secure Code",
                        "Белкарт", "МИР"));
    }

    @Test // проверка ссылки
    public void testMoreInfoLink() throws InterruptedException {
        WebElement link = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        link.click();
        String newTabUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", newTabUrl);
    }

    @Test //
    public void testContinueButton() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//button[@class='select__header']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
        dropdown.click();
        WebElement communicationServices = driver.findElement(By.xpath("//p[@class='select__option'][1]"));
        communicationServices.click();
        WebElement phoneField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneField.click();
        phoneField.sendKeys("297777777");
        WebElement continueButton = driver.findElement(By.xpath("#pay-connection button"]"));
        continueButton.click();


    }

}