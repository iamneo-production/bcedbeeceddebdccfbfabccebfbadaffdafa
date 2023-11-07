package runner;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;

import pages.Homepage;
import utils.Base;
import utils.Reporter;
import utils.WebDriverHelper;
import uistore.HomepageUI;


public class Testcase1 {
    private WebDriver driver;
    private Homepage homepage;
    Base base = new Base();
    ExtentReports extent = new ExtentReports();

    @Before
    public void setUp() throws MalformedURLException {
        driver = base.openBrowser();
        driver.manage().window().maximize();
         extent = Reporter.generateExtentReport();
        homepage = new Homepage(driver); 
    }

    @Test
    public void tc_001() throws Throwable {
        homepage.i_am_on_ELC_Website();
        homepage.i_input_the_text_into_the_search_box("Peppa pig");
        homepage.i_click_on_the_first_option_from_the_auto_populated_list();
        homepage.i_confirm_that_the_search_results_page_contains_the_label("Peppa pig");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            extent.flush();
        }
    }
}
