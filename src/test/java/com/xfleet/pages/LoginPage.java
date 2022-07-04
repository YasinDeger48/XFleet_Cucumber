package com.xfleet.pages;

import com.xfleet.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "prependedInput")
    public WebElement usernameBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordBox;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeCheckBox;

    @FindBy(id = "remember_me")
    public WebElement checkbox2;

    @FindBy(xpath = "//span[.='Remember me on this computer']")
    public  WebElement rememberMeOnThisComputerText;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotYourPasswordLink;

    @FindBy(id = "_submit")
    public WebElement loginButton;


    @FindBy(xpath = "//h2[.='Login']")
    public WebElement loginPageText;




    /*METHODS*/


    public void login(String usertype){
        String username = "",password="";



        if(usertype.equals("Truck Driver")){
            username = BrowserUtils.truckDriversUserName().get(random.nextInt(BrowserUtils.truckDriversUserName().size()));
            password = BrowserUtils.password();

        } else if (usertype.equals("Sales Manager")) {
            username = BrowserUtils.salesManagersUserName().get(random.nextInt(BrowserUtils.salesManagersUserName().size()));
            password = BrowserUtils.password();

        } else if (usertype.equals("Store Manager")) {
            username = BrowserUtils.storeManagersUserName().get(random.nextInt(BrowserUtils.storeManagersUserName().size()));
            password = BrowserUtils.password();

        }

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }

    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

}
