package tema_curs18;

import org.testng.annotations.Test;
import utils.BaseTest;
import org.openqa.selenium.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Visibility extends BaseTest {
	@Test
	public void CheckVisibility() {
		WebElement loginButton = driver.findElement(By.cssSelector(".menu_user_login"));
		assertTrue(loginButton.isDisplayed());
		
		WebElement email = driver.findElement(By.cssSelector(".login_field"));
		assertFalse(email.isDisplayed());
		
		WebElement password = driver.findElement(By.cssSelector(".password_field"));
		assertFalse(password.isDisplayed());
		
		loginButton.click();
		
		assertTrue(email.isDisplayed());
		assertTrue(password.isDisplayed());	
	}
}
