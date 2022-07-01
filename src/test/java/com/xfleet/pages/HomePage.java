package com.xfleet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    //@FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    @FindBy(css = ".dropdown-toggle[href='javascript: void(0);']")
    public WebElement nameDropDown;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "//h1[.='Quick Launchpad']")
    public WebElement quickLaunchPadText;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement dashboardText;

    @FindBy(xpath = "(//h1)[2]")
    public WebElement headerText;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidPassOrUsernameAlertText;

    public void logout(){
        nameDropDown.click();
        logoutLink.click();
    }

}
