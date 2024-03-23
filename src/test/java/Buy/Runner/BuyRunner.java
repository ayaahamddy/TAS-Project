package Buy.Runner;


import io.cucumber.testng.CucumberOptions;
import Tests.TestBase;


@CucumberOptions(features="src/test/java/Buy/Feature"
,glue= {"Buy/Steps"}
,plugin= {"pretty","html:target/cucumber-html-report"})
public class BuyRunner extends TestBase
{


}

