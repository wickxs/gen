package com.gen.components;

import com.gen.utils.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesDialog extends PageObject {

    @FindBy(xpath = "//div[@id='onetrust-banner-sdk']//div[@role='alertdialog']")
    private WebElement avastCookiesDialog;

    @FindBy(xpath = "//div[@id='onetrust-banner-sdk']//button[contains(text(),'OK')]")
    private WebElement cookiesOkButton;

    public CookiesDialog() {
        PageFactory.initElements(driver, this);
    }

    public void verifyAndCloseCookiesDialogWindow() {
        if (avastCookiesDialog.isDisplayed()){
            cookiesOkButton.click();
        }
    }
}
