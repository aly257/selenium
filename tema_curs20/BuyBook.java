package tema_curs20;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import utils.BaseTest;

public class BuyBook extends BaseTest{
	@Test
	public void CheckBuyBook() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		
		WebElement searchButton = driver.findElement(By.cssSelector(".search_form"));
		searchButton.click();
		
		WebElement searchField = driver.findElement(By.cssSelector(".search_field"));
		searchField.sendKeys("The story about me");
		
		WebElement searchMoreButton = driver.findElement(By.cssSelector(".search_more"));
		searchMoreButton.click();
		
		WebElement moreButton = driver.findElement(By.cssSelector(".viewmore_button"));
						
		while(driver.findElements(By.cssSelector("a[href$='https://keybooks.ro/shop/the-story-about-me/']")).size() < 1) moreButton.click();

		WebElement carteLocator = driver.findElement(By.cssSelector("a[href$='https://keybooks.ro/shop/the-story-about-me/']"));
		
		try {
		     carteLocator.click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", carteLocator);
		  }
		
		assertEquals("https://keybooks.ro/shop/the-story-about-me/", driver.getCurrentUrl());
		
		WebElement addToCartButton = driver.findElement(By.cssSelector(".single_add_to_cart_button"));
		addToCartButton.click();
		
		Boolean mesaj = driver.findElement(By.cssSelector(".woocommerce-message")).isDisplayed();
		assertTrue(mesaj);
		
		WebElement viewCart = driver.findElement(By.cssSelector("a[href*='https://keybooks.ro/cart/']"));
		viewCart.click();
		
		assertEquals("https://keybooks.ro/cart/", driver.getCurrentUrl());
	}
	
	@Test(dependsOnMethods = "CheckBuyBook")
	public void FinalisePurchase() {
		
		WebElement increment= driver.findElement(By.cssSelector(".q_inc"));
		increment.click();
		
		WebElement updateCart = driver.findElement(By.name("update_cart"));
		updateCart.click();
		
		Boolean mesaj = driver.findElement(By.cssSelector(".woocommerce-message")).isDisplayed();
		assertTrue(mesaj);
		
		WebElement purchase = driver.findElement(By.cssSelector(".checkout-button"));
		try {
			purchase.click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", purchase);
		  }
		
		assertEquals("https://keybooks.ro/checkout/", driver.getCurrentUrl());
		
		String details = driver.findElement(By.cssSelector("div.woocommerce-billing-fields>h3")).getText();
		details.equalsIgnoreCase("Biling details");
		
		String informations = driver.findElement(By.cssSelector("div.woocommerce-additional-fields>h3")).getText();
		informations.equalsIgnoreCase("Additional information");		
	}
}
