package com.cucumber.junit.pages;

import com.cucumber.junit.driver.DriverManager;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private static final String LOGIN_URL = "https://demo.reportportal.io/ui/#login";
    public static final String LOGIN_FIELD = "//*[@name='login']";
    public static final String PASSWORD_FIELD = "//*[@name='password']";
    public static final String LOGIN_BUTTON = "//*[@type='submit']";

    public void openWebsite() {
        DriverManager.getDriver().get(LOGIN_URL);
    }

    public void fillField(String field, String value) {
        findElement(By.xpath(field)).sendKeys(value);
    }

    public void click(String button) {
        if (button.equals("Login")) {
            button = LOGIN_BUTTON;
        }
        findElement(By.xpath(button)).click();
    }
}
