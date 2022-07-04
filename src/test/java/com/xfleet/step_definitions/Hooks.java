package com.xfleet.step_definitions;

import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.SQLException;

public class Hooks {


/*    @AfterStep
    public void each(){
        BrowserUtils.sleep(2);
    }*/


    @Test
    public void testCase() throws SQLException {

        System.out.println(BrowserUtils.getUserNameWithOracle());
        System.out.println(BrowserUtils.getPasswordWithOracle());


    }



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
