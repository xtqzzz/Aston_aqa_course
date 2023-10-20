package org.example;

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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinePayTest {
    private static WebDriver driver;
    private static Set<Cookie> cookies;
    private WebElement selectArrow;
    private List<WebElement> payFormSelect;

    private WebElement elementWithXpath(WebDriver driver, String text) {
        return driver.findElement(By.xpath(text));
    }

    private String inputWithId(String text) {
        return "//input[@id=".concat("'").concat(text).concat("'").concat("]");
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
        cookies = driver.manage().getCookies();
        cookies.stream().forEach(c -> driver.manage().addCookie(c));
    }
    @BeforeEach
    void setWait() {
        selectArrow = waitUntilBecomeVisible(driver, "//span[@class='select__arrow']");
        selectArrow.click();
        payFormSelect = waitUntilBecomeVisibleAll(driver, "//ul[@class='select__list']/li");
    }

    @AfterAll
    static void teardown() {
        cookies.stream().forEach(c -> driver.manage().deleteCookie(c));
        driver.quit();
    }

    @Test
    void connectionServicesNotesTest() {
        payFormSelect.get(0).click();
        WebElement phone = elementWithXpath(driver, inputWithId("connection-phone"));
        WebElement sum = elementWithXpath(driver, inputWithId("connection-sum"));
        WebElement email = elementWithXpath(driver, inputWithId("connection-email"));
        assertAll(() -> assertEquals("Номер телефона", phone.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));
    }

    @Test
    void internetServicesNotesTest() {
        payFormSelect.get(1).click();
        WebElement subscriberNum = elementWithXpath(driver, inputWithId("internet-phone"));
        WebElement sum = elementWithXpath(driver, inputWithId("connection-sum"));
        WebElement email = elementWithXpath(driver, inputWithId("internet-email"));
        assertAll(() -> assertEquals("Номер абонента", subscriberNum.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));
    }

    @Test
    void installmentServicesNotesTest() {
        payFormSelect.get(2).click();
        WebElement scoreInstalment = elementWithXpath(driver, inputWithId("score-instalment"));
        WebElement sum = elementWithXpath(driver, inputWithId("instalment-sum"));
        WebElement email = elementWithXpath(driver, inputWithId("instalment-email"));
        assertAll(() -> assertEquals("Номер счета на 44", scoreInstalment.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));
    }
    @Test
    void debtServicesNotesTest() {
        payFormSelect.get(2).click();
        WebElement accountNum = elementWithXpath(driver, inputWithId("score-arrears"));
        WebElement sum = elementWithXpath(driver, inputWithId("arrears-sum"));
        WebElement email = elementWithXpath(driver, inputWithId("arrears-email"));
        assertAll(() -> assertEquals("Номер счета на 2073", accountNum.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sum.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", email.getAttribute("placeholder")));
    }
}