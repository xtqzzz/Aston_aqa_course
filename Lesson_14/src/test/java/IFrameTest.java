import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class IFrameTest {
    private static WebDriver driver;
    private static WebDriver iFrame;
    private static WebDriverWait wait;
    private static Set<Cookie> cookies;
    private static final String XPATH_IFRAME = "//iframe[@class='bepaid-iframe']";

    private String labelWithText(String text) {
        return "//label[text()=".concat("'").concat(text).concat("'").concat("]");
    }

    private String buttonWithText(String text) {
        return "//button[text()=".concat("'").concat(text).concat("'").concat("]");
    }

    private WebElement elementWithXpath(WebDriver driver, String text) {
        return driver.findElement(By.xpath(text));
    }

    private WebElement waitUntilBecomeVisible(WebDriver driver, String selector) {
        return new WebDriverWait(driver, Duration.ofMillis(10000))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }

    private List<WebElement> waitUntilBecomeVisibleAll(WebDriver driver, String selector) {
        return new WebDriverWait(driver, Duration.ofMillis(10000))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(selector)));
    }


    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        WebElement phone = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        WebElement amount = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='connection-email']"));
        WebElement nextButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        phone.click();
        phone.sendKeys("297777777");
        amount.click();
        amount.sendKeys("99");
        email.click();
        email.sendKeys("test@test.by");
        nextButton.click();

        cookies = driver.manage().getCookies();
        cookies.stream().forEach(c -> driver.manage().addCookie(c));
        iFrame = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(XPATH_IFRAME)));
    }

    @AfterAll
    static void teardown() {
        cookies.stream().forEach(c -> driver.manage().deleteCookie(c));
        driver.quit();
    }

    @Test
    void propsSownTest() {
        List<WebElement> elements = waitUntilBecomeVisibleAll(iFrame, "//div[@class='header__payment']/p");
        assertAll(() -> assertEquals("99.00 BYN", elements.get(0).getText()),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", elements.get(1).getText()));
    }

    @Test
    void iFramePayButtonTest() {
        WebElement iPayButton = waitUntilBecomeVisible(
                iFrame, "//app-card-page" + buttonWithText(" Оплатить  99.00 BYN "));
        assertEquals("Оплатить 99.00 BYN", iPayButton.getText());
    }

    @Test
    void iFrameInputFieldsTextTest() {
        WebElement isInputCardNumShown = waitUntilBecomeVisible(iFrame, labelWithText("Номер карты"));
        WebElement isInputThermOfUsageShown = waitUntilBecomeVisible(iFrame, labelWithText("Срок действия"));
        WebElement isInputCVCShown = elementWithXpath(iFrame, labelWithText("CVC"));
        WebElement isInputCardHolderNameShown =
                waitUntilBecomeVisible(iFrame,  labelWithText("Имя держателя (как на карте)"));
        assertAll(() -> assertEquals("Номер карты", isInputCardNumShown.getText()),
                () -> assertEquals("Срок действия", isInputThermOfUsageShown.getText()),
                () -> assertEquals("CVC", isInputCVCShown.getText()),
                () -> assertEquals("Имя держателя (как на карте)", isInputCardHolderNameShown.getText()));

    }

    @Test
    void paySysIconsTest() {
        List<WebElement> icons = waitUntilBecomeVisibleAll(iFrame, "//app-input//img");
        assertAll(() -> assertTrue(icons.get(0).isDisplayed()),
                () -> assertTrue(icons.get(1).isDisplayed()),
                () -> assertTrue(icons.get(2).isDisplayed()),
                () -> assertTrue(icons.get(3).isDisplayed()),
                () -> assertTrue(icons.get(4).isDisplayed()));
    }
}