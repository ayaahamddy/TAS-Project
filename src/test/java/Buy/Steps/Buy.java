package Buy.Steps;

import Pages.loginPage;
import Tests.TestBase;
import Util.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Buy extends TestBase {

	Pages.Buy BuyObject;
	Pages.loginPage LoginObject;

	@Given("the User open the saucedemo website link")
	public void the_User_open_the_saucedemo_Link() throws InterruptedException {
		BuyObject = new Pages.Buy(driver);
	}

	@When("Read the data from {string} and {int}")
	public void Read_the_data_from_and(String sheetName, int RowNumberLogin) throws IOException, InvalidFormatException, InterruptedException {
		LoginObject = new Pages.loginPage(driver);
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData("D:\\Task\\Task Ejada\\Automation Task\\Scenarios\\File data\\Data.xlsx", sheetName);
		String email = testdata.get(RowNumberLogin).get("email");
		String pass = testdata.get(RowNumberLogin).get("pass");
		LoginObject.Login(email, pass);
	}

	@And("the user Assert That the HomePage is displayed")
	public void the_user_Assert_That_the_HomePage_is_displayed() throws InterruptedException {
		BuyObject = new Pages.Buy(driver);
		BuyObject.AssertHomepage();

	}

	@And("Buy The Item")
	public void Buy_The_Item() throws InterruptedException {
		BuyObject = new Pages.Buy(driver);
		BuyObject.Filter(driver);

	}

	@And("Navigate to cart")
	public void Navigate_to_cart() throws InterruptedException {
		BuyObject = new Pages.Buy(driver);
		BuyObject.Cart();

	}

	@And("Check out your order")
	public void Check_out_your_order() throws InterruptedException {
		BuyObject = new Pages.Buy(driver);
		BuyObject.Checkout(driver);

	}

	@And("Fill the form {string} and {int}")
	public void Fill_the_form_and(String sheetData, int RowNumberData) throws IOException, InvalidFormatException, InterruptedException {
		BuyObject = new Pages.Buy(driver);
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData("D:\\Task\\Task Ejada\\Automation Task\\Scenarios\\File data\\Data.xlsx", sheetData);
		String firstName = testdata.get(RowNumberData).get("FirstName");
		String lastName = testdata.get(RowNumberData).get("LastName");
		String postalcode = testdata.get(RowNumberData).get("Postalcode");
		BuyObject.FillTheform(driver,firstName, lastName, postalcode);
	}

	@And("Check the Calculations")
	public void Check_the_Calculations() throws InterruptedException {
		BuyObject = new Pages.Buy(driver);
		BuyObject.Overview(driver);
	}
	@And("Done")
	public void Done() throws InterruptedException {
		BuyObject = new Pages.Buy(driver);
		BuyObject.Done(driver);
	}
}
