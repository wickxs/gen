package com.gen.pages;

import com.gen.components.CookiesDialog;
import com.gen.utils.Helper;
import com.gen.utils.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends PageObject {

    @FindBy(xpath = "//header//div[@class='avast-logo']")
    WebElement avastLogo;

    private final CookiesDialog cookiesDialog;
    private final Helper helper;

    public MainPage() {
        this.cookiesDialog = new CookiesDialog();
        this.helper = new Helper();
        PageFactory.initElements(driver, this);
    }

    public void openAndVerifyPage() {
        openPage();
        cookiesDialog.verifyAndCloseCookiesDialogWindow();
        wait.waitUntilVisible(avastLogo);
    }

    public void setQuantity(String product, String devices, String years){
        var input = helper.getNumberOfDevicesInput(product);
        input.sendKeys(Keys.chord(Keys.BACK_SPACE));
        input.sendKeys(devices);
        helper.getYearsSelect(product).selectByVisibleText(years);
    }

    public String getPrice(String product) {
        return helper.getCurrency(product).getText()
                + helper.getIntPrice(product).getText()
                + helper.getDecPrice(product).getText();
    }

    public void subscribeToProduct(String product) {
        helper.getSubscribeButton(product).click();
    }

}
