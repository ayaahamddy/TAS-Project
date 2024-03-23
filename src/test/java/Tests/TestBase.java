package Tests;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class TestBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;

	@BeforeTest
	public void StartDriver() throws IOException {

		FileInputStream fis = new FileInputStream("D:\\Task\\Task Ejada\\Automation Task\\Scenarios\\src\\test\\java\\Tests\\Browser.properties");
		Properties p = new Properties();
		p.load(fis);
		String BrowserRunner = p.getProperty("Browser");
		if (BrowserRunner.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);

		} else if (BrowserRunner.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			ChromeOptions options = new ChromeOptions();
			driver = new FirefoxDriver(options);

		}
		else
			System. out. println("you doesn't choose your Browser Right");

	}

	@BeforeMethod()
	public void Navigation() {
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.navigate().refresh();

	}

	@AfterTest
	public void stopDriver() {
		 driver.quit();

	}

}
