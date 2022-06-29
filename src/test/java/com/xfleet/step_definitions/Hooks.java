package com.xfleet.step_definitions;

import com.xfleet.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {



    @After  //import cucumber library
    public void teardown(Scenario scenario){

        if(scenario.isFailed()){

            TakesScreenshot ts =(TakesScreenshot) Driver.getDriver();

            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png",scenario.getName());

        }

        Driver.closeDriver();


    }
}
