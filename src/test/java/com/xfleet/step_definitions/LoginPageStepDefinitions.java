package com.xfleet.step_definitions;

import com.xfleet.pages.BasePage;
import com.xfleet.pages.ForgotPasswordPage;
import com.xfleet.pages.HomePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPageStepDefinitions {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    HomePage homePage = new HomePage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Given("Users are on the xfleet login page")
    public void usersAreOnTheXfleetLoginPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("web.site"));
    }

    @When("user is login as a {string}")
    public void userIsLoginAsA(String user) {

        loginPage.login(user);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.nameDropDown));
    }

    @Then("user is on the {string}")
    public void userIsOnThe(String page) {


        wait.until(ExpectedConditions.attributeToBe(loginPage.loaderMasky,"class","loader-mask"));
        Assert.assertTrue(homePage.headerText.getText().trim().contains(page));

    }


    @When("user enters valid {string} and invalid {string}")
    public void user_enters_valid_and_invalid(String string, String string2) {

        loginPage.login(string,string2);
    }
    @When("user enters invalid {string} and valid {string}")
    public void user_enters_invalid_and_valid(String string, String string2) {

        loginPage.login(string,string2);

    }

    @And("user should be see {string}")
    public void userShouldBeSee(String message) {

        Assert.assertTrue(homePage.invalidPassOrUsernameAlertText.getText().equals(message));
        loginPage.passwordBox.clear();
        loginPage.usernameBox.clear();

    }


    @When("user enters credential as {string} and {string}")
    public void userEntersCredentialAsAnd(String username, String password) {
        loginPage.login(username,password);
    }

    @And("user should be see fillout {string}")
    public void userShouldBeSeeFillout(String message) {

        Assert.assertTrue(message.equals(loginPage.usernameBox.getAttribute("validationMessage")));

    }

    /* AC-3 Steps*/

    @When("user enters credential as {string} and {string} without password")
    public void user_enters_credential_as_and_without_password(String string, String string2) {
        loginPage.login(string,string2);


    }
    @When("user should be see {string} for password")
    public void user_should_be_see_for_password(String message) {

       String validationMessage = loginPage.passwordBox.getAttribute("validationMessage");
        Assert.assertTrue(validationMessage.equals(message) &&
                loginPage.usernameBox.getAttribute("validationMessage").equals(""));
        loginPage.usernameBox.clear();

/*        boolean result = BrowserUtils.attributeCheck(homePage.passwordBox,"validationMessage");

        Assert.assertTrue(result);
        homePage.usernameBox.clear();*/


    }
    @When("user enters credential as {string} and {string} without username")
    public void user_enters_credential_as_and_without_username(String string, String string2) {
        loginPage.login(string,string2);



    }
    @Then("user should be see {string} for username")
    public void user_should_be_see_for_username(String message) {

        String validationMessage = loginPage.usernameBox.getAttribute("validationMessage");

        Assert.assertTrue(validationMessage.equals(message) &&
                loginPage.passwordBox.getAttribute("validationMessage").equals(""));
        loginPage.passwordBox.clear();
/*
        boolean result = BrowserUtils.attributeCheck(homePage.usernameBox,"validationMessage");

        Assert.assertTrue(result);
        homePage.passwordBox.clear();*/

    }

    /* AC-4 Steps*/

    @When("user sees the {string} link")
    public void user_sees_the_link(String link) {

        String linkText = BrowserUtils.getText(link);
        Assert.assertTrue(linkText.equals(link));


    }
    @When("user can click the {string} link")
    public void user_can_click_the_link(String string) {

        BrowserUtils.clickLink(string);
    }


    @When("user should be see {string} page")
    public void user_should_be_see_page(String header) {

        Assert.assertTrue(forgotPasswordPage.forgotPasswordHeader.getText().equals(header));


    }



    /* AC-5 Steps*/


    @When("user clicks on checkbox")
    public void user_clicks_on_checkbox() {

        loginPage.rememberMeCheckBox.click();



    }

    @When("user sees checkbox is checked")
    public void user_sees_checkbox_is_checked() {

       // wait.until(ExpectedConditions.elementToBeSelected(loginPage.rememberMeCheckBox));

        Assert.assertTrue(loginPage.checkbox2.isSelected());


    }



    /* AC-6 Steps*/

    @When("user enters {string} in password box")
    public void user_enters_in_password_box(String string) {

        loginPage.passwordBox.sendKeys(string);
    }
    @Then("user sees the password as password sign")
    public void user_sees_the_password_as_password_sign() {

        String type = loginPage.passwordBox.getAttribute("type");
        Assert.assertEquals(type,"password");
    }

    /* AC-7 Steps*/

    @When("user enters username {string}")
    public void user_enters_username(String string) {

        loginPage.usernameBox.sendKeys(string);

    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {

        loginPage.passwordBox.sendKeys(string);
    }
    @When("user press the enter button")
    public void user_press_the_enter_button() {

        loginPage.passwordBox.sendKeys(Keys.ENTER);

    }
    @Then("user sees {string}")
    public void user_sees(String string) {

        wait.until(ExpectedConditions.attributeToBe(loginPage.loaderMasky,"class","loader-mask"));
        Assert.assertTrue(homePage.headerText.getText().trim().equals(string));

    }




    /* AC-8 Steps*/

    @When("user is login with {string} and {string}")
    public void user_is_login_with_and(String string, String string2) {
        loginPage.login(string,string2);

    }

    @Then("user sees own name {string} in profile menu")
    public void user_sees_own_name_in_profile_menu(String expectedResult) {

        Assert.assertEquals(expectedResult, homePage.namesOfUsers.getText().trim());

    }



}
