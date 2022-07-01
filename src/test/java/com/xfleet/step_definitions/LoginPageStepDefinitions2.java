package com.xfleet.step_definitions;

import com.xfleet.pages.HomePage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageStepDefinitions2 {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    HomePage homePage = new HomePage();

    @Given("Users are on the xfleet login page")
    public void usersAreOnTheXfleetLoginPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("web.site"));
    }

    @When("user is login as a {string}")
    public void userIsLoginAsA(String user) {

        homePage.login(user);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.nameDropDown));


    }

    @Then("user is on the {string}")
    public void userIsOnThe(String page) {

        Assert.assertTrue(homePage.headerText.getText().contains(page));

    }


    @When("user enters valid {string} and invalid {string}")
    public void user_enters_valid_and_invalid(String string, String string2) {

        homePage.login(string,string2);


    }
    @When("user enters invalid {string} and valid {string}")
    public void user_enters_invalid_and_valid(String string, String string2) {

        homePage.login(string,string2);

    }

    @And("user should be see {string}")
    public void userShouldBeSee(String arg0) {

        Assert.assertTrue(homePage.invalidPassOrUsernameAlertText.getText().equals(arg0));
    }





}
