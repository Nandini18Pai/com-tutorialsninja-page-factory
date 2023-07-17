package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends Utility {

    @CacheLookup

    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;


   //By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    //By accountCreatedText = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
   // By continueBtn = By.xpath("//a[contains(text(),'Continue')]");


    public String getAccountLogoutText() {
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() {
        return getTextFromElement(accountCreatedText);
    }
    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
    }
}
