package Utilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
  Function to READ propeties from config.properties files
  Parameterd :Base URI,Test Environment ,Platform , Authentication Key etc
  @Author:Azmin Jiyas
  @Version:1.0
  @Date:03-15-2020
 */
public class ReadConfigFile {


    private Properties properties;
    private final String PROPERTYPATH = "src/main/resources/config.properties";
    public ReadConfigFile(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(PROPERTYPATH));
            properties= new Properties();
            try{
                properties.load(reader);

            }catch(IOException e){
                e.printStackTrace();
            }

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration properties not found at path" + PROPERTYPATH);
        }
    }
    public String GetBaseURI(){
        String baseAPI=properties.getProperty("baseAPI");
        if (baseAPI!=null)return baseAPI;
        else throw new RuntimeException("Base URI is not specified in config file \"+PROPERTYPATH");
    }
    public String GetApplicationURL(){
        String applicationURL=properties.getProperty("applicationURL");
        if (applicationURL!=null)return applicationURL;
        else throw new RuntimeException("Application URL is not specified  found in path"+PROPERTYPATH);
    }
    public String GetDriverPath(){
        String driverPath=properties.getProperty("driverPath");
        if (driverPath!=null)return driverPath;
        else throw new RuntimeException("Driver path property is not  specified  found in path"+PROPERTYPATH);
    }
    public Long GetImplicitWait(){
        String driverWait;
        driverWait=  properties.getProperty("driverWait");
        if (driverWait != null) return Long.parseLong(driverWait);
        else throw new RuntimeException("Wait property is not specified  found in path"+PROPERTYPATH);
    }
}
