package stepDefinitions;

import com.pages.CurrentAccountPage;
import com.pages.HomePage;
import com.qa.drivers.DriverFactory;
import com.qa.utils.BaseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class HomePageSteps extends BaseUtils {

    private static String title;
    private final HomePage homepage = new HomePage(DriverFactory.getDriver());

    @Given("user is on home page")
    public void user_is_on_home_page() {
        homepage.navigateToHomePage();
        Assert.assertTrue(homepage.isWhoWeAreButtonExist());
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = getPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }


    @When("user selects product and service link and clicks on current accounts product link")
    public CurrentAccountPage clicks_on_current_accounts_product_link() {
        return homepage.navigateToCurrentAccountPage();
    }

    @Then("current account product page should be displayed")
    public void current_account_product_page_should_be_displayed() {
        Assert.assertTrue(homepage.validateCurrentAccountPageDisplayed());
    }
}
