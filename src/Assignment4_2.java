
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4_2 {

	public static void main(String[] args) throws InterruptedException, AWTException {

//		1. Login to gmail using credentials: my.selenium.user@gmail.com/selenium@123
		WebDriver driver = new FirefoxDriver();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.name("Email")).click();
		driver.findElement(By.name("Email")).sendKeys("greenkrate.test8@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.xpath(".//*[@id='Passwd']")).click();
		driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("@Four123");
		driver.findElement(By.id("signIn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gb_Nb")));
		
		
//		2. Click on 'Compose' link
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		
//		3. Click on camera icon
		driver.findElement(By.xpath("//table[@class='IZ']/descendant::td[4]/div/div[3]/div/div")).click();
		
//		4. Click on 'Choose photos to upload'
		
		WebElement iFrame = driver.findElement(By.className("KA-JQ"));
		driver.switchTo().frame(iFrame);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Upload Photos']")));
		driver.findElement(By.xpath("//div[text()='Choose photos to upload']")).click();
		
//		5. On pop up window, enter file path of any .jpg or .gif file
		String s= "D:\\backup_nirali\\HTML_Assignment\\logo.png";
		
		Thread.sleep(5000);
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.mouseMove(203, 637);
		Thread.sleep(3000);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(3000);
		StringSelection selection = new StringSelection(s);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(3000);
				
//		6. Click on 'Open' button
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
//		7. Verify that image is displayed in email body
		Thread.sleep(10000);
		WebElement imgEl = driver.findElement(By.xpath("//div[contains(@class,'Am Al editable')]/descendant::img"));
//		WebElement imgEl = driver.findElement(By.tagName("img"));
		
		if(imgEl.isDisplayed())
		{
			System.out.println("Verified. Image is displayed");
		}
		else
			System.out.println("Image does not exist");
		
		
//		8. Get size of uploaded image using selenium
//		File file =new File(s);
//		double bytes = file.length();
//		System.out.println("size of image "+ bytes/1000 +"Kb");
		System.out.println("Original size of image : "+ imgEl.getSize());
		
//		9. Click on image in email body
		Thread.sleep(3000);
		imgEl.click();
		
		
//		10. Click on 'Small' link
		driver.findElement(By.xpath("//span[text()='Small']")).click();
		
//		11. Get current size of image & verify that it is lesser than previous size
		System.out.println("Small size of image : "+ imgEl.getSize());
		
//		12. Click on image
		Thread.sleep(3000);
		imgEl.click();
		
//		13. Click on link 'Remove'
		driver.findElement(By.id("resize-remove-image")).click();
		
//		14. Verify that image gets removed from email body
//		
//		if(imgEl.isDisplayed())
//		{
//			System.out.println("Verified. Image is removed");
//		}
//		else
//			System.out.println("Image is not removed");
//		
		driver.close();
	}

}
