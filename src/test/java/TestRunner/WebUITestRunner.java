package TestRunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import WebUIStepDefinitions.WebStepDefinitions;
/*TestRunnerClass*/
/*
  TestRunner to invoke Test Scripts using Tags defined in FeatureFile,Functional TestCases
  Define Test Report formats Serenity HTML and JSON formats
  @Author:Azmin Jiyas
  @Version:1.0
  @Date:05-14-2020
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue ={"WebUIStepDefinitions"},tags = { "@Functional" }, plugin = { "pretty", "html:target/serenity-reports/serenity-html-report", "json:target/serenity-reports/SerenityTestReport.json" })
public class WebUITestRunner extends WebStepDefinitions {

}