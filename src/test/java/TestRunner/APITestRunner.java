package TestRunner;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
/*TestRunnerClass*/
/*
  TestRunner to invoke Test Scripts using Tags defined in FeatureFile,
  Define Test Report formats Serenity HTML and JSON formats
  @Author:Azmin Jiyas
  @Version:1.0
  @Date:05-14-2020
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="src/test/resources/features", glue={"APIStepDefinitions"},tags={"@API"}, plugin = { "pretty", "html:target/serenity-reports/API/serenity-html-report", "json:target/serenity-reports/SerenityTestReport.json"})
public class APITestRunner {
}
