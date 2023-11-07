// package pages;

// public  Testcase2 {
    
// }

package pages;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.junit.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.PropertyConfigurator;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Testcase1;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;
import uistore.ShoppingUI;

public class Testcase2 {
    Base base = new Base();
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    private WebDriverHelper driverHelper;
    Reporter reporter = new Reporter();
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Testcase1.class);
    ExtentTest test = Reporter.generateExtentReport().createTest("Shopping", "Execution for Shopping Function");

    public Testcase2(WebDriver driver) {
        this.driver = driver;
        driverHelper = new WebDriverHelper(driver);
    }
       
    public void HovereToAge(String arg1, String arg2) throws Throwable {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driverHelper.hoverOneElement(ShoppingUI.Shop_By_Age);
            driverHelper.clickElement(ShoppingUI.SelectAge);
             test.log(Status.PASS, "Hover and Selected the age");
        } catch (Exception e) {
            e.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Age selecting Error");
            test.fail("Failed to Age selecting ", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
       
        }
    }
    
   
    public void scrolldown(String arg1) throws Throwable {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 250);");
                test.log(Status.PASS, "Scroll down to the Cost");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Scroll down to the Cost Error");
                test.fail("Failed to Scroll down", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
    }
    
        public void priceRange(String arg1) throws Throwable {
            try {
                driverHelper.clickElement(ShoppingUI.SelectCost);
                 test.log(Status.PASS, "Selected the cost");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Select cost Error");
                test.fail("Failed toSelecte the cost", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
        }
    public void  VerifyTheCount() throws Throwable {
            try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                String c1Text = driver.findElement(ShoppingUI.C1).getText();
                String c2Text = driver.findElement(ShoppingUI.C2).getText();
                c1Text = c1Text.replaceAll("[^a-zA-Z0-9]", "");
                c2Text = c2Text.replaceAll("[^a-zA-Z0-9]", "");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                logger.info(c1Text);
                logger.info(c2Text);


                if (c2Text.toLowerCase().contains(c1Text.toLowerCase())) {
                    return;
                } else {
                    Assert.assertTrue("C2 text does not contain C1 text. C1 text: '" + c1Text + "', C2 text: '" + c2Text + "'", false);
                }

                test.log(Status.PASS, "Assert the value");
                Screenshot.getScreenShot(driver, "Assert the value sucessfully");

            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Assert the value Error");
                test.fail("Failed to Assert the value", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
            test.log(Status.PASS, "Browser closed");
        }
    public void i_verify_the_total_number_of_results_found_based_on_the_selected_price_range() throws Throwable {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            String c1Text = driver.findElement(ShoppingUI.C1).getText();
            String c2Text = driver.findElement(ShoppingUI.C2).getText();
            c1Text = c1Text.replaceAll("[^a-zA-Z0-9]", "");                c2Text = c2Text.replaceAll("[^a-zA-Z0-9]", "");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info(c1Text);
            logger.info(c2Text);
                if (c2Text.toLowerCase().contains(c1Text.toLowerCase())) {
                    return;
                } else {
                    Assert.assertTrue("C2 text does not contain C1 text. C1 text: '" + c1Text + "', C2 text: '" + c2Text + "'", false);
                }

                test.log(Status.PASS, "Assert the value");
                Screenshot.getScreenShot(driver, "Assert the value sucessfully");

        } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Assert the value Error");
                test.fail("Failed to Assert the value", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
        test.log(Status.PASS, "Browser closed");
        }   
    
}



