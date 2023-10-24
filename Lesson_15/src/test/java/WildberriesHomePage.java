import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class WildberriesHomePage extends WildberriesElements {
    private final WebDriver driver;
    private Actions actions;
    @FindBy(xpath = "//*[@class='card b-card']")
    private List<WebElement> products;
    @FindBy(xpath = "//*[@class='btn btn--primary b-card__btn btn-basket']")
    private List<WebElement> addToBasketButton;
    @FindBy(xpath = "//*[@class='quantity__plus']")
    private List<WebElement> quantityPlus;

    public WildberriesHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WildberriesProductPage selectProduct(int itemNum) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1000)");
        visibilityOfElement(driver, products.get(itemNum)).click();
        return new WildberriesProductPage(driver);
    }

    public WildberriesHomePage searchProduct(String productName) {
        visibilityOfElement(driver, searchField).sendKeys(productName);
        return this;
    }

    public WildberriesHomePage clickSearchBtn() {
        visibilityOfElement(driver, searchField).sendKeys(Keys.ENTER);
        return this;
    }


    public WildberriesBasketPage goToBasket() {
        elementToBeClickable(driver, basketBtn).click();
        return new WildberriesBasketPage(driver);
    }
}