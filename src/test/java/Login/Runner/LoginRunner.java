package Login.Runner;


import io.cucumber.testng.CucumberOptions;
import Tests.TestBase;


@CucumberOptions(features="src/test/java/Login/Feature"
,glue= {"Login/Steps"}
,plugin= {"pretty","html:target/cucumber-html-report"})
public class LoginRunner extends TestBase
{


}

