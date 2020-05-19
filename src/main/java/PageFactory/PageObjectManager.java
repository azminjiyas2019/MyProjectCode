package PageFactory;

import PageObjects.HomePage;
import PageObjects.ProductListing;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;

    private HomePage homePage;
    private ProductListing productListingPage;

    public  PageObjectManager( WebDriver driver){
        this.driver=driver;
    }

    public HomePage getHomePage(){
        return (homePage == null)? homePage=new HomePage(driver):homePage;
    }
    public ProductListing getProductListingPage() {
        return (productListingPage == null) ? productListingPage = new ProductListing(driver) : productListingPage;

    }
}

