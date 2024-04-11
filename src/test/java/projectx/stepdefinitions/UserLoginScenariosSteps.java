/**
 * @author Rasika Ranawaka
 * @filename UserLoginScenariosSteps
 * @date 11/04/2024
 */
package projectx.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectx.hooks.Hooks;
import projectx.hooks.ScenarioContext;
import projectx.pages.PxInventoryPage;
import projectx.pages.PxLoginPage;
import projectx.pojos.InventoryItem;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class UserLoginScenariosSteps extends BaseSteps {

    PxLoginPage pxLoginPage;

    PxInventoryPage pxInventoryPage;

    private ScenarioContext context;

    public UserLoginScenariosSteps (Hooks hooks, ScenarioContext context) {
        this.page = hooks.getPage();
        this.context = context;
    }

    @Given("^I have navigated to SauceDemo login page$")
    public void user_has_navigated_to_GitHub_login_page() {
        pxLoginPage = this.createInstance(PxLoginPage.class);
        pxLoginPage.navigate();
        pxLoginPage.verifyPage();
    }

    @When("^I enter valid credentials$")
    public void user_has_entered_valid_credentials() {
        pxLoginPage.login("standard_user", "secret_sauce");
    }

    @Then("^I am navigated to the inventory page$")
    public void user_is_navigated_to_landing_page() {
        pxInventoryPage = this.createInstance(PxInventoryPage.class);
        pxInventoryPage.verifyPage();
        List<InventoryItem> items = pxInventoryPage.getInventoryItems();
        assertThat(items, hasSize(6));
    }
}
