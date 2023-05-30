package com.gen.steps;

import com.gen.pages.CheckoutPage;
import com.gen.pages.MainPage;
import com.gen.utils.Context;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.logging.Logger;

public class StepDefinitions {
    private static final Logger LOG = Logger.getLogger(StepDefinitions.class.getName());

    private final MainPage mainPage;
    private final CheckoutPage checkoutPage;
    private final Context context;

    public StepDefinitions() {
        this.mainPage = new MainPage();
        this.checkoutPage = new CheckoutPage();
        this.context = new Context();
    }

    @Given("I open avast products webpage")
    public void openProductsPage() {
        mainPage.openAndVerifyPage();
        LOG.info("Avast product page wa loaded.");
    }

    @And("I choose \"([^\"]*)\" product$")
    public void chooseProduct(String product) {
        switch (product) {
            case "Essential", "Premium", "Ultimate" -> context.setProduct(product);
            default -> throw new IllegalArgumentException("No such product");
        }
        LOG.info("Product " + product + " was selected.");
    }

    @Given("I set number of devices to \"([^\"]*)\" and years to \"([^\"]*)\"$")
    public void setQuantity(String devices, String years) {
        Assertions.assertThat(years).isIn("1 year", "2 years", "3 years");
        context.setCatalogueDevices(devices);
        context.setCatalogueYears(years);
        mainPage.setQuantity(context.getProduct(), devices, years);
        context.setCataloguePrice(mainPage.getPrice(context.getProduct()));
        LOG.info(devices + " devices and " + years + " year(s) were selected.");
    }

    @When("I click on subscribe now button")
    public void subscribe() {
        mainPage.subscribeToProduct(context.getProduct());
        LOG.info("Subscribe now button was clicked.");
    }

    @Then("Quantity and prices match")
    public void verifyQuantityAndPrice() {
        var results = checkoutPage.getQuantityAndPrice();
        Assertions.assertThat(context.getCatalogueYears()).isEqualToIgnoringCase(results.getLeft());
        Assertions.assertThat(context.getCatalogueDevices()).isEqualTo(results.getMiddle());
        Assertions.assertThat(context.getCataloguePrice()).isEqualTo(results.getRight());
        LOG.info("Quantity and price on checkout page matches quantity and price from catalogue.");
    }

    @After()
    public void closeBrowser() {
        mainPage.quit();
    }
}
