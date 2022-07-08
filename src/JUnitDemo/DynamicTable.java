package JUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class DynamicTable {
	static  WebDriver driver ;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String driverPath = ".\\Drivers";
		System.setProperty("webdriver.chrome.driver",driverPath + "\\chromedriver.exe");

		driver = new ChromeDriver(); // new FireFoxDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
	
		// to fetch all the company names
		
		
		
		
	

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		
		// to fetch all the company names
		List<WebElement> totalCompanies = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));

		System.out.println("Total No of Companies: " + totalCompanies.size());
		
		
		for (WebElement obj : totalCompanies) {
		
			System.out.println(obj.getText());
	}

	}
}
