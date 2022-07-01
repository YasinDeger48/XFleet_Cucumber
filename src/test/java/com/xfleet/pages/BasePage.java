package com.xfleet.pages;

import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordBox;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotYourPasswordLink;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;

    @FindBy(xpath = "//body/div[4]")
    public WebElement loaderMasky;

    public void login(String usertype){
        String username = "",password="";
        if(usertype.equals("Truck Driver")){
            username = BrowserUtils.truckDriversUserName().get(1);
            password = BrowserUtils.password();

        } else if (usertype.equals("Sales Manager")) {
            username = BrowserUtils.salesManagersUserName().get(1);
            password = BrowserUtils.password();

        } else if (usertype.equals("Store Manager")) {
            username = BrowserUtils.storeManagersUserName().get(1);
            password = BrowserUtils.password();

        }

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

/*        switch (usertype){
            case "Truck Driver":
                BrowserUtils.login(BrowserUtils.truckDriversUserName().get(1),BrowserUtils.password());
                break;
            case "Sales Manager":
                BrowserUtils.login(BrowserUtils.salesManagersUserName().get(1),BrowserUtils.password());
                break;
            case "Store Manager":
                BrowserUtils.login(BrowserUtils.storeManagersUserName().get(1),BrowserUtils.password());
                break;
        }*/
    }

    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }





}
