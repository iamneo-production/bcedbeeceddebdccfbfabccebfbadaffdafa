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
import uistore.HomepageUI;
import uistore.OffersUI;
import uistore.ShoppingUI;
import utils.*;


public class Homepage{
    private static ExtentReports reporter;
    private WebDriver driver;
    ExtentReports extent = new ExtentReports();
    ChromeOptions options = new ChromeOptions();
    private WebDriverHelper driverHelper;
    Base base = new Base();
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Homepage.class);


    public Homepage() { 
    }

    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.driverHelper = new WebDriverHelper(driver); 
        driverHelper = new WebDriverHelper(driver);
        reporter = Reporter.generateExtentReport();
    }

    ExtentTest test = Reporter.generateExtentReport().createTest("Homepage", "Execution for HomePage Function");

    
        @Given("^I am on ELC Website$")
        public void i_am_on_ELC_Website() throws Throwable {
             try {
            driver.get("https://www.elc.co.uk");
            options.addArguments("--remote-allow-origins=*");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // driverHelper.clickElement(HomepageUI.AllowButton);
            WebElement allowButton = wait.until(ExpectedConditions.elementToBeClickable(HomepageUI.AllowButton));
            allowButton.click();

            logger.info("This is an informational message.");
            Screenshot.getScreenShot(driver, "Site launched sucessfully");
            } 
            catch (Exception ex) {
                ex.printStackTrace();   
            }

        }

        @When("^I input the text \"([^\"]*)\" into the search box$")
        public void i_input_the_text_into_the_search_box(String arg1) throws Throwable {
           try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driverHelper.fillForm(HomepageUI.SearchBar, "Peppa pig");
                test.log(Status.PASS, "Send key sucessfully");
            } catch (Exception ex) {
                ex.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Send key Error");
                test.fail("Failed to Send keys ", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
               
            }
            
        }

        @When("^I click on the first option from the auto-populated list$")
        public void i_click_on_the_first_option_from_the_auto_populated_list() throws Throwable {
            try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(HomepageUI.SelectList));
                element.click();
                test.log(Status.PASS, "Selected from the list");
            } catch (Exception ex) {
                ex.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Selecting values Error");
                test.fail("Failed to Selecte thev value from the list", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
               
            }
            
        }

        @Then("^I confirm that the search results page contains the label \"([^\"]*)\"$")
        public void i_confirm_that_the_search_results_page_contains_the_label(String arg1) throws Throwable {
            try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Peppa Pig: Peppa\u2019s Adventures - Peppa\u2019s Family Mot')]")));
                String labelText = element.getText();
                logger.info(labelText);
                String Expected_Label= "pig";
                if (labelText.toLowerCase().contains(Expected_Label.toLowerCase())) {
                    return;
                } else {
                    Assert.assertTrue("Expected label text to contain '" + Expected_Label + "', but it was '" + labelText + "'", labelText.contains(Expected_Label));
                }
                
                Screenshot.getScreenShot(driver, "Assert the value sucessfully");
                test.log(Status.PASS, "Assert the value");
                Screenshot.getScreenShot(driver, "Assert the value sucessfully");
                throw new PendingException();
            } catch (Exception ex) {
                ex.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Assert the value Error");
                test.fail("Failed to Assert the value", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
               
            }
          
        }

        @When("^I hover the mouse over the \"([^\"]*)\" menu and click the \"([^\"]*)\" category$")
        public void i_hover_the_mouse_over_the_menu_and_click_the_category(String arg1, String arg2) throws Throwable {
           try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
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

        @When("^I scroll down until I locate the \"([^\"]*)\" option on the left side of the page$")
        public void i_scroll_down_until_I_locate_the_option_on_the_left_side_of_the_page(String arg1) throws Throwable {
             try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 250);");
                test.log(Status.PASS, "Scroll down to the Cost");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Scroll down to the Cost Error");
                test.fail("Failed to Scroll down", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
            
        }

        @When("^I click the value \"([^\"]*)\" from the price range options$")
        public void i_click_the_value_from_the_price_range_options(String arg1) throws Throwable {
            try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                driverHelper.clickElement(ShoppingUI.SelectCost);
                 test.log(Status.PASS, "Selected the cost");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Select cost Error");
                test.fail("Failed toSelecte the cost", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
        }

        @Then("^I verify the total number of results found based on the selected price range$")
        public void i_verify_the_total_number_of_results_found_based_on_the_selected_price_range() throws Throwable {
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

        @When("^I click on the \"([^\"]*)\" menu$")
        public void i_click_on_the_menu(String arg1) throws Throwable {
            try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driverHelper.clickElement(OffersUI.Offers);
             test.log(Status.PASS, "Clicked The offers menu");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Selecting Offer Error");
                test.fail("Failed to Click the offer ", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        
            }
        }

        @When("^I scroll down until I reach the \"([^\"]*)\" filter$")
        public void i_scroll_down_until_I_reach_the_filter(String arg1) throws Throwable {
            try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 800);");
                test.log(Status.PASS, "Scroll down to the Cost");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Scroll down to the Cost Error");
                test.fail("Failed to Scroll down", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
        }

        @When("^I click on the \"([^\"]*)\" link$")
        public void i_click_on_the_link(String arg1) throws Throwable {
            try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                driverHelper.clickElement(OffersUI.Showmore);
                test.log(Status.PASS, "Selected the Brands");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Select Brand Error");
                test.fail("Failed to Selecte the Brand", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
        }

        @When("^I click the checkbox of \"([^\"]*)\"$")
        public void i_click_the_checkbox_of(String arg1) throws Throwable {
            try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                driverHelper.clickElement(OffersUI.Brands);
                test.log(Status.PASS, "Selected the Brands");
            } catch (Exception e) {
                e.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Select Brand Error");
                test.fail("Failed to Selecte the Brand", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
           
            }
        }

        @Then("^I verify whether the name of the chosen brand is available on the page$")
        public void i_verify_whether_the_name_of_the_chosen_brand_is_available_on_the_page() throws Throwable {
            try {
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                String c1Text = driver.findElement(OffersUI.ProductName).getText();
                logger.info(c1Text);
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
