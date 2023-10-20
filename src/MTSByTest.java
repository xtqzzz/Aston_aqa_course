package test;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность
    // Логика такая: если у поля виден placeholder - то поле пустое, я делал проверку по плейсхолдеру

    @Test // проверка поля услуги связи --> номер телефона
    public void testEmptyFields() {
        WebElement block = driver.findElement(By.xpath("//div[@class='pay__wrapper']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", block);
        wait.until(ExpectedConditions.visibilityOf(block));
        WebElement dropdown = driver.findElement(By.xpath("//button[@class=\"select__header\"]"));
        dropdown.click();
    }
    @Test //проверка поля услуги связи --> сумма
    public void communicatioServices() {
        WebElement numberPhone = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        String expectedPlaceholderNumberPhone = "Номер телефона";
        String actualPlaceholder = numberPhone.getAttribute("Placeholder");
        Assertions.assertEquals(expectedPlaceholderNumberPhone, actualPlaceholder);
        // проверка поля услуги связи --> сумма
        WebElement summa = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        String expectedPlaceholderSumma = "Сумма";
        String actualPlaceholderSumma = summa.getAttribute("Placeholder");
        Assertions.assertEquals(expectedPlaceholderSumma, actualPlaceholderSumma);
    }
    @Test //проверка поля услуги связи --> email
    public void mail() {
        WebElement email = driver.findElement(By.xpath("//input[@id='connection-email']"));
        String expectedPlaceholderEmail = "E-mail для отправки чека";
        String actualPlaceholderEmail = email.getAttribute("Placeholder");
        Assertions.assertEquals(expectedPlaceholderEmail, actualPlaceholderEmail);
    }
    @Test
    public void checkToHomeInternet() {
        //не понимаю почему не кликает на выпадающий список
        //я хотел переключиться на остальные поля, и сделать проверку по аналогии как и в "услуги связи"
        driver.switchTo().frame((WebElement) By.tagName("button"));
        WebElement homeInternet = driver.findElement(By.xpath("//p[contains(text(),'Домашний интернет')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homeInternet.click();
    }
    @Test
    public void testOnlineRefill() {
// Создаем локаторы элементов
        By onlineRefillBlock = By.className("online-refill");
        By phoneField = By.xpath("//input[@id='connection-phone']");
        By amountField = By.xpath("//input[@id='connection-sum']");
        By emailField = By.xpath("//input[@id='connection-email']");
        By continueButton = By.tagName("button");
        By modalWindow = By.xpath("//div[@class='app-wrapper__content']");
        By modalPhone = By.xpath("//div[@id='bxdynamic_cookies-agreement-pt1_start']");
        By modalAmount = By.xpath("//div[@id='bxdynamic_cookies-agreement-pt1_start']");
        By modalButton = By.xpath("//button[@class='colored ng-star-inserted']");
        By cardNumberField = By.xpath("//input[@formcontrolname='creditCard']");
        By cardDateField = By.xpath("//input[@formcontrolname='expirationDate']");
        By cardCvcField = By.xpath("//input[@formcontrolname='cvc']");
        By cardHolderField = By.xpath("//input[@formcontrolname='holder']");
        By paymentIcons = By.className("payment-icons");

// Переходим к блоку онлайн пополнения без комиссии
        WebElement refillBlock = driver.findElement(onlineRefillBlock);
        refillBlock.click();

// Вводим данные в поля телефон, сумма и email
        driver.findElement(phoneField).sendKeys("297777777");
        driver.findElement(amountField).sendKeys("20");
        driver.findElement(emailField).sendKeys("test@yandex.ru");

// Нажимаем кнопку продолжить
        driver.findElement(continueButton).click();

// Проверяем, что появилось модальное окно с корректными данными
        WebElement modal = driver.findElement(modalWindow);
        Assert.assertTrue(modal.isDisplayed());

        String modalPhoneText = driver.findElement(modalPhone).getText();
        Assert.assertEquals("Оплата: Услуги связи Номер:375297777777", modalPhoneText);

        String modalAmountText = driver.findElement(modalAmount).getText();
        Assert.assertEquals("20.00 BYN", modalAmountText);

        String modalButtonText = driver.findElement(modalButton).getText();
        Assert.assertEquals("Оплатить 20.00 BYN", modalButtonText);

// Проверяем, что в незаполненных полях для ввода реквизитов карты есть надписи "Обязательное поле"
        String cardNumberPlaceholder = driver.findElement(cardNumberField).getAttribute("placeholder");
        Assert.assertEquals("Обязательное поле", cardNumberPlaceholder);

        String cardDatePlaceholder = driver.findElement(cardDateField).getAttribute("placeholder");
        Assert.assertEquals("Обязательное поле", cardDatePlaceholder);

        String cardCvcPlaceholder = driver.findElement(cardCvcField).getAttribute("placeholder");
        Assert.assertEquals("Обязательное поле", cardCvcPlaceholder);

        String cardHolderPlaceholder = driver.findElement(cardHolderField).getAttribute("placeholder");
        Assert.assertEquals("Обязательное поле", cardHolderPlaceholder);

// Проверяем, что есть иконки платежных систем Visa, Mastercard и Belkart
        WebElement icons = driver.findElement(paymentIcons);
        Assert.assertTrue(icons.isDisplayed());

        WebElement visaIcon = icons.findElement(By.xpath("//img[@alt='Visa']"));
        Assert.assertTrue(visaIcon.isDisplayed());

        WebElement mastercardIcon = icons.findElement(By.xpath("//img[@alt='Mastercard']"));
        Assert.assertTrue(mastercardIcon.isDisplayed());

        WebElement belkartIcon = icons.findElement(By.xpath("//img[@alt='Belkart']"));
        Assert.assertTrue(belkartIcon.isDisplayed());
    }
}