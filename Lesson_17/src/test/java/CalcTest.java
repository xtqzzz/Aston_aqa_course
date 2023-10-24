import org.Aston_Course.CalcMainScreen;
import org.Aston_Course.MobileFactory;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

@Epic("Calculator Test Epic")
@Feature("Calculating Some Valid Values")

public class CalcTest {
    private static AndroidDriver driver;
    private static CalcMainScreen calc;
    private String expectedExpr;
    private String expectedExprRes;
    private String actualExpr;
    private String actualExprRes;

    @BeforeAll
    public static void setup() {
        driver = MobileFactory.getAndroidDriver();
        calc = new CalcMainScreen(driver);
        calc.clear().clear();
    }

    @AfterEach
    public void tearDown() {
        actualExpr = "";
        actualExprRes = "";
        expectedExpr = "";
        expectedExprRes = "";
        calc.clear().clear();
        System.out.println("----------");
    }

    @AfterAll
    public static void teardown() {
        calc.closeCalcApp();
    }

    @Story("Calculate the division of some values")
    @Test
    public void divideTest() {
        calc.nine().zero().divide().three().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "90÷3";
        expectedExprRes = "= 30";
        System.out.println(calc.getExpr() + "\n" + calc.getExprRes());
        Assertions.assertAll(() -> Assertions.assertTrue(expectedExpr.equals(actualExpr)),
                () -> Assertions.assertTrue(expectedExprRes.equals(actualExprRes)));
    }

    @Story("Calculate the multiplication of some values")
    @Test
    public void multiplyTest() {
        calc.clear().clear().one().eight().multiply().nine().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "18×9";
        expectedExprRes = "= 162";
        System.out.println(calc.getExpr() + "\n" + calc.getExprRes());
        Assertions.assertAll(() -> Assertions.assertTrue(expectedExpr.equals(actualExpr)),
                () -> Assertions.assertTrue(actualExprRes.equals(expectedExprRes)));
    }

    @Story("Calculating the summing of some values")
    @Test
    public void sumTest() {
        calc.clear().clear().one().eight().nine().plus().two().seven().nine().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "189+279";
        expectedExprRes = "= 468";
        System.out.println(calc.getExpr() + "\n" + calc.getExprRes());
        Assertions.assertAll(() -> Assertions.assertTrue(expectedExpr.equals(actualExpr)),
                () -> Assertions.assertTrue(actualExprRes.equals(expectedExprRes)));
    }

    @Story("Calculating the difference between two values")
    @Test
    public void subTest() {
        calc.clear().clear().three().nine().six().sub().six().three().nine().equal();
        actualExpr = calc.getExpr();
        actualExprRes = calc.getExprRes();
        expectedExpr = "396-639";
        expectedExprRes = "= -243";
        System.out.println(calc.getExpr() + "\n" + calc.getExprRes());
        Assertions.assertAll(() -> Assertions.assertTrue(expectedExpr.equals(actualExpr)),
                () -> Assertions.assertTrue(actualExprRes.equals(expectedExprRes)));
    }
}