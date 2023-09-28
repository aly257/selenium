package tema_curs21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Review extends BaseTest{
	@Test
	public void GiveReview() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement carte = driver.findElement(By.cssSelector("a[href$='the-forest']"));
		carte.click();
		
		WebElement reviewZone = driver.findElement(By.cssSelector(".reviews_tab"));
		reviewZone.click();
		
		WebElement casuta = driver.findElement(By.cssSelector("#wp-comment-cookies-consent"));
		Assert.assertFalse(casuta.isSelected());
		
		WebElement submit = driver.findElement(By.cssSelector("input[name*='submit']"));
			
		casuta.click();
		submit.click();
		
		driver.switchTo().alert().accept();
		
		
	}
	

}
