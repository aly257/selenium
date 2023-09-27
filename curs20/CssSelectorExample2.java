package curs20;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectorExample2 extends BaseTest{

	
	//@Test
	public void cssSelectorTest() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//Home page book categories menu entries
		//first-of-type ---> New Releases
		WebElement newReleases =  driver.findElement
				(By.cssSelector("li[class*='sc_tabs_title']:first-of-type"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: orange;border:4px solid blue')", newReleases);

		//nth-of-type --> Coming soon
		WebElement comingSoon =  driver.findElement
				(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(2)"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:red; border:4px solid black')", comingSoon);
		
		//nth-of-type --> Best Sellers
		WebElement bestSellers =  driver.findElement
				(By.cssSelector("li[class*='sc_tabs_title']:nth-of-type(3)"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:red; border:4px solid black')", bestSellers);
		
		//last-of-type --> Award Winners
		WebElement awardWinners =  driver.findElement
				(By.cssSelector("li[class*='sc_tabs_title']:last-of-type"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:purple; border:4px solid yellow')", awardWinners);
	}
	
	//@Test
	public void cssSelectorsTest2() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//selected doar elementul care are attributul ('aria-selected='true'')
		WebElement menuEntry = driver.findElement(By.cssSelector("li[class*='sc_tabs_title'][aria-selected='true']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background:purple; border:4px solid yellow')", menuEntry);
		
		//selectez tot in afara de elementul care are attributul ('aria-selected='true'')
		//NOT
		
		List<WebElement> menuEntries =  driver.findElements(
				By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
		
		for(WebElement element : menuEntries) {
			
			jse.executeScript("arguments[0].setAttribute"
					+ "('style', 'background:green; border:4px solid blue')", element);
		}
	}
	@Test
	public void cssSelectorTest3() throws InterruptedException {
		
		//direct child  >
		//li[class='menu_user_login']>a[class*='popup_link']
		
		//nephew  caracterul spatiu ' '
		//ul[class*='menu_user_nav'] a[class*='popup_link']
		
		WebElement loginMenu =  driver.findElement
				(By.cssSelector("ul[class*='menu_user_nav'] a[class*='popup_link']"));
		loginMenu.click();
		Thread.sleep(3000);
		
		//logical AND --adica tagname[atribut=value][atribut=value]
		WebElement username = driver.findElement
				(By.cssSelector("input[id='log'][name='log']"));
		username.sendKeys("TestUser");
		
		//logical OR --adica tagname[atribut=value],[atribut=value]
		WebElement password =  driver.findElement
				(By.cssSelector("input[type='password'],[name='pwd']"));
		password.sendKeys("TestUser");
		
		
	}
		/*
		 * 
		 * List<WebElement> categoryTabs = driver.findElements(By.cssSelector("sc_tabs_title"));
		 * 
		 * WebElement theForest = driver.findElement(By.cssSelector("div[aria-hidden ='false'] a[href='the-forest']"));
		 * for(WebElement element : categoryTabs){
		 * 	
		 * 	element.click();
		 *  theForest.isDisplayed();
		 *  	
		 *  	if(i == categoryTabs.lenght()-1 ){
		 *  		theForest.click()
		 *}
		 *  
		 *  	if(element.getText(),equals('award winners'){
		 *  		theForest.click()
		 *  }
		 *   
		 * }
		 * 
		 * theForest.click();
		 * ---assert
		 * 
		 * 
		 */
		
		
		
	}
	
	
