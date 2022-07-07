package com.xfleet.step_definitions;

import com.xfleet.cucumber.TestUtil;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Hooks extends TestUtil {


    private TestUtil base;

    public Hooks(TestUtil base) {
        this.base = base;
    }


    @Before
    public void InitializeTest(){

        System.out.println("openinig the browser");

        //passing a dummy webdriver instance

        base.stepInfo = "FirefoxDriver";
    }






    @After  //import cucumber library
    public void teardown(Scenario scenario){

        if(scenario.isFailed()){

            TakesScreenshot ts =(TakesScreenshot) Driver.getDriver();

            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png",scenario.getName());

        }

        try{
            Driver.closeDriver();
        }catch (Exception e){

        }



    }
}
