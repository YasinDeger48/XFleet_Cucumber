package com.xfleet.step_definitions;

import com.xfleet.pages.BasePage;
import com.xfleet.pages.HomePage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class LoginApachePOIStepDefinitions {
    Random random = new Random();
    BasePage page = new BasePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    String password = BrowserUtils.password();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    List<String> TruckDrivers = BrowserUtils.truckDriversUserName();
    List<String> salesManagers = BrowserUtils.salesManagersUserName();
    List<String> storeManagers = BrowserUtils.storeManagersUserName();



    @Given("Users are on the login page")
    public void users_are_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.site"));
    }
    @When("Truck Driver enters username and password, clicks the login button and should see the {string}")
    public void truck_driver_enters_username_and_password_clicks_the_login_button_and_should_see_the(String header) {



        for (int i = 0; i < 5; i++) {
            loginPage.login(TruckDrivers.get(random.nextInt(BrowserUtils.truckDriversUserName().size())), password);
            wait.until(ExpectedConditions.attributeToBe(loginPage.loaderMasky,"class","loader-mask"));
            Assert.assertTrue(homePage.quickLaunchPadText.isDisplayed() && homePage.quickLaunchPadText.getText().equals(header));
            homePage.logout();

        }


    }

    @When("Sales Managers enters username and password, clicks the login button and should see the {string}")
    public void salesManagersEntersUsernameAndPasswordClicksTheLoginButtonAndShouldSeeThe(String header) {


        for (int i = 0; i <5 ; i++) {
            loginPage.login(salesManagers.get(random.nextInt(BrowserUtils.salesManagersUserName().size())), password);
            wait.until(ExpectedConditions.attributeToBe(loginPage.loaderMasky,"class","loader-mask"));
            Assert.assertTrue(homePage.dashboardText.isDisplayed() && homePage.dashboardText.getText().contains(header));
            homePage.logout();
        }
    }

    @When("Store Managers enters username and password, clicks the login button and should see the {string}")
    public void storeManagersEntersUsernameAndPasswordClicksTheLoginButtonAndShouldSeeThe(String header) {


        for (int i = 0; i < 5; i++) {
            loginPage.login(storeManagers.get(random.nextInt(BrowserUtils.storeManagersUserName().size())), password);
            wait.until(ExpectedConditions.attributeToBe(loginPage.loaderMasky,"class","loader-mask"));
            Assert.assertTrue(homePage.dashboardText.isDisplayed() && homePage.dashboardText.getText().contains(header));
            homePage.logout();
        }
    }
}
