package curs21;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ImplictWaitExample extends BaseTest{

	
	@Test
	public void implcityWaitTest() throws InterruptedException {
		//implict wait --asteapta pentru numarul de secunde dat, ca elementul sa apara in DOM
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		driver.findElement(By.cssSelector("div[id='start']>button")).click();
		//Thread.sleep(10000);//bad practice
		
		WebElement finish = driver.findElement(By.cssSelector("div[id='finish']>h4"));
		assertEquals(finish.getText(), "Hello World!");
		
	}
	
}
