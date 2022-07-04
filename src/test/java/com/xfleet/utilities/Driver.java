package com.xfleet.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    //private static WebDriver driver;

    //private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver(){

        if(driverPool.get()==null){

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "sauce-lab-chrome":

                    try {
                        URL url = new URL("https://oauth-yasin.deger48-9835b:17350529-168c-4eb6-917a-4268216fb2f1@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                        ChromeOptions browserOptions = new ChromeOptions();
                        browserOptions.setCapability("platformName", "Windows 10");
                        browserOptions.setCapability("browserVersion", "latest");
                        Map<String, Object> sauceOptions = new HashMap<>();
                        sauceOptions.put("build", "<XFleet>");
                        sauceOptions.put("name", "<Login Test>");
                        browserOptions.setCapability("sauce:options", sauceOptions);
                        driverPool.set(new RemoteWebDriver(url, browserOptions));
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
            }

        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();

        }
    }

}
