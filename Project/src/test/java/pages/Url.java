

package pages;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
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
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;
import uistore.HomepageUI;

public class Url {
    Base base = new Base();
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    private WebDriverHelper driverHelper;
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Testcase1.class);

    public Url(WebDriver driver) {
        this.driver = driver;
        driverHelper = new WebDriverHelper(driver);
    }
    
    public void LaunchSite() {
        try {
            driver.get("https://www.elc.co.uk");
            options.addArguments("--remote-allow-origins=*");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driverHelper.clickElement(HomepageUI.AllowButton);
            logger.info("This is an informational message.");
            Screenshot.getScreenShot(driver, "Site launched sucessfully");


        } catch (Exception ex) {
            ex.printStackTrace();
           
           
        }
    }
}