package com.cucumber.junit.pages;

public class DashboardPage extends BasePage{

    public static final String ADD_DASHBOARD = "//*[contains(@class, 'pageLayout__page-header')]//button";
    public static final String ALL_DASHBOARDS_LINK = "//*[contains(@class, 'pageLayout__page-header')]//*[@href and text()=\"All Dashboards\"]";
    public static final String DASHBOARD_NAME_FIELD = "//input[@placeholder = \"Enter dashboard name\"]";
    public static final String DASHBOARD_DESCRIPTION_FIELD = "//textarea[@placeholder = \"Enter dashboard description\"]";
    public static final String DASHBOARD_SHARE_FLAG = "//label[contains(@class, \"inputBigSwitcher\")]";
    public static final String ADD_BUTTON = "//button[text()=\"Add\"]";
}
