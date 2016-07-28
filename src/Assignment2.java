import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {

//		1. Launch site http://gmail.com on any browser
		WebDriver driver = new FirefoxDriver();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		2. Enter Email id: my.selenium.user@gmail.com
		driver.findElement(By.name("Email")).click();
		driver.findElement(By.name("Email")).sendKeys("greenkrtae.test9@gmail.com");
		
//		3. Click on 'Next' button
		driver.findElement(By.id("next")).click();
		
//		4. Enter Password: selenium@123
		driver.findElement(By.xpath(".//*[@id='Passwd']")).click();
		driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("@four123");
		
//		5. Click on 'Sign In' button
		driver.findElement(By.id("signIn")).click();
		
//		6. Verify page title contains 'Inbox' & email id of the logged in user
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gb_Nb")));
		
		Assert.assertEquals(driver.getTitle(), "Inbox - greenkrtae.test9@gmail.com - Gmail");
		
//		7. Click on 'COMPOSE' button
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		
//		8. Enter To Address: my.selenium.user@gmail.com
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("greenkrtae.test9@gmail.com");
		
//		9. Give Subject like YourName_Test1 (e.g. Vipul_Test1)-
		driver.findElement(By.cssSelector(".aoT")).click();
		driver.findElement(By.cssSelector(".aoT")).sendKeys("Test mail-1");
		
//		10. Click on Send button
		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
		
		Thread.sleep(5000);
		
//		11. Verify message on the page 'Your message has been sent.'
		if (driver.getPageSource().contains("Your message has been sent."))
		{
			System.out.println("Test-1 message sent successfully");
		}
		else
			System.out.println("message failed to send");
		Thread.sleep(5000);
		
//		12. Click on 'View Message' link
		driver.findElement(By.id("link_vsm")).click();
		
//		13. Verify that search textbox contains string 'in:sent' & the mail subject contains the specified subject string.
		if ((driver.findElement(By.className("hP")).getText().equalsIgnoreCase("Test mail-1")))
			{
				System.out.println("verified search box and subject -test1");
			}
		else
			System.out.println("search box and subject are different");
		
//		14. Follow steps from Step#7 till Step#13 & send 3 more emails to same email id with Subjects like 'YourName_Test2','YourName_Test3' & 'YourName_Test4'
		//test2 mail
		
		driver.findElement(By.linkText("Inbox")).click();
		
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();

		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("greenkrtae.test9@gmail.com");

		driver.findElement(By.cssSelector(".aoT")).click();

		driver.findElement(By.cssSelector(".aoT")).sendKeys("Test mail-2");

		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
		
		Thread.sleep(3000);

		if (driver.getPageSource().contains("Your message has been sent."))
		{
			System.out.println(" Test-2 message sent successfully");
		}
		else
			System.out.println("message failed to send");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("link_vsm")).click();

		if (driver.findElement(By.className("hP")).getText().equalsIgnoreCase("Test mail-2"))
		{
			System.out.println("verified search box and subject -test2");
		}
		else
			System.out.println("search box and subject are different");
		
	//test3 mail
		driver.findElement(By.linkText("Inbox")).click();
		
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();

		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("greenkrtae.test9@gmail.com");

		driver.findElement(By.cssSelector(".aoT")).click();

		driver.findElement(By.cssSelector(".aoT")).sendKeys("Test mail-3");

		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
		
		Thread.sleep(3000);

		if (driver.getPageSource().contains("Your message has been sent."))
		{
			System.out.println("Test-3 message sent successfully");
		}
		else
			System.out.println("message failed to send");
		
		Thread.sleep(3000);

		driver.findElement(By.id("link_vsm")).click();

		if (driver.findElement(By.className("hP")).getText().equalsIgnoreCase("Test mail-3"))
		{
			System.out.println("verified search box and subject -test3");
		}
		else
			System.out.println("search box and subject are different");
		
		//test4 mail
		driver.findElement(By.linkText("Inbox")).click();
		
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();

		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("greenkrtae.test9@gmail.com");

		driver.findElement(By.cssSelector(".aoT")).click();

		driver.findElement(By.cssSelector(".aoT")).sendKeys("Test mail-4");

		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
		
		Thread.sleep(3000);

		if (driver.getPageSource().contains("Your message has been sent."))
		{
			System.out.println("Test-4 message sent successfully");
		}
		else
			System.out.println("message failed to send");
		
		Thread.sleep(3000);

		driver.findElement(By.id("link_vsm")).click();

		if (driver.findElement(By.className("hP")).getText().equalsIgnoreCase("Test mail-4"))
		{
			System.out.println("verified search box and subject -test4");
		}
		else
			System.out.println("search box and subject are different");
		
//		15. Go to Inbox & select email whose subject contains 'Test mail-2'
		driver.findElement(By.linkText("Inbox")).click();
		if (driver.findElement(By.xpath("//div[@class='y6']/descendant::span[contains(text(), 'Test mail-2')]")).getText().equalsIgnoreCase("Test mail-2"))
		{
			driver.findElement(By.xpath("//div[@class='y6']/descendant::span[contains(text(), 'Test mail-2')]/ancestor::tr/td[@class='oZ-x3 xY']/div")).click();
		}
		
		Thread.sleep(5000);
//		16. Click on 'Delete' button
		driver.findElement(By.cssSelector(".nX.T-I-ax7")).click();
		
		
//		17. Verify message 'The conversation has been moved to the Trash'
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='vh']/descendant::span[contains(text(), 'The conversation has been moved to the Trash')]")).getText(), "The conversation has been moved to the Trash.");
		
//		18. In Inbox, select emails which contain subject 'Test mail-3' & Test mail-4'
		if (driver.findElement(By.xpath("//div[@class='y6']/descendant::span[contains(text(), 'Test mail-3')]")).getText().equalsIgnoreCase("Test mail-3"))
		{
			driver.findElement(By.xpath("//div[@class='y6']/descendant::span[contains(text(), 'Test mail-3')]/ancestor::tr/td[@class='oZ-x3 xY']/div")).click();
		}
		if (driver.findElement(By.xpath("//div[@class='y6']/descendant::span[contains(text(), 'Test mail-4')]")).getText().equalsIgnoreCase("Test mail-4"))
		{
			driver.findElement(By.xpath("//div[@class='y6']/descendant::span[contains(text(), 'Test mail-4')]/ancestor::tr/td[@class='oZ-x3 xY']/div")).click();
		}
		
		Thread.sleep(3000);
		
//		19. Click on 'Delete' button
		driver.findElement(By.cssSelector(".nX.T-I-ax7")).click();
		
//		20. Verify message '2 conversations have been moved to the Trash.'
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='vh']/descendant::span[contains(text(), 'moved to the Trash')]")).getText(), "2 conversations have been moved to the Trash.");
		
//		21. Click on email id in right corner
		driver.findElement(By.cssSelector(".gb_3a.gbii")).click();
		
//		22. Click on 'Sign out' button.
		driver.findElement(By.partialLinkText("Sign out")).click();
		
		//Thread.sleep(5000);
		
		//driver.switchTo().alert().accept();
		
//		23. Verify user gets navigated to 'Login' page
		Assert.assertEquals(driver.getTitle(), "Gmail");
		System.out.println("Logged Out");
		
		driver.close();
	}

}
