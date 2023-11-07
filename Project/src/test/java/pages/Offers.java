// package pages;

// import java.net.MalformedURLException;
// import java.time.Duration;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.slf4j.Logger;
// import com.aventstack.extentreports.Status;
// import com.aventstack.extentreports.MediaEntityBuilder;
// import com.aventstack.extentreports.ExtentReports;
// import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.reporter.ExtentSparkReporter;
// import org.junit.Assert;
// import cucumber.api.PendingException;
// import cucumber.api.java.After;
// import cucumber.api.java.Before;
// import cucumber.api.java.en.Given;
// import cucumber.api.java.en.Then;
// import cucumber.api.java.en.When;
// import runner.*;
// import utils.*;


// public class Offers{
//     private static ExtentReports reporter;
//     private Url url;
//     private Testcase1 testcase1;
//     private Testcase2 tesstcas2;
//     private Testcase3 testcase3;
//     private WebDriver driver;
//     ExtentReports extent = new ExtentReports();
//     ChromeOptions options = new ChromeOptions();
//     Base base = new Base();


//     public Offers() { 
//     }

//     public Offers(WebDriver driver) {
//         this.driver = driver;
//         // reporter = Reporter.generateExtentReport();
//     }


//     @Before
//     public void setUp() throws MalformedURLException {
//         // driver = base.openBrowser();
//         // driver.manage().window().maximize();
//         extent = Reporter.generateExtentReport();
//         url = new Url(driver);
//         tesstcas2 = new Testcase2(driver);
//         testcase3 = new Testcase3(driver);
//     }
    
//         @When("^I hover the mouse over the \"([^\"]*)\" menu and click the \"([^\"]*)\" category$")
//         public void i_hover_the_mouse_over_the_menu_and_click_the_category(String arg1, String arg2) throws Throwable {
//             tesstcas2.HovereToAge(arg1, arg2);
//         }

//         @When("^I scroll down until I locate the \"([^\"]*)\" option on the left side of the page$")
//         public void i_scroll_down_until_I_locate_the_option_on_the_left_side_of_the_page(String arg1) throws Throwable {
//             tesstcas2.scrolldown(arg1);
            
//         }

//         @When("^I click the value \"([^\"]*)\" from the price range options$")
//         public void i_click_the_value_from_the_price_range_options(String arg1) throws Throwable {
//             tesstcas2.priceRange(arg1);
//         }

//         @Then("^I verify the total number of results found based on the selected price range$")
//         public void i_verify_the_total_number_of_results_found_based_on_the_selected_price_range() throws Throwable {
//             tesstcas2.VerifyTheCount();
//         }    
// @After
//     public void tearDown() {
//        driver.quit();
//        extent.flush();
//     }

// }
