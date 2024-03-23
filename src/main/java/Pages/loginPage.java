package Pages;

import org.apache.poi.ss.formula.functions.IfFunc;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class loginPage extends pageBase {
	
    public loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement Email;
    @FindBy (id = "password")
    WebElement Password;
    @FindBy (id = "login-button")
    WebElement Login;

    @FindBy (xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    WebElement Result;

    public void Login(String email,String pass) throws InterruptedException {

        //Send keys

        setTextElementText(Email,email);
        Thread.sleep(500);
        setTextElementText(Password,pass);
        Thread.sleep(500);
        //Login
        clickButton(Login);
    }


    public void AssertData(WebDriver driver,String ExpectedResult)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualTitle = Result.getText();
        assertEquals(ExpectedResult, actualTitle);


    }

}
