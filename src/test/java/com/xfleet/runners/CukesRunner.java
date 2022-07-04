package com.xfleet.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/reports/cucumber-report.html",
                "json:target/reports/cucumber-report.json",
                "rerun:target/reports/cucumber-report.txt",
                "me.jvt.cucumber.report.PrettyReports:target/reports/cucumber"
        },
        features = "src/test/resources/features", //content -> features
        glue = "com/xfleet/step_definitions", //source -> step definitions
        dryRun = false,
        tags = "@oracle",
        publish = false

)

public class CukesRunner {
}
