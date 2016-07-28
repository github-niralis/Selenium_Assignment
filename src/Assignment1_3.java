import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.Assert;

public class Assignment1_3 {

	public static void main(String[] args) throws InterruptedException {

		//1. Go to Afour site http://www.afourtech.com
		String service = "D:\\nirali_workplace\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", service);
		InternetExplorerDriver  driver = new InternetExplorerDriver();
		driver.get("http://www.afourtech.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//2. Click on 'Desk' tab

		//driver.findElement(By.id("menu-item-1494")).click();
		driver.findElement(By.linkText("Desk")).click();
		Thread.sleep(5000);
		
//4. Click on 'Whitepapers' link
		//driver.findElement(By.id("menu-item-1240")).click();
		driver.findElement(By.linkText("Whitepapers")).click();
		Thread.sleep(5000);
		
//5. Verify page header 'Archive for category: Whitepapers' is present on the page
		Assert.assertTrue(driver.getTitle().contains("Whitepapers"), "Test FAILED");
		
		driver.close();

	}

}
