import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WildberriesProductPage extends WildberriesElements {
    WebDriver driver;
    @FindBy(xpath = "//*[@class='product-price-current__value']")
    private WebElement productPrice;
    @FindBy(xpath = "//*[@data-tag='productName']")
    private WebElement productName;
    @FindBy(xpath = "//*[@class='basket-button__button btn btn--primary-gradient']")
    private WebElement addToBasketBtn;
    @FindBy(xpath = "//*[@class='quantity__plus']")
    private WebElement quantityPlus;

    public WildberriesProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WildberriesProductPage addToBasket() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[@class='basket-button__button btn btn--primary-gradient']"))).click();
        return this;
    }

    public WildberriesProductPage clickQuantityBtn() {
        visibilityOfElement(driver, quantityPlus).click();
        return this;
    }

    public WildberriesProductPage searchProduct(String productName) {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOf(searchField)).sendKeys(productName);
        return this;
    }


    public WildberriesHomePage backToHome() {
        visibilityOfElement(driver, homePageBtn).click();
        return new WildberriesHomePage(driver);
    }

    public WildberriesBasketPage goToBasket() {
        visibilityOfElement(driver, basketBtn).click();
        return new WildberriesBasketPage(driver);
    }

}