package MouseAndKeyboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseEvent_OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String currDir = System.getProperty("user.dir");
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", currDir + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Open toosqa.com
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");

		//logging into the webpage
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("Admin ");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")));

		// without using Mouse Event code
//		driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b")).click();
//		driver.findElement(By.id("menu_admin_Job")).click();
//		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();

		WebElement adminMenu = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
		WebElement jobMenu = driver.findElement(By.xpath("//*[@id=\"menu_admin_Job\"]"));
		WebElement jobTitleMenu = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewJobTitleList\"]"));

		Actions acts = new Actions(driver);
		
	
		acts.moveToElement(adminMenu)
		.pause(2000)
		.moveToElement(jobMenu)
		.pause(2000)
		.moveToElement(jobTitleMenu)
		.pause(2000)
		.click()
		.build()
		.perform();
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAdd")));

		System.out.println("The first Job Title is : "
				+ driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody" + "/tr[1]/td[2]/a")).getText());
	}

}
