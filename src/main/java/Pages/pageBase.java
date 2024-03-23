package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class pageBase {
	 public pageBase(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    public void clickButton(WebElement button) {
	        button.click();
	    }
	    // set texts function
	    public void setTextElementText(WebElement textElement, String value) {
	        textElement.sendKeys(value);
	    }
	    
	    public void ScrollToPageEnd(WebDriver driver) {
	    	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);


	    }
}
