package com.cucumber.junit.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class HomePage extends BasePage{

    private static final String PAGE_TITLE = "/html/head/title[contains(text(), '%s')]";
    public static final String DASHBOARD_ICON = "//*[contains(@class, \"sidebarButton\")]/*[@href=\"#default_personal/dashboard\"]";

    public boolean isPageWIthTitleIsDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(PAGE_TITLE, title)));
    }

    public void click(String button) {
        findElement(By.xpath(button)).click();
    }
}
