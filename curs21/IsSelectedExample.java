package curs21;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class IsSelectedExample extends BaseTest{
	
	@Test
	public void isSelectedTest() throws InterruptedException {
		
		/*
		 * element is an input element with a type attribute in the Checkbox- or Radio Button state
		 * The result of element’s checkedness.
		 */
		
		driver.findElement(By.cssSelector("li>a[class*='popup_link']")).click();
		
		//<input type="checkbox" value="forever" id="rememberme" name="rememberme">
		//isSelected() functioneaza doar pe elementele care au atributul 
		//type="checkbox"
		//sau
		//type="radio-button"
		WebElement rememberMe = driver.findElement(By.cssSelector("li input[id='rememberme']"));
		System.out.println("Before click :" +rememberMe.isSelected());
		
		Thread.sleep(3000);
		
		rememberMe.click();
		System.out.println("After click :" +rememberMe.isSelected());
		assertTrue(rememberMe.isSelected());

		WebElement usernameField = driver.findElement(By.cssSelector("li input[id='log']"));
		usernameField.click();
		Thread.sleep(3000);
		System.out.println("Username after click :" +usernameField.isSelected());

		
		
	}
	
	

}
