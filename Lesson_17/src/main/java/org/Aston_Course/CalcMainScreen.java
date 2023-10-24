package org.Aston_Course;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CalcMainScreen extends CalcElements {
    private static AndroidDriver<AndroidElement> driver;
    private String expr;
    private String exprRes;

    public CalcMainScreen(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofMillis(5000)), this);
        this.driver = driver;
    }

    public CalcMainScreen multiply() {
        waitVisible(driver, getMultiply()).click();
        return this;
    }

    public CalcMainScreen divide() {
        waitVisible(driver, getDivide()).click();
        return this;
    }

    public CalcMainScreen plus() {
        waitVisible(driver, getPlus()).click();
        return this;
    }

    public CalcMainScreen sub() {
        waitVisible(driver, getMinus()).click();
        return this;
    }

    public CalcMainScreen equal() {
        waitVisible(driver, getEqual()).click();
        return this;
    }

    public CalcMainScreen zero() {
        waitVisible(driver, getZero()).click();
        return this;
    }

    public CalcMainScreen one() {
        waitVisible(driver, getOne()).click();
        return this;
    }

    public CalcMainScreen two() {
        waitVisible(driver, getTwo()).click();
        return this;
    }

    public CalcMainScreen three() {
        waitVisible(driver, getThree()).click();
        return this;
    }

    public CalcMainScreen four() {
        waitVisible(driver, getFour()).click();
        return this;
    }

    public CalcMainScreen five() {
        waitVisible(driver, getFive()).click();
        return this;
    }

    public CalcMainScreen six() {
        waitVisible(driver, getSix()).click();
        return this;
    }

    public CalcMainScreen seven() {
        waitVisible(driver, getSeven()).click();
        return this;
    }

    public CalcMainScreen eight() {
        waitVisible(driver, getEight()).click();
        return this;
    }

    public CalcMainScreen nine() {
        waitVisible(driver, getNine()).click();
        return this;
    }

    public CalcMainScreen clear() {
        waitVisible(driver, getClear()).click();
        return this;
    }


    public String getExpr() {
        expr = waitVisible(driver, getExpression()).getAttribute("content-desc");;
        return expr;
    }

    public String getExprRes() {
        exprRes = waitVisible(driver, getResult()).getText();
        return exprRes;
    }
    public static void closeCalcApp() {
        driver.quit();
    }
}