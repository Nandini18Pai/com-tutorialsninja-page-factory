package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class AccountLoginPage extends Utility {
    @CacheLookup

    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;

    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;

    @FindBy(id = "input-email" )
    WebElement emailAddressField;

    @FindBy(id = "input-password" )
    WebElement passwordField;

    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;


   // By returningCustomerText = By.xpath("//div[@id='content']/div/div[2]//h2");
  //  By newCustomerText = By.xpath("//div[@id='content']/div/div[1]//h2");
   // By emailAddressField = By.id("input-email");
  //  By passwordField = By.id("input-password");
  //  By loginBtn = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public String getReturningCustomerText() {
        return getTextFromElement(returningCustomerText);

    }

    public String getNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) {
        sendTextToElement(emailAddressField, email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginBtn);
    }

}
