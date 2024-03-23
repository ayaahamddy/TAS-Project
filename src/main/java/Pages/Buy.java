package Pages;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Buy extends pageBase {
	 

    public Buy(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement Homepage;
    @FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    WebElement Filter;
    @FindBy (className = "shopping_cart_link")
    WebElement Cartbutton;

    @FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement Cartpage;
    @FindBy (id = "checkout")
    WebElement Checkoutbutton;

    @FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement Checkoutpage;

    @FindBy (id = "first-name")
    WebElement Firstname;

    @FindBy (id = "last-name")
    WebElement Lastname;

    @FindBy (id = "postal-code")
    WebElement Pastolcode;
  
    @FindBy (id = "continue")
    WebElement continueButton;

    @FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement Overviewpage;

    @FindBy (xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")
    WebElement Total;

    @FindBy (id = "finish")
    WebElement finishButton;


    @FindBy (className = "complete-header")
    WebElement Thankyou;
    @FindBy (className = "complete-text")
    WebElement dispatched;


    public void AssertHomepage() throws InterruptedException {

        Thread.sleep(1000);
        String actualTitle = Homepage.getText();
        String expectedTitle = "Products";
        assertEquals(expectedTitle,actualTitle);

    }
    public void Filter(WebDriver driver) throws InterruptedException {
        Select options = new Select(Filter);
        Thread.sleep(1000);
        options.selectByVisibleText("Price (high to low)");
   /*
        // The System can't find the class name and it's correct
        List<WebElement> elements = driver.findElements(By.className("btn btn_primary btn_small btn_inventory "));
            Thread.sleep(1000);
            elements.get(0).click();
            Thread.sleep(1000);
            elements.get(1).click();
        */


        // So i using the Button tag
       List<WebElement> elements = driver.findElements(By.tagName("button"));
            Thread.sleep(1000);
            elements.get(2).click();
            Thread.sleep(1000);
            elements.get(3).click();


       }


    public void Cart () throws InterruptedException {
        Thread.sleep(1000);
        clickButton(Cartbutton);
        Thread.sleep(1000);
        String actualTitle = Cartpage.getText();
        String expectedTitle = "Your Cart";
        assertEquals(expectedTitle,actualTitle);
    }

    public void Checkout (WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        ScrollToPageEnd(driver);
        Thread.sleep(1000);
        clickButton(Checkoutbutton);
        String actualTitle = Checkoutpage.getText();
        String expectedTitle = "Checkout: Your Information";
        assertEquals(expectedTitle,actualTitle);
    }
    public void FillTheform(WebDriver driver,String firstname,String lastname, String pastolcode) throws InterruptedException {

        Thread.sleep(1000);
        setTextElementText(Firstname,firstname);
        Thread.sleep(1000);
        setTextElementText(Lastname,lastname);
        Thread.sleep(1000);
        setTextElementText(Pastolcode,pastolcode);
        ScrollToPageEnd(driver);
        Thread.sleep(1000);
        clickButton(continueButton);

    }

    public void Overview (WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        ScrollToPageEnd(driver);
        Thread.sleep(1000);
        // check the Overview page
        String actualTitle = Overviewpage.getText();
        String expectedTitle = "Checkout: Overview";
        assertEquals(expectedTitle,actualTitle);

       // check the total before taxes
        List<WebElement> elements = driver.findElements(By.className("inventory_item_price"));
        double totalamount = 0;
        for (WebElement element : elements) {
            String item = element.getText().substring(1);
            double itemamount = Double.parseDouble(item);
            totalamount += itemamount;
        }

        String Expectedresult = "Item total: $"+totalamount;
        String Actualresult = Total.getText();
       assertEquals(Expectedresult,Actualresult);

       // check the url
      String Actualurl = driver.getCurrentUrl();
      String Expectedurl = "https://www.saucedemo.com/checkout-step-two.html";
        assertEquals(Expectedurl,Actualurl);

    }
    public void Done (WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        clickButton(finishButton);
        ScrollToPageEnd(driver);
        String actualTitle = Thankyou.getText();
        String expectedTitle = "Thank you for your order!";
        assertEquals(expectedTitle,actualTitle);

        String actualTitle2 = dispatched.getText();
        String expectedTitle2 = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        assertEquals(expectedTitle2,actualTitle2);
    }


}
