package com.xfleet.step_definitions;

import com.xfleet.pages.HomePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutStepDefinitions {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.site"));
    }


    @And("user is on the home page")
    public void user_is_on_the_home_page() {
       loginPage.login(ConfigurationReader.getProperty("valid.username"),ConfigurationReader.getProperty("valid.password"));
        wait.until(ExpectedConditions.attributeToBe(loginPage.loaderMasky,"class","loader-mask"));


    }
    @When("user clicks over name")
    public void user_clicks_over_name() {

        homePage.nameDropDown.click();

    }
    @When("user sees the logout {string} link")
    public void user_sees_the_logout_link(String logout) {

        String actualText = homePage.logoutLink2.getText();
        Assert.assertTrue(logout.equals(actualText));


    }
    @When("user clicks the Logout link")
    public void user_clicks_the_logout_link() {

        homePage.logoutLink.click();
    }
    @Then("user sees the {string} page")
    public void user_sees_the_login_page(String loginPageText) {

        Assert.assertTrue(loginPageText.equals(loginPage.loginPageText.getText()));

    }

    //ac2


    @When("user clicks the step back button")
    public void user_clicks_the_step_back_button() {

        Driver.getDriver().navigate().back();

    }

    @When("user clicks the step forward button")
    public void user_clicks_the_step_forward_button() {

        Driver.getDriver().navigate().forward();

    }
    @Then("user can not see homepage again")
    public void user_can_not_see_homepage_again() {

        Assert.assertTrue(loginPage.loginPageText.getText().equals("Login") &&
                !homePage.dashboardText.isDisplayed());


    }


//ac3


    @When("user closes the tabs")
    public void user_closes_the_tabs() {



    }
    @When("user enters the homepage link again")
    public void user_enters_the_homepage_link_again() {

        Driver.getDriver().get(ConfigurationReader.getProperty("web.site"));
        wait.until(ExpectedConditions.attributeToBe(loginPage.loaderMasky,"class","loader-mask"));
        Assert.assertTrue(homePage.headerText.isDisplayed());

    }


}