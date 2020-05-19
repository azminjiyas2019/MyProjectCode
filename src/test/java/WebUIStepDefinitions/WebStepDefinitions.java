package WebUIStepDefinitions;

import PageFactory.PageObjectManager;
import PageObjects.HomePage;
import PageObjects.ProductListing;
import Utilities.ReadConfigFile;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/*
  StepDefinitions for all Steps Defined in feature file
  @Author:Azmin Jiyas
  @Version:2.0
  @Date:05-14-2020
 */
public class WebStepDefinitions {
    WebDriver driver;
    ReadConfigFile readConfigFile;
    PageObjectManager pageObjectManager;
    HomePage homePage;
    ProductListing productListing;

    @Before
    @Given("^User navigate to application URL$")
    public void User_Navigate_Application() {
        readConfigFile = new ReadConfigFile();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("profile.default_content_setting_values.notifications", 2);

        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(readConfigFile.GetImplicitWait(), TimeUnit.SECONDS);
    }
    @Before
    @When("^User navigate to HomePage$")
    public void Navigate_HomePage() {
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.navigate_To_HomePage();
    }
    @Before
    @Then("^HomePage is Displayed$")
    public void Verify_HomePage(){
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.Validate_HomePage();
    }
    @Test
    @When("^User select \"(.*)\"$")
    public void Navigate_Product_Details() {
        pageObjectManager = new PageObjectManager(driver);
        productListing = pageObjectManager.getProductListingPage();
        productListing.Navigate_Product_Details();
    }

    @Then("^Productdetails Page is Displayed\"(.*)\" and \"(.*)\"$")
    public void Verify_DetailsPage(String Item,String Product){
        pageObjectManager = new PageObjectManager(driver);
        productListing = pageObjectManager.getProductListingPage();
        productListing.Validate_Product_Details(Item,Product);
    }

    @After
    public void setDown() {
        driver.close();
        driver.quit();
    }
}
