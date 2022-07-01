package com.xfleet.step_definitions;

import com.xfleet.pages.BasePage;
import com.xfleet.pages.HomePage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageStepDefinitions2 {
    BasePage basePage = new BasePage();
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
    public void userShouldBeSee(String message) {

        Assert.assertTrue(homePage.invalidPassOrUsernameAlertText.getText().equals(message));
    }


    @When("user enters credential as {string} and {string}")
    public void userEntersCredentialAsAnd(String username, String password) {
        homePage.login(username,password);
    }

    @And("user should be see fillout {string}")
    public void userShouldBeSeeFillout(String message) {

        Assert.assertTrue(message.equals(homePage.usernameBox.getAttribute("validationMessage")));

    }

    /* AC-3 Steps*/

    @When("user enters credential as {string} and {string} without password")
    public void user_enters_credential_as_and_without_password(String string, String string2) {
        homePage.login(string,string2);


    }
    @When("user should be see {string} for password")
    public void user_should_be_see_for_password(String message) {

       String validationMessage = homePage.passwordBox.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.equals(message) &&
                homePage.usernameBox.getAttribute("validationMessage").equals(""));
        homePage.usernameBox.clear();

/*        boolean result = BrowserUtils.attributeCheck(homePage.passwordBox,"validationMessage");

        Assert.assertTrue(result);
        homePage.usernameBox.clear();*/


    }
    @When("user enters credential as {string} and {string} without username")
    public void user_enters_credential_as_and_without_username(String string, String string2) {
        homePage.login(string,string2);



    }
    @Then("user should be see {string} for username")
    public void user_should_be_see_for_username(String message) {

        String validationMessage = homePage.usernameBox.getAttribute("validationMessage");

        Assert.assertTrue(validationMessage.equals(message) &&
                homePage.passwordBox.getAttribute("validationMessage").equals(""));
        homePage.passwordBox.clear();
/*
        boolean result = BrowserUtils.attributeCheck(homePage.usernameBox,"validationMessage");

        Assert.assertTrue(result);
        homePage.passwordBox.clear();*/

    }





}
