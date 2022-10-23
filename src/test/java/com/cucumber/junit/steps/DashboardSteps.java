package com.cucumber.junit.steps;

import com.cucumber.junit.pages.DashboardPage;
import com.cucumber.junit.pages.HomePage;
import com.cucumber.junit.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;

import static com.cucumber.junit.pages.DashboardPage.*;
import static com.cucumber.junit.pages.HomePage.DASHBOARD_ICON;
import static com.cucumber.junit.pages.LoginPage.LOGIN_FIELD;
import static com.cucumber.junit.pages.LoginPage.PASSWORD_FIELD;

public class DashboardSteps {
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Given("Open Dashboard page")
    public void openDashboardPage() {
        loginPage.openWebsite();
        loginPage.findElement(By.xpath(LOGIN_FIELD)).clear();
        loginPage.fillField(LOGIN_FIELD, "default");
        loginPage.findElement(By.xpath(PASSWORD_FIELD)).clear();
        loginPage.fillField(PASSWORD_FIELD, "1q2w3e");
        loginPage.click("Login");
        homePage.click(DASHBOARD_ICON);
    }

    @When("^Add Dashboard$")
    public void addDashboard(DataTable dataTable) {
        List<List<String>> list = dataTable.asLists(String.class);
        dashboardPage.click(ADD_DASHBOARD);

        dashboardPage.findElement(By.xpath(DASHBOARD_NAME_FIELD)).clear();
        dashboardPage.fillField(DASHBOARD_NAME_FIELD, list.get(0).get(0));
        dashboardPage.findElement(By.xpath(DASHBOARD_DESCRIPTION_FIELD)).clear();
        dashboardPage.fillField(DASHBOARD_DESCRIPTION_FIELD, list.get(0).get(1));

        if (list.get(0).get(2).equals("true")) {
            dashboardPage.click(DASHBOARD_SHARE_FLAG);
        }

        dashboardPage.click(ADD_BUTTON);
    }

    @Then("Dashboard is added")
    public void dashboardIsAdded() {
        dashboardPage.click(ALL_DASHBOARDS_LINK);
    }

//    @When("Add Dashboard with object")
//    public void addDashboardWithObject(@Transform(DashboardTransformer.class) Dashboard dashboard) {
//        List<List<String>> list = dataTable.asLists(String.class);
//        dashboardPage.click(ADD_DASHBOARD);
//
//        dashboardPage.findElement(By.xpath(DASHBOARD_NAME_FIELD)).clear();
//        dashboardPage.fillField(DASHBOARD_NAME_FIELD, dashboard.name);
//        dashboardPage.findElement(By.xpath(DASHBOARD_DESCRIPTION_FIELD)).clear();
//        dashboardPage.fillField(DASHBOARD_DESCRIPTION_FIELD, dashboard.description);
//
//        if (dashboard.flag.equals("true")) {
//            dashboardPage.click(DASHBOARD_SHARE_FLAG);
//        }
//
//        dashboardPage.click(ADD_BUTTON);
//    }

    @When("^Add Dashboard with (.*), (.*), (.*)$")
    public void addDashboardWithNameDescriptionShareFlag(String name, String description, String flag) {
        dashboardPage.click(ADD_DASHBOARD);

        dashboardPage.findElement(By.xpath(DASHBOARD_NAME_FIELD)).clear();
        dashboardPage.fillField(DASHBOARD_NAME_FIELD, name);
        dashboardPage.findElement(By.xpath(DASHBOARD_DESCRIPTION_FIELD)).clear();
        dashboardPage.fillField(DASHBOARD_DESCRIPTION_FIELD, description);

        if (flag.equals("true")) {
            dashboardPage.click(DASHBOARD_SHARE_FLAG);
        }

        dashboardPage.click(ADD_BUTTON);
    }
}
