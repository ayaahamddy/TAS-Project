package Login.Steps;

import Pages.loginPage;
import Tests.TestBase;
import Util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class login extends TestBase {

	Pages.loginPage LoginObject;

	@Given("the User open the saucedemo website link")
	public void the_User_open_the_saucedemo_Link() throws InterruptedException {
		LoginObject = new loginPage(driver);
	}

	@When("Read the data from {string} and {int}")
	public void Read_the_data_from_and (String sheetName , int RowNumber) throws IOException, InvalidFormatException, InterruptedException {
		Util.ExcelReader reader = new ExcelReader() ;
		List<Map<String,String>> testdata =  reader.getData("D:\\Task\\Task Ejada\\Automation Task\\Scenarios\\File data\\Data.xlsx",sheetName);
	   String email =  testdata.get(RowNumber).get("email");
	   String pass  =  testdata.get(RowNumber).get("pass");
		LoginObject.Login(email, pass);
	}


	@Then("the user Assert That from {string} and {int} the Result is displayed")
	public void the_user_Assert_Tha_from_and_the_Result_is_displayed (String sheetName , int RowNumber) throws InterruptedException, IOException, InvalidFormatException {
		Util.ExcelReader reader = new ExcelReader() ;
		List<Map<String,String>> testdata =  reader.getData("D:\\Task\\Task Ejada\\Automation Task\\Scenarios\\File data\\Data.xlsx",sheetName);
		String ExpectedResult =  testdata.get(RowNumber).get("Expected Result");
		LoginObject.AssertData(TestBase.driver,ExpectedResult);

	}
}
