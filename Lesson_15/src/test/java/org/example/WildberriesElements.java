package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Map;

public abstract class WildberriesElements {
    @FindBy(xpath = "//*[@class='svg-icon icon-cart-thin']")
    public WebElement basketBtn;
    @FindBy(xpath = "//*[@class='svg-icon icon-wb-header-logo-holiday']")
    public WebElement homePageBtn;
    @FindBy(xpath = "//*[@class='search-component-input']")
    public WebElement searchField;
    @FindBy(xpath =
            "//*[@class='search-component-button search-component-icon-search search-component-icon-search--enabled']")
    public WebElement searchBth;
    private static Map<String, String> productInfo;

    public static Map<String, String> getProductInfo() {
        return productInfo;
    }

    public static double getTotalPriceFromInfo() {
        return productInfo.values().stream().map(v -> v.replace("р.", ""))
                .map(v -> v.replace(",", "."))
                .map(v -> v.replace(" ", ""))
                .mapToDouble(v -> Double.parseDouble(String.valueOf(v))).sum();
    }

    public static void setProductInfo(Map<String, String> productInfo) {
        WildberriesElements.productInfo = productInfo;
    }
    public static WebElement visibilityOfElement(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement elementToBeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}