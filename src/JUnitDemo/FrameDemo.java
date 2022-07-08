package JUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class FrameDemo {
    static  WebDriver driver ;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SoftwareCenterApplications\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver(); // new FireFoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://docs.oracle.com/javase/7/docs/api/");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
//		driver.close();
		
	}

	@Test
	void test() {

		/************
		 * 3 ways to locate a iFrame
		 * By Index
		 * By Name or ID
		 * By WebElement
		 * 
		 */
		
		System.out.println("Currently Focused Frame: " + driver.findElement(By.tagName("frame")).getAttribute("src"));
		
		//driver.switchTo().frame(2);
		driver.switchTo().frame("classFrame");
		
		System.out.println("Msg in Overview Frame: " + driver.findElement(By.xpath("/html/body/div[3]/h1")).getText());
	

	}

}
