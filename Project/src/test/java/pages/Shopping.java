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


// public class Shopping{
//     private static ExtentReports reporter;
//     private Url url;
//     private Testcase1 testcase1;
//     private Testcase2 tesstcas2;
//     private Testcase3 testcase3;
//     private WebDriver driver;
//     ExtentReports extent = new ExtentReports();
//     ChromeOptions options = new ChromeOptions();
//     Base base = new Base();


//     public Shopping() { 
//     }

//     public Shopping(WebDriver driver) {
//         this.driver = driver;
//         // reporter = Reporter.generateExtentReport();
//     }


//     // @Before
//     // public void setUp() throws MalformedURLException {
//     //     driver = base.openBrowser();
//     //     driver.manage().window().maximize();
//     //     extent = Reporter.generateExtentReport();
//     //     url = new Url(driver);
//     //     testcase1 = new Testcase1(driver);
//     //     tesstcas2 = new Testcase2(driver);
//     //     testcase3 = new Testcase3(driver);
//     // }
    
//         // @Given("^I am on ELC Website$")
//         // public void i_am_on_ELC_Website() throws Throwable {
//         //     url.LaunchSite();
//         // }

//         @When("^I click on the \"([^\"]*)\" menu$")
//         public void i_click_on_the_menu(String arg1) throws Throwable {
//             testcase3.ClickMenu(arg1, arg1);
//         }

//         @When("^I scroll down until I reach the \"([^\"]*)\" filter$")
//         public void i_scroll_down_until_I_reach_the_filter(String arg1) throws Throwable {
//             testcase3.scrolldown(arg1);
//         }

//         @When("^I click on the \"([^\"]*)\" link$")
//         public void i_click_on_the_link(String arg1) throws Throwable {
//             testcase3.Click_Showmore(arg1);
//         }

//         @When("^I click the checkbox of \"([^\"]*)\"$")
//         public void i_click_the_checkbox_of(String arg1) throws Throwable {
//             testcase3.Select_Brand(arg1);
//         }

//         @Then("^I verify whether the name of the chosen brand is available on the page$")
//         public void i_verify_whether_the_name_of_the_chosen_brand_is_available_on_the_page() throws Throwable {
//             testcase3.Check_Avaliable();
//         }
// // @After
// //     public void tearDown() {
// //        driver.quit();
// //        extent.flush();
// //     }

// }
