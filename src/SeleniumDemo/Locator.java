package SeleniumDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Locator {
	 static WebDriver driver ;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "Location of the driver ");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/index.php?s=1/");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	

	@Test
	void validatelogin() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.findElement(By.id("user")).sendKeys("aniketvds4");
		driver.findElement(By.id("pass")).sendKeys("passward");
		driver.findElement(By.className("btn_log")).click();
		
	}

}
