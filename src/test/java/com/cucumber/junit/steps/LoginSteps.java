package com.cucumber.junit.steps;

import com.cucumber.junit.pages.HomePage;
import com.cucumber.junit.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.cucumber.junit.pages.LoginPage.LOGIN_FIELD;
import static com.cucumber.junit.pages.LoginPage.PASSWORD_FIELD;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @When("User opens website")
    public void opensWebsite() {
        loginPage.openWebsite();
    }

    @When("User fills valid credentials")
    public void fillValidCredentials() {
        loginPage.findElement(By.xpath(LOGIN_FIELD)).clear();
        loginPage.fillField(LOGIN_FIELD, "default");
        loginPage.findElement(By.xpath(PASSWORD_FIELD)).clear();
        loginPage.fillField(PASSWORD_FIELD, "1q2w3e");
    }

    @When("Clicks {string}")
    public void clickButton(String button) {
        loginPage.click(button);
    }

    @Then("Page with title {string} is displayed")
    public void verifyPageTitle(String pageTitle) {
        assertThat(homePage.isPageWIthTitleIsDisplayed(pageTitle))
                .overridingErrorMessage("Page with title '%s' is not displayed", pageTitle)
                .isTrue();
    }

}
