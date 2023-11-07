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


// public class Testcase3 {
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
//     public void tc_003() throws Throwable {


//         homepage.i_click_on_the_menu(null);
//         homepage.i_scroll_down_until_I_reach_the_filter(null);
//         homepage.i_click_on_the_link(null);
//         homepage.i_click_the_checkbox_of(null);
//         homepage.i_verify_whether_the_name_of_the_chosen_brand_is_available_on_the_page();
//       }
    

//     @After
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//             extent.flush();
//         }
//     }
// }
