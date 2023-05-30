package com.gen.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PageObject {

    public static final String AVAST_PAGE = "https://www.avast.com/en-us/business/products/small-business#pc";

    private static final Logger LOG = Logger.getLogger(PageObject.class.getName());

    public static WebDriver driver;
    public static Wait wait;

    public PageObject() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            LOG.info("Driver is set up!");
        }
        if (wait == null) {
            wait = new Wait(driver);
        }
    }

    public static void openPage() {
        driver.get(AVAST_PAGE);
        wait.forLoading(AVAST_PAGE);
        LOG.info("Loading open avast page.");
    }

    public void quit(){
        driver.close();
    }
}
