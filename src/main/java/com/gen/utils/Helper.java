package com.gen.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Helper extends PageObject{

    public WebElement getNumberOfDevicesInput(String product) {
        String xPath = getProductXPath(product) + "//input";
        return driver.findElement(By.xpath(xPath));
    }

    public Select getYearsSelect(String product) {
        String xPath = getProductXPath(product) + "//select";
        return new Select(driver.findElement(By.xpath(xPath)));
    }

    public WebElement getIntPrice(String product) {
        String xpath = getProductXPath(product) + "//div[@class='integer']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getDecPrice(String product) {
        String xpath = getProductXPath(product) + "//div[@class='decimal']//span";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getCurrency(String product) {
        String xpath = getProductXPath(product) + "//span[@class='currency']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getSubscribeButton(String product) {
        String xpath = getProductXPath(product) + "//div[@class='smb-abox__button']//a//span";
        return driver.findElement(By.xpath(xpath));
    }

    public String getProductXPath(String product) {
        return "//div[@class='h5 footer-headline']//following-sibling::div//div[@data-abox-id='abox"+ product +"-business/products/small-business' and @class='smb-abox light']";
    }
}
