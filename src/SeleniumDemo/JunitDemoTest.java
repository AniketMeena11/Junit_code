package SeleniumDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



class JunitDemoTest {
    static WebDriver driver ;
	@BeforeAll
	static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "Location of the driver.. ");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
	}

	@AfterAll
	static void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	void test() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expResult = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";
		String actResult = driver.getTitle();
		
		Assert.assertEquals(actResult,expResult);
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
