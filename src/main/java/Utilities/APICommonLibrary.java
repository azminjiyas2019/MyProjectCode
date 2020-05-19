package Utilities;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

/*
  Common Functions created and this will be called in StepDefinitions
  @Author:Azmin Jiyas
  @Version:3.0
  @Date:05-14-2020
 */
public class APICommonLibrary {

    public static RequestSpecification SetBaseURL()throws Throwable {
        ReadConfigFile readConfigFile;
        readConfigFile = new ReadConfigFile();
        String APIName = readConfigFile.GetBaseURI();
        RestAssured.baseURI = APIName;
        System.out.print("API" + APIName);
        RequestSpecification httprequest = RestAssured.given();
        return httprequest;

    }
    public static int ValidateBaseURI()throws Throwable{
        int statusCode;
        Response response = SetBaseURL().get();
        statusCode = response.getStatusCode();
        return statusCode;
    }

    public Response GetMethod (String endPoint)throws Throwable {
        Response response = SetBaseURL().get(endPoint);
        System.out.print("Endpoint" + endPoint);
        return response;
    }


    public Response PostMethod (String EndPoint)throws Throwable {
        Response response = SetBaseURL().post(EndPoint);
        System.out.print("Endpoint" + EndPoint);
        return response;
    }

}
