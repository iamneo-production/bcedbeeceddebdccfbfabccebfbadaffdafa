// package runner;
// import java.net.MalformedURLException;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.openqa.selenium.WebDriver;

// import com.aventstack.extentreports.ExtentReports;

// import pages.Homepage;
// import utils.Base;
// import utils.Reporter;
// import utils.WebDriverHelper;
// import uistore.ShoppingUI;


// public class Testcase2 {
//     private WebDriver driver;
//     private Homepage homepage;
//     Base base = new Base();
//     ExtentReports extent = new ExtentReports();


//     @Before
//     public void setUp() throws MalformedURLException {
//         driver = base.openBrowser();
//         driver.manage().window().maximize();
//         extent = Reporter.generateExtentReport();
//         homepage = new Homepage(driver); 
//     }

//     @Test
//     public void tc_002() throws Throwable {
//         homepage.i_hover_the_mouse_over_the_menu_and_click_the_category(null, null);
//         homepage.i_scroll_down_until_I_locate_the_option_on_the_left_side_of_the_page(null);
//         homepage.i_click_the_value_from_the_price_range_options(null);
//         homepage.i_verify_the_total_number_of_results_found_based_on_the_selected_price_range();
//     }

//     @After
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//             extent.flush();
//         }
//     }
// }
