package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ProductListing {
    WebDriver driver;
    public ProductListing(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using= "")
    private WebElement allCategories;
    @FindBy(how = How.LINK_TEXT, using = "")
    private WebElement Sample;
    @FindBy(how = How.XPATH, using = "//*[@class='productDetailsPanel']/h1")
    private WebElement ProductDetailsPage;

    public void Navigate_Product_Details() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(allCategories));
        allCategories.click();
        wait.until(ExpectedConditions.elementToBeClickable(Sample));
        Sample.click();
    }

    /*
    Click on each product and validate product details page
     */
    public void Validate_Product_Details(String item,String Product ) {

        driver.findElement(By.xpath("//a[contains(@class, 'link-search-productLink"+item+"')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ProductDetailsPage));
        String ProductDetail = ProductDetailsPage.getText();
        Assert.assertEquals(ProductDetail,Product);
    }


}
