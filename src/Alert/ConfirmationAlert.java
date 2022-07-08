package Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmationAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String currDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",currDir + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("confirmButton")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		//alert.accept();
		System.out.println(driver.findElement(By.id("confirmResult")).getText());

	}

}
