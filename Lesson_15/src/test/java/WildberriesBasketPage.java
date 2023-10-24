import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WildberriesBasketPage extends WildberriesElements {
    private static WebDriver driver;
    @FindBy (xpath = "//*[@class='quantity__plus']")
    private List<WebElement> plusBtn;
    @FindBy (xpath = "//input[@type='number']")
    private WebElement inputQuantityField;
    @FindBy (xpath = "//*[@class='basket__items-counter']")
    private static WebElement basketItemsCount;
    @FindBy (xpath = "//*[@alt='Wildberries']")
    private WebElement homePageBtn;
    @FindBy (xpath = "//*[@data-tag='totalSum']")
    private static WebElement totalPrice;
    @FindBy (xpath = "//*[@class='quantity__input']")
    private static List<WebElement> productCounters;
    @FindBy (xpath = "//*[@class='b-item-price__lower']")
    private static List<WebElement> productPrises;
    @FindBy (xpath = "//*[@data-tag='itemName']")
    private static List<WebElement> productNames;
    private static String totalShopping;
    public WildberriesBasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WildberriesBasketPage setQuantity(int prodId) {
        visibilityOfElement(driver, plusBtn.get(prodId)).click();
        return this;
    }
    public double getTotalPriceExpected() {
        List<Double> res = productPrises.stream()
                .map(e -> e.getText()).map(e -> Double.valueOf(e))
                .collect(Collectors.toList());
        return res.stream().reduce((e1, e2) -> e1 + e2).get();
    }

    public static String getProductCounters(int id) {
        return visibilityOfElement(driver, productCounters.get(id)).getDomProperty("value");
    }

    public static String getBasketItemsCount() {
        return visibilityOfElement(driver, basketItemsCount).getDomProperty("innerText");
    }

    public static String getTotalPrice() {
        WildberriesBasketPage.totalShopping = visibilityOfElement(driver, totalPrice).getDomProperty("innerText");
        return totalShopping;
    }
    public WildberriesBasketPage getProductInform() {

        Map<String, String> prodInfo = IntStream.range(0, productNames.size()).boxed()
                .collect(Collectors.toMap(
                        i -> visibilityOfElement(driver, productNames.get(i)).getDomProperty("textContent"),
                        i -> visibilityOfElement(driver, productPrises.get(i)).getDomProperty("textContent")));
        setProductInfo(prodInfo);
        return this;
    }

    public WildberriesHomePage backToHome() {
        visibilityOfElement(driver, homePageBtn).click();
        return new WildberriesHomePage(driver);
    }
}