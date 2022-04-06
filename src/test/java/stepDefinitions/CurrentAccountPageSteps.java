package stepDefinitions;

import com.pages.CurrentAccountPage;
import com.pages.HomePage;
import com.qa.drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CurrentAccountPageSteps {

    private final HomePage homepage = new HomePage(DriverFactory.getDriver());
    private CurrentAccountPage currentAccountPage;

    @When("user is on current account page")
    public void user_is_on_current_account_page() {
        Assert.assertTrue(homepage.validateCurrentAccountPageDisplayed());
    }

    @Then("validate expected current accounts displayed on page")
    public void validate_expected_current_accounts_displayed_on_page() {
        currentAccountPage.validateCurrentAccountsOnPage();
    }

    @Then("verify platinum account fee value should be £{int}")
    public void verify_platinum_account_fee(Integer int1) {
        String feeValue = int1.toString();
        Assert.assertTrue(currentAccountPage.validatePlatinumFeeValue(feeValue));
    }
}
