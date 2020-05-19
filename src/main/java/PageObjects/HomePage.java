package PageObjects;

import Utilities.ReadConfigFile;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import static org.testng.AssertJUnit.assertTrue;

public class HomePage {
    WebDriver driver;
    Utilities.ReadConfigFile ReadConfigFile;


    public  HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        ReadConfigFile= new ReadConfigFile();

    }
    @FindBy(how = How.ID, using = "")
    private WebElement frame;
    @FindBy(how = How.XPATH, using = "")
    private WebElement dialog_box;

    @FindBy(how = How.XPATH, using =  "")
    private WebElement Logo;
    public void navigate_To_HomePage() {
        driver.get(ReadConfigFile.GetApplicationURL());
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(dialog_box));
        dialog_box.click();
    }
    public void Validate_HomePage() {
        assertTrue(Logo.isDisplayed());
    }

}
