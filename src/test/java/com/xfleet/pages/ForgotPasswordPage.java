package com.xfleet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends LoginPage{

    @FindBy(xpath = "//h2[.='Forgot Password']")
    public WebElement forgotPasswordHeader;

    @FindBy(name = "username")
    public WebElement usernameOrEmailBox;


    @FindBy(xpath = "//a[.='« Return to Login']")
    public WebElement returnToLoginLink;

    @FindBy(xpath = "//button[.='Request']")
    public WebElement requestButton;

}
