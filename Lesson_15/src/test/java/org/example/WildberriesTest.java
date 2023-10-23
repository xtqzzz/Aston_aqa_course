package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;

public class WildberriesTest {
    private static WildberriesHomePage homePage;
    private static WildberriesProductPage productPage;
    private static WildberriesBasketPage basketPage;
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new WildberriesHomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.wildberries.by/");
    }

    @BeforeEach
    void setWait() {

        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(5000));
    }

    @AfterEach
    void setClean() {
        WildberriesElements.setProductInfo(new HashMap<>());
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    void smokeTest() {
        String firstProd = "Java руководство для начинающих Герберг Шилдт";
        String secondProd = "Изучаем Java";

        homePage.searchProduct(firstProd).clickSearchBtn().selectProduct(0).addToBasket()
                .clickQuantityBtn().backToHome()
                .searchProduct(secondProd).clickSearchBtn().selectProduct(0)
                .addToBasket().clickQuantityBtn().backToHome()
                .goToBasket()
                .getProductInform();
        WildberriesElements.getProductInfo().forEach((k, v) -> System.out.println(k + " | " + v));

        String expectedPrice = String.format("%.2fр.",WildberriesElements.getTotalPriceFromInfo());
        System.out.println(expectedPrice);
        System.out.println("---------");

        String actualPrice = WildberriesBasketPage.getTotalPrice().replaceAll(" ", "");
        System.out.println(actualPrice);
        System.out.println("-|-|-|-|-|");

        int totalCountAtAllAtBasket = Integer.parseInt(WildberriesBasketPage.getBasketItemsCount());
        int firstProductCountAtBasket = Integer.parseInt(WildberriesBasketPage.getProductCounters(0));
        int secondProductCountAtBasket = Integer.parseInt(WildberriesBasketPage.getProductCounters(1));
        System.out.println(WildberriesBasketPage.getBasketItemsCount());
        System.out.println("---------");
        System.out.println(WildberriesBasketPage.getProductCounters(0) +
                " | " + WildberriesBasketPage.getProductCounters(1));

        Assertions.assertAll(() -> Assertions.assertTrue(WildberriesElements.getProductInfo().containsKey(secondProd)),
                () -> Assertions.assertTrue(WildberriesElements.getProductInfo().containsKey(firstProd)),
                () -> Assertions.assertTrue(actualPrice.equals(expectedPrice)),
                () -> Assertions.assertTrue((firstProductCountAtBasket + secondProductCountAtBasket)
                        == totalCountAtAllAtBasket));
    }
}