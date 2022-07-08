package Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PromptAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//	System.setProperty("webdriver.gekco.driver",currDir + "\\Drivers\\geckodriver.exe");
//	WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");

		Thread.sleep(3000);

		WebElement promptAlertButton = driver.findElement(By.id("promtButton"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", promptAlertButton);

		Thread.sleep(3000);

		promptAlertButton.click();

		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		alert.sendKeys("Selenium for Infosys");

		Thread.sleep(3000);

		alert.accept();

	}

}
