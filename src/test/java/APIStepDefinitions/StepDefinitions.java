package APIStepDefinitions;
import Utilities.APICommonLibrary;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import cucumber.api.java.en.Given;
import org.junit.Assert;
/*
  StepDefinitions for all Steps Defined in feature file Cart.Feature
  @Author:Azmin Jiyas
  @Version:2.0
  @Date:05-15-2020
 */
public class StepDefinitions {
    Response response;
    APICommonLibrary API = new APICommonLibrary();

    @Given("^Base URI is up and running$")
    public void Validate_BaseURI() throws Throwable{
        int responseCode;
        responseCode = API.ValidateBaseURI();
        Assert.assertEquals(200, responseCode);
    }
    @When("^I invoke endpoint \"(.*)\"$")
    public void Accsess_Endpoint(String EndpointName)throws Throwable{
        response = API.GetMethod(EndpointName);

    }

    @Then("^I get response status code  \"(.*)\"$")
    public void Validate_APIResponse(int expectedResponse)throws Throwable {
        int actualResponseCode=response.getStatusCode();
        Assert.assertEquals(actualResponseCode,expectedResponse);

    }
    @When("^I create a new Item \"(.*)\"$")
    public void Create_Item(String endPoint) throws Throwable{
        response = API.PostMethod(endPoint);

    }
    @Then ("^I get response status code for carts\"(.*)\"$")
    public void Validate_New_Item(int  expectedResponse) throws Throwable{
        int actualResponseCode;
        actualResponseCode=response.getStatusCode();
        Assert.assertEquals(actualResponseCode,expectedResponse);
    }

}
