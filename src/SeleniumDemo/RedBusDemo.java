package SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBusDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		System.setProperty("webdriver.chrome.driver", "location of the driver ");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		try {
			Thread.sleep(4000);//In millisecond 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expResult = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";

		String actResult = driver.getTitle();
		
	

		if (actResult.equals(expResult))
			System.out.println("Passed");
		else
			System.out.println("Failed");


		//driver.close(); // current browser close
		
		driver.quit(); // all the browser windows
	}

}
