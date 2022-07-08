package JUnitDemo;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_DisplayTop5Products {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\SoftwareCenterApplications\\chromedriver\\chromedriver.exe");

		driver = new ChromeDriver(); // new FireFoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// driver.close();
	}

	@Test
	public void testLoginIntoFlipkart() {

		WebElement email = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		email.sendKeys("9094018902");
		WebElement pass = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		pass.sendKeys("Asdf@1234");
		WebElement login = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button"));
		login.click();

		// /html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expResult = "Senthil";
		String actResult = driver
				.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div"))
				.getText();

		System.out.println(expResult + "\n" + actResult);

		Assert.assertEquals(actResult, expResult);

	}

	@Test
	public void searchProduct() {
		driver.findElement(By.name("q")).sendKeys("laptop");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button/svg")).click();

		driver.findElement(By.name("q")).sendKeys(Keys.ARROW_DOWN);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	driver.findElement(By.name("q")).sendKeys(Keys.ARROW_DOWN);

//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Test
	public void displayProducts(){
		
		for(int i=3; i<=7; i++) {
		
			String productName = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[" + i + "]/div/div/div/a/div[2]/div[1]/div[1]")).getText();
			String productPrice = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[" + i + "]/div/div/div/a/div[2]/div[2]/div[1]/div[1]/div")).getText();
		
			System.out.println(productName + "\t" + productPrice);
		}
	}
	

}
