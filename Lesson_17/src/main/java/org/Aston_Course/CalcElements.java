package org.Aston_Course;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CalcElements {
    @FindBy (id = "Calculator")
    private AndroidElement calculator;
    @FindBy(id = "com.miui.calculator:id/btn_plus_s")
    private AndroidElement plus;
    @FindBy(id = "com.miui.calculator:id/btn_minus_s")
    private AndroidElement minus;
    @FindBy(id = "com.miui.calculator:id/btn_mul_s")
    private AndroidElement multiply;
    @FindBy(id = "com.miui.calculator:id/btn_div_s")
    private AndroidElement divide;
    @FindBy(id = "com.miui.calculator:id/btn_1_s")
    private AndroidElement one;
    @FindBy(id = "com.miui.calculator:id/btn_2_s")
    private AndroidElement two;
    @FindBy(id = "com.miui.calculator:id/btn_3_s")
    private AndroidElement three;
    @FindBy(id = "com.miui.calculator:id/btn_4_s")
    private AndroidElement four;
    @FindBy(id = "com.miui.calculator:id/btn_5_s")
    private AndroidElement five;
    @FindBy(id = "com.miui.calculator:id/btn_6_s")
    private AndroidElement six;
    @FindBy(id = "com.miui.calculator:id/btn_7_s")
    private AndroidElement seven;
    @FindBy(id = "com.miui.calculator:id/btn_8_s")
    private AndroidElement eight;
    @FindBy(id = "com.miui.calculator:id/btn_9_s")
    private AndroidElement nine;
    @FindBy(id = "com.miui.calculator:id/btn_0_s")
    private AndroidElement zero;
    @FindBy(id = "com.miui.calculator:id/btn_equal_s")
    private AndroidElement equal;
    @FindBy(id = "com.miui.calculator:id/expression")
    private AndroidElement expression;
    @FindBy(id = "com.miui.calculator:id/result")
    private AndroidElement result;
    @FindBy(id = "com.miui.calculator:id/btn_c_s")
    private AndroidElement clear;

    public AndroidElement getCalculator() {
        return calculator;
    }
    public AndroidElement getEqual() {
        return equal;
    }

    public AndroidElement getPlus() {
        return plus;
    }

    public AndroidElement getMinus() {
        return minus;
    }

    public AndroidElement getMultiply() {
        return multiply;
    }

    public AndroidElement getDivide() {
        return divide;
    }

    public AndroidElement getOne() {
        return one;
    }

    public AndroidElement getTwo() {
        return two;
    }

    public AndroidElement getThree() {
        return three;
    }

    public AndroidElement getFour() {
        return four;
    }

    public AndroidElement getFive() {
        return five;
    }

    public AndroidElement getSix() {
        return six;
    }

    public AndroidElement getSeven() {
        return seven;
    }

    public AndroidElement getEight() {
        return eight;
    }

    public AndroidElement getNine() {
        return nine;
    }

    public AndroidElement getZero() {
        return zero;
    }

    public AndroidElement getResult() {
        return result;
    }

    public AndroidElement getExpression() {
        return expression;
    }

    public AndroidElement getClear() {
        return clear;
    }

    public WebElement waitVisible(AndroidDriver<AndroidElement> driver, AndroidElement element) {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
    }
}