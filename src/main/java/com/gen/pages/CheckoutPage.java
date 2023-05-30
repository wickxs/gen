package com.gen.pages;

import com.gen.utils.PageObject;
import org.apache.commons.lang3.tuple.Triple;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends PageObject {

    @FindBy(xpath = "//div[@role='banner']//img[@alt='Avast!']")
    private WebElement avastBanner;

    @FindBy(xpath = "//form[@id='ShoppingCartForm']//select[@name='productID']//option[@selected]")
    private WebElement yearsSelect;

    @FindBy(xpath = "//form[@id='ShoppingCartForm']//input[@title='quantity']")
    private WebElement quantityValue;

    @FindBy(xpath = "//form[@id='ShoppingCartForm']//div[@aria-label='Product price']")
    private WebElement priceText;

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public Triple<String, String, String> getQuantityAndPrice() {
        wait.waitUntilVisible(avastBanner);
        return Triple.of(yearsSelect.getText(), quantityValue.getAttribute("value"), priceText.getText());
    }
}
