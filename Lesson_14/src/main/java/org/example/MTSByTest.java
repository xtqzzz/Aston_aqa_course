package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    @Test
    public void testPhoneNumberField() throws InterruptedException {
        driver.get("https://www.mts.by/");

        // Ввод номер телефона
        String phoneNumber = "297777777";
        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);

        // Нажатие кнопки продолжить
        driver.findElement(By.xpath("//button[@class='button button__default ']")).click();

        Thread.sleep(2000);

        // Проверка корректностей полей
        WebElement menu = driver.findElement(By.xpath("//button[@class='select__header']"));
        menu.click();



// проверка суммы
        String expectedAmount = "16.67 BYN";
        Assert.assertEquals(expectedAmount, driver.findElement(By.cssSelector(".payment-info .amount")).getText());

// Ввод карты
        WebElement cardNumberField = driver.findElement(By.cssSelector("#card_number"));
        cardNumberField.clear();
        cardNumberField.sendKeys("4992739010010247");
        cardNumberField = driver.findElement(By.cssSelector("#cvv2"));
        cardNumberField.clear();
        cardNumberField.sendKeys("123");
        WebElement expirationDateField = driver.findElement(By.cssSelector("#expiration_date"));
        expirationDateField.clear();
        expirationDateField.sendKeys("01/24");

        driver.findElement(By.className("payment-btn")).click();

        actualResultNumber = driver.findElement(By.cssSelector("div.payment-result .phone-number")).getText();
        Assert.assertEquals(phoneNumber, actualResultNumber);
    }
}