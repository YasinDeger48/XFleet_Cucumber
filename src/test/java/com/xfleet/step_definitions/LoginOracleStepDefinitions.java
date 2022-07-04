package com.xfleet.step_definitions;

import com.xfleet.pages.HomePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOracleStepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    @When("User enters username")
    public void user_enters_username() {
        loginPage.usernameBox.sendKeys(BrowserUtils.getUserNameWithOracle());

    }
    @When("User enters password")
    public void user_enters_password() {
       loginPage.passwordBox.sendKeys(BrowserUtils.getPasswordWithOracle());

    }
    @When("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();

    }
    @Then("User should see xfleet homepage")
    public void user_should_see_xfleet_home_page() {

        wait.until(ExpectedConditions.attributeToBe(loginPage.loaderMasky,"class","loader-mask"));
        Assert.assertTrue(homePage.dashboardText.isDisplayed());

    }


}
