package curs16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium {
	
	
	@Test
	public void testOpenBrowser() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://keybooks.ro/");
	}
	
	
	
}
