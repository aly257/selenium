package tema_curs20;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import utils.BaseTest;

public class BuyBook extends BaseTest{
	
	@Test
	public void CheckBuyBook() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement searchButton = driver.findElement(By.cssSelector());
		searchButton.click();
		
		
	}

}
