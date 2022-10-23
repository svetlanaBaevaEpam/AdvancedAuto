package com.cucumber.junit.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class HomePage extends BasePage{

    private static final String PAGE_TITLE = "/html/head/title[contains(text(), '%s')]";

    public boolean isPageWIthTitleIsDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(PAGE_TITLE, title)));
    }
}
