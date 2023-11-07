package runner;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import utils.*;


public class Homepage{
    private static ExtentReports reporter;
    private Url url;
    private Testcase1 testcase1;
    private Testcase2 tesstcas2;
    private Testcase3 testcase3;
    private WebDriver driver;
    ExtentReports extent = new ExtentReports();
    ChromeOptions options = new ChromeOptions();
    Base base = new Base();


    public Homepage() { 
    }

    public Homepage(WebDriver driver) {
        this.driver = driver;
        // reporter = Reporter.generateExtentReport();
    }


    @Before
    public void setUp() throws MalformedURLException {
        driver = base.openBrowser();
        driver.manage().window().maximize();
        extent = Reporter.generateExtentReport();
        url = new Url(driver);
        testcase1 = new Testcase1(driver);
        tesstcas2 = new Testcase2(driver);
        testcase3 = new Testcase3(driver);
    }
    
        @Given("^I am on ELC Website$")
        public void i_am_on_ELC_Website() throws Throwable {
            url.LaunchSite();
        }

        @When("^I input the text \"([^\"]*)\" into the search box$")
        public void i_input_the_text_into_the_search_box(String arg1) throws Throwable {
            testcase1.ClickSearch("Peppa pig");
            
        }

        @When("^I click on the first option from the auto-populated list$")
        public void i_click_on_the_first_option_from_the_auto_populated_list() throws Throwable {
            testcase1.SelectFromList();
            
        }

        @Then("^I confirm that the search results page contains the label \"([^\"]*)\"$")
        public void i_confirm_that_the_search_results_page_contains_the_label(String arg1) throws Throwable {
            testcase1.ClickSearch("Peppa pig");
          
        }

        @When("^I hover the mouse over the \"([^\"]*)\" menu and click the \"([^\"]*)\" category$")
        public void i_hover_the_mouse_over_the_menu_and_click_the_category(String arg1, String arg2) throws Throwable {
            tesstcas2.HovereToAge(arg1, arg2);
        }

        @When("^I scroll down until I locate the \"([^\"]*)\" option on the left side of the page$")
        public void i_scroll_down_until_I_locate_the_option_on_the_left_side_of_the_page(String arg1) throws Throwable {
            tesstcas2.scrolldown(arg1);
            
        }

        @When("^I click the value \"([^\"]*)\" from the price range options$")
        public void i_click_the_value_from_the_price_range_options(String arg1) throws Throwable {
            tesstcas2.priceRange(arg1);
        }

        @Then("^I verify the total number of results found based on the selected price range$")
        public void i_verify_the_total_number_of_results_found_based_on_the_selected_price_range() throws Throwable {
            tesstcas2.VerifyTheCount();
        }    

        @When("^I click on the \"([^\"]*)\" menu$")
        public void i_click_on_the_menu(String arg1) throws Throwable {
            testcase3.ClickMenu(arg1, arg1);
        }

        @When("^I scroll down until I reach the \"([^\"]*)\" filter$")
        public void i_scroll_down_until_I_reach_the_filter(String arg1) throws Throwable {
            testcase3.scrolldown(arg1);
        }

        @When("^I click on the \"([^\"]*)\" link$")
        public void i_click_on_the_link(String arg1) throws Throwable {
            testcase3.Click_Showmore(arg1);
        }

        @When("^I click the checkbox of \"([^\"]*)\"$")
        public void i_click_the_checkbox_of(String arg1) throws Throwable {
            testcase3.Select_Brand(arg1);
        }

        @Then("^I verify whether the name of the chosen brand is available on the page$")
        public void i_verify_whether_the_name_of_the_chosen_brand_is_available_on_the_page() throws Throwable {
            testcase3.Check_Avaliable();
        }
@After
    public void tearDown() {
       driver.quit();
       extent.flush();
    }

}
