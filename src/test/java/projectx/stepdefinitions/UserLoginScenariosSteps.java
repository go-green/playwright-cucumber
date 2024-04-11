/**
 * @author Rasika Ranawaka
 * @filename UserLoginScenariosSteps
 * @date 11/04/2024
 */
package projectx.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectx.hooks.ScenarioContext;
import projectx.pages.PxLoginPage;

public class UserLoginScenariosSteps extends BaseSteps {

    PxLoginPage pxLoginPage;

    public UserLoginScenariosSteps (ScenarioContext scenarioContext) {
        this.page = scenarioContext.getPage();
    }

    @Given("^I have navigated to GitHub login page$")
    public void user_has_navigated_to_GitHub_login_page() {
        pxLoginPage = this.createInstance(PxLoginPage.class);
        pxLoginPage.navigate();
        pxLoginPage.verifyPage();
    }

    @When("^I enter my valid credentials$")
    public void user_has_entered_valid_credentials() {
        pxLoginPage.login("test", "test");
    }

    @Then("^I am navigated to the default landing page$")
    public void user_is_navigated_to_landing_page() {

    }
}
