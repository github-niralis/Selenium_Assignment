import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Assignment1_1 {

	public static void main(String[] args) throws InterruptedException {

//1. Go to Afour site http://www.afourtech.com
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.afourtech.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//2. Click on 'Desk' tab
		driver.findElement(By.id("menu-item-1494")).click();
		Thread.sleep(5000);
//4. Click on 'Whitepapers' link
		driver.findElement(By.id("menu-item-1240")).click();
		Thread.sleep(5000);
		
//5. Verify page header 'Archive for category: Whitepapers' is present on the page
		Assert.assertTrue(driver.getTitle().contains("Whitepapers"), "Test FAILED");
		
		driver.close();
	}

}
