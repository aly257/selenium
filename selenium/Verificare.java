package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Verificare {
	
	@Test
	public void Testare() {
		System.out.println("check");
		
		WebDriver Driver = new ChromeDriver();
		Driver.get("https://keybooks.ro/");
	}
	

}
