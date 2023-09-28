package tema_curs19;

import utils.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.*;

public class BookCategory extends BaseTest {
	@Test
	public void CheckBookCategory() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement carte = driver.findElement(By.xpath("//a[@href='the-forest']"));
		List<WebElement> booksCategories =  driver.findElements(By.cssSelector(".sc_tabs_title"));
		
		for(WebElement categorie: booksCategories) {
			categorie.click();
			
			assertTrue(carte.isDisplayed());
		}
		
		carte.click();
		assertEquals("https://keybooks.ro/shop/the-forest/", driver.getCurrentUrl());
	}

}
