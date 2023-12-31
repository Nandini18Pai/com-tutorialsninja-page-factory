package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProductPage extends Utility {

    @CacheLookup

    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;

    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendarButton;

    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;

    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;

    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List<WebElement> dateList;

    @FindBy(css =  "#input-quantity")
    WebElement qtyField;

    @FindBy(xpath =  "//button[@id='button-cart']")
    WebElement addToCartButton;

    @FindBy(css =  "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    @FindBy(xpath =  "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    @FindBy(xpath =  "//div[@class = 'input-group date']//button")
    WebElement datePicker;



    //By productText = By.xpath("//div[@id = 'content']//h1");
   // By calendarButton = By.xpath("//div[@class = 'input-group date']//button");
    //By monthAndYearText = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    // By nextButton = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
   // By dateList = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
   // By qtyField = By.cssSelector("#input-quantity");
   // By addToCartButton = By.xpath("//button[@id='button-cart']");
   // By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
  //  By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
   // By datePicker = By.xpath("//div[@class = 'input-group date']//button");


    public String getProductText() {
        return getTextFromElement(productText);
    }

    public void selectDeliveryDate(String day, String month, String year) {
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = dateList;
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public String getProductAddedSuccessMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        clickOnElement(shoppingCartLink);
    }

    public void enterQuantity(String qty) {
        clearTextOnElement(qtyField);
        sendTextToElement(qtyField, qty);
    }
}
