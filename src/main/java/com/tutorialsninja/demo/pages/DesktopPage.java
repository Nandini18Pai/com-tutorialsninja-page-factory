package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class DesktopPage extends Utility {

    @CacheLookup

    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @FindBy(id = "input-sort")
    WebElement sortBy;


   // By desktopsText = By.xpath("//h2[contains(text(),'Desktops')]");
    // By productsList = By.xpath("//h4/a");
   // By sortBy = By.id("input-sort");


    public String getDesktopsText() {
        return getTextFromElement(desktopsText);
    }

    public ArrayList<String> getProductsNameList() {
        List<WebElement> products = productsList;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        return originalProductsName;
    }


    public void selectProductByName(String product) {
        List<WebElement> products = productsList;
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
    }
}
